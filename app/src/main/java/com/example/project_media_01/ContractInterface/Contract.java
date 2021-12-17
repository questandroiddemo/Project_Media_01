package com.example.project_media_01.ContractInterface;

import java.util.List;

public interface Contract {
    interface View{
        //updateEditText(String title,String album,String artist , String path);
        void setSongList(List<String> allAudio);
    }

    interface Presenter{
        void getAllAudio();
        void PlayPauseButtonClick();
        void playSong();
//        ArrayList<MusicFiles> getSongsFromService();
//        void PreviousButtonClick();
//        void PlayPauseButtonClick();
//        void NextButtonClick();
        //updateSeekBar();
    }

    interface Model{
        void playPause();
        List<String> getAllAudio();
//          void playPause();
//        void getSongsFromService();
//        void playPreviousSong();
//        void playNextSong();
//        void playPause();
    }
}
