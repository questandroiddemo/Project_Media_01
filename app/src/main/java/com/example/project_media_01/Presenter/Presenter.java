package com.example.project_media_01.Presenter;

import com.example.project_media_01.ContractInterface.Contract;
import com.example.project_media_01.Model.Model;
import com.example.project_media_01.NowPlayingFragment;
import com.example.project_media_01.SongsFragment;

import java.util.ArrayList;
import java.util.List;

public class Presenter implements Contract.Presenter {
    Model model= new Model();
    SongsFragment songsFragment;
    Contract.View view;
    Contract.NowPlayingView nowPlayingView;
    Presenter presenter;
    int index=0;
    int songListSize;
    Thread updateSeekBar;
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
        System.out.println("getAllAudio in presenter call out "+model.getAllAudio());
        List<String> songname = new ArrayList<>();
        songname = model.getAllAudio();
        System.out.println("inside getallaudio value of view............. "+view);
        view.setSongList(songname);
    }

    @Override
    public boolean PlayPauseButtonClick() {
        System.out.println("PlayPauseButtonClick ()  called");
        boolean playPauseStatus=model.playPauseSong();
        System.out.println("Song play status in presenter "+playPauseStatus);
        return playPauseStatus;
    }

    @Override
    public void playSong(int position) {
        System.out.println("playSong()  called in presenter-----------------");
        model.playSong(position);
    }

    @Override
    public void getSongDetails(int position) {
        index =position;
        System.out.println("clicked list item index : "+index);
        nowPlayingView= new NowPlayingFragment();
        System.out.println("getSongDetails()  called in presenter-----------------");
        List<String> songDetails;
        songDetails=model.getSongDetails(position);
        System.out.println("inside get song details now playing object value "+nowPlayingView);
        nowPlayingView.setSongDetails(songDetails);
        songListSize = Integer.parseInt(songDetails.get(3));
        System.out.println("song list size in get song list  "+songListSize);

        totalDuration = Integer.parseInt(songDetails.get(4));
        updateSeekBarMethod();

    }

    @Override
    public int getcPosition() {
        int cPosition =  model.getcPosition();
        return cPosition;
    }

    @Override
    public void NextClick() {
        nowPlayingView= new NowPlayingFragment();
        System.out.println("playNextClick()  called in presenter-----------------");
        List<String> songDetails;
        index++;
        System.out.println("song list size inside next click  "+songListSize);

        if(index>5){
            System.out.println("end of the list");
            System.out.println("index : " + index);
            index = 0;
        }
            model.playSong(index);
            songDetails = model.getSongDetails(index);
            System.out.println("inside get song details now playing object value " + nowPlayingView);
            nowPlayingView.setSongDetails(songDetails);
    }

    @Override
    public void PreviousClick() {
        nowPlayingView= new NowPlayingFragment();
        System.out.println("playPrevious()  called in presenter-----------------");

        List<String> songDetails;
        index--;
        if(index<0) {
            System.out.println("reached at first song");
            index=4;
        }
            model.playSong(index);
            songDetails = model.getSongDetails(index);
            System.out.println("inside get song details now playing object value " + nowPlayingView);
            nowPlayingView.setSongDetails(songDetails);
    }



    private void updateSeekBarMethod() {

        //if(currentPosition==0)
           // updateSeekBar.start();

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
                        currentPosition = presenter.getcPosition();
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





}
