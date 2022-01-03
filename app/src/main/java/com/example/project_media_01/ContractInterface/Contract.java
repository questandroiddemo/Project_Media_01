package com.example.project_media_01.ContractInterface;

import java.util.List;

public interface Contract {
    interface View{
        //updateEditText(String title,String album,String artist , String path);
        void setSongList(List<String> allAudio);
        //void setSongDetails(List<String> songDetails);
    }
    interface NowPlayingView{
        void setSongDetails(List<String> songDetails);
        void setProgress(int currentPosition);
        void setMax(int totalDuration);
    }

    interface Presenter{
        void getAllAudio();
        boolean PlayPauseButtonClick();
        void playSong(int position);
        void NextClick();
        void PreviousClick();
        void getSongDetails(int position);
        int getcPosition();

        //void setSongDetails(List<String> songDetails);
//        ArrayList<MusicFiles> getSongsFromService();
//        void PreviousButtonClick();
//        void PlayPauseButtonClick();
//        void NextButtonClick();
        //updateSeekBar();
    }

    interface Model{
        List<String> getAllAudio();
        void playSong(int position);
        boolean playPauseSong();
        List<String> getSongDetails(int position);
        int getcPosition();

    }
}
