package com.example.project_media_01.ContractInterface;

import com.example.project_media_01.Model.MusicFiles;

import java.util.ArrayList;

public interface Contract {
    interface View{
        //updateEditText(String title,String album,String artist , String path);


    }


    interface Presenter{
        ArrayList<MusicFiles> getSongsFromService();
        void PreviousButtonClick();
        void PlayPauseButtonClick();
        void NextButtonClick();
        //updateSeekBar();

    }


    interface Model{
        void getSongsFromService();
        void playPreviousSong();
        void playNextSong();
        void playPause();


    }
}
