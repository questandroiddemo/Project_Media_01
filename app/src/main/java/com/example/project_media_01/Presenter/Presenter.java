/**
 * @file    Presenter.java
 *
 * @brief   presenter class
 *
 * @author  Mayukh P V
 */
package com.example.project_media_01.Presenter;

import com.example.project_media_01.ContractInterface.Contract;
import com.example.project_media_01.MainFragment;
import com.example.project_media_01.Model.Model;
import com.example.project_media_01.NowPlayingFragment;

import java.util.List;

public class Presenter implements Contract.Presenter {
    Model model= new Model();
    Contract.View view;
    Contract.NowPlayingView nowPlayingView;
    Presenter presenter;
    MainFragment mainFragment;
    int index=0;
    int songListSize;
    Thread updateSeekBar= new Thread();
    int totalDuration;
    int currentPosition;

    public Presenter(Contract.View view) {
        this.view = view;
        model=new Model(presenter);
    }
    public Presenter() {

    }


    @Override
    public void getAllAudio(){
        //System.out.println("getAllAudio in presenter call output "+model.getAllAudio());
        List<String> songsList;
        songsList = model.getAllAudio();
        view.setSongList(songsList);
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
        nowPlayingView= new NowPlayingFragment();
        List<String> songDetails;

        //get details of current song
        songDetails=model.getSongDetails(position);

        //to set song details and seekbar timer on nowPlaying view
        nowPlayingView.setSongDetails(songDetails);
        updateSeekBarMethod();

    }

    private void updateSeekBarMethod() {
        System.out.println(" updateSeekBarMethod method called.........");

        updateSeekBar.start();
        updateSeekBar =  new Thread() {
            @Override
            public void run() {
                super.run();
                System.out.println("Thread run method called.........");
                // int totalDuration = mediaPlayer.getDuration();
                while (totalDuration > currentPosition) {
                    try {
                        sleep(100);
                        //currentPosition = mediaPlayer.getCurrentPosition();
                        //cPosition = iMyAidlInterface.getcPosition();
                        currentPosition = model.getcPosition();
                        System.out.println("cposition in presenter : "+currentPosition);
                        nowPlayingView.setProgress(currentPosition);
                        nowPlayingView.setMax(totalDuration);
                        //songSeekBar.setProgress(currentPosition);
                        //songSeekBar.setMax(totalDuration);

                        System.out.println("cPosition value is ........."+currentPosition);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
    }


    @Override
    public int getcPosition() {
        int cPosition =  model.getcPosition();
        return cPosition;
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
            System.out.println("inside get song details now playing object value " + nowPlayingView);
            nowPlayingView= new NowPlayingFragment();
            nowPlayingView.setSongDetails(songDetails);

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
            System.out.println("inside get song details now playing object value " + nowPlayingView);
            nowPlayingView= new NowPlayingFragment();
            nowPlayingView.setSongDetails(songDetails);
    }


//    private void updateSeekBarMethod() {
//        System.out.println(" updateSeekBarMethod method called.........");
//
//        //if(currentPosition==0)
//        updateSeekBar.start();
//
//        updateSeekBar =  new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                System.out.println("Thread run method called.........");
//                // int totalDuration = mediaPlayer.getDuration();
//                while (totalDuration > currentPosition) {
//                    try {
//                        sleep(100);
//                        //currentPosition = mediaPlayer.getCurrentPosition();
//                        //cPosition = iMyAidlInterface.getcPosition();
//                        currentPosition = model.getcPosition();
//                        System.out.println("cposition in presenter : "+currentPosition);
//                        nowPlayingView.setProgress(currentPosition);
//                        nowPlayingView.setMax(totalDuration);
//                        //songSeekBar.setProgress(currentPosition);
//                        //songSeekBar.setMax(totalDuration);
//
//                        System.out.println("cPosition value is ........."+currentPosition);
//                    }
//                    catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//    }



}
