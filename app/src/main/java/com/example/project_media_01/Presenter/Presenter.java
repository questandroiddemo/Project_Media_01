/**
 * @file    Presenter.java
 *
 * @brief   presenter class
 *
 * @author  Mayukh P V
 */
package com.example.project_media_01.Presenter;

import com.example.project_media_01.Model.Model;
import com.example.project_media_01.View.InowPlayingView;
import com.example.project_media_01.View.IsongListView;
import com.example.project_media_01.View.NowPlayingFragment;

import java.util.List;

public class Presenter implements Ipresenter {
    Model model= new Model();
    IsongListView isongListView;
    InowPlayingView iNowPlayingView;
    Presenter presenter;
    int index=0;
    int songListSize;
    Thread updateSeekBar = new Thread();
    int totalDuration;
    int currentPosition;

    public Presenter(IsongListView isongListView) {
        this.isongListView = isongListView;
        model=new Model(presenter);
    }
    public Presenter() {

    }

    @Override
    public void getAllAudio(){
        //System.out.println("getAllAudio in presenter call output "+model.getAllAudio());
        List<String> songsList;
        songsList = model.getAllAudio();
        isongListView.setSongList(songsList); // To set song list in Song List Fragment
    }

    @Override
    public boolean PlayPauseButtonClick() {
        boolean playPauseStatus=model.playPauseSong();
        System.out.println("Song playing status in presenter "+playPauseStatus);
        return playPauseStatus;
    }

    @Override
    public void playSong(int position) {
        model.playSong(position);
    }

    @Override
    public void getSongDetails(int position) {
        index =position;
        iNowPlayingView= new NowPlayingFragment();
        List<String> songDetails;
        //get details of current song
        songDetails=model.getSongDetails(position);

        //to set song details and seekbar timer on nowPlaying view
        iNowPlayingView.setSongDetails(songDetails);
        updateSeekBarMethod(songDetails);
        updateSeekBar.start();

    }

    private void updateSeekBarMethod(List<String> songDetails) {
        System.out.println(" updateSeekBarMethod method called.........");
        totalDuration = Integer.parseInt(songDetails.get(4));
        iNowPlayingView.setMax(totalDuration); //to set total duration of the song on seek bar

        //updateSeekBar.start();
        updateSeekBar =  new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("Thread run method called.........");
                System.out.println("total duration : "+totalDuration);
                System.out.println("current position : "+currentPosition);

                while (totalDuration > currentPosition) {
                    try {
                        sleep(100);
                        currentPosition = model.getcPosition();
                        System.out.println("cposition in thread : "+currentPosition);
                        iNowPlayingView.setProgress(currentPosition);

                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };


    }



    @Override
    public void NextClick() {
        index++;
        System.out.println("playNextClick()  called in presenter-----------------");
        List<String> songDetails;
        songDetails = model.getSongDetails(1);
        songListSize= Integer.parseInt(songDetails.get(3));// to get count of mp3 files

        if(index>=songListSize){
            System.out.println("end of the list");
            System.out.println("index : " + index);
            index = 0;
        }
            model.playSong(index);
            songDetails = model.getSongDetails(index);
            iNowPlayingView= new NowPlayingFragment();
            System.out.println("inside get song details now playing object value " + iNowPlayingView);
            iNowPlayingView.setSongDetails(songDetails);

    }

    @Override
    public void PreviousClick() {
        index--;

        System.out.println("playPrevious()  called in presenter-----------------");
        List<String> songDetails;
        songDetails = model.getSongDetails(1);
        songListSize= Integer.parseInt(songDetails.get(3));// to get count of mp3 files

        if(index<0) {
            System.out.println("reached at first song");
            index=songListSize-1;
        }
            model.playSong(index);
            songDetails = model.getSongDetails(index);
            iNowPlayingView= new NowPlayingFragment();
            System.out.println("inside get song details now playing object value " + iNowPlayingView);
            iNowPlayingView.setSongDetails(songDetails);
    }

    public void seekToCall(int progress) {
        model.seekToCall(progress);//change media player current position on seek bar change
    }
}
