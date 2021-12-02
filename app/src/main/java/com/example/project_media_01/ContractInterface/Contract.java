package com.example.project_media_01.ContractInterface;

public interface Contract {
    interface View{
        //updateEditText(String title,String album,String artist , String path);


    }


    interface Presenter{
        void PreviousButtonClick();
        void PlayPauseButtonClick();
        void NextButtonClick();
        //updateSeekBar();

    }


    interface Model{
        void playPreviousSong();
        void playNextSong();
        void playPause();

    }
}
