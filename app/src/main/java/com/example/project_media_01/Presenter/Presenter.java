package com.example.project_media_01.Presenter;

import com.example.project_media_01.ContractInterface.Contract;
import com.example.project_media_01.Model.Model;
import com.example.project_media_01.SongsFragment;

import java.util.ArrayList;
import java.util.List;

public class Presenter implements Contract.Presenter {
    Model model= new Model();
    SongsFragment songsFragment;
    Contract.View view;
    Presenter presenter;

    public Presenter(Contract.View view) {
        this.view = view;
        model=new Model(presenter);
    }


    @Override
    public void getAllAudio() {

         System.out.println("getAllAudio in presenter call out "+model.getAllAudio());
        List<String> songname = new ArrayList<>();
        songname = model.getAllAudio();
         view.setSongList(songname);
        //songsFragment.setSongList(songname);
    }

    //    @Override
//    public ArrayList<MusicFiles> getSongsFromService() {
//        model.getSongsFromService();
//
//        return null;
//    }
//
//    @Override
//    public void PreviousButtonClick() {
//        model.playPreviousSong();
//    }
//
    @Override
    public void PlayPauseButtonClick() {
        System.out.println("PlayPauseButtonClick ()  called");
        //model.playPause();

    }

    @Override
    public void playSong() {
        System.out.println("playSong()  called-----------------");


    }
//
//    @Override
//    public void NextButtonClick() {
//        model.playNextSong();
//
//    }
}
