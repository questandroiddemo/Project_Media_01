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
        //view.
    }

    @Override
    public void getSongDetails(int position) {
        nowPlayingView= new NowPlayingFragment();
      System.out.println("getSongDetails()  called in presenter-----------------");
        List<String> songDetails = new ArrayList<>();
        songDetails=model.getSongDetails(position);
        System.out.println("inside get song details now playing object value "+nowPlayingView);
        nowPlayingView.setSongDetails(songDetails);
    }

    @Override
    public void NextClick() {
        System.out.println("playNextClick()  called in presenter-----------------");
        //model.playSong(position);
    }

    @Override
    public void PreviousClick() {
        System.out.println("playPrevious()  called in presenter-----------------");
        //model.playSong(position);
    }
}
