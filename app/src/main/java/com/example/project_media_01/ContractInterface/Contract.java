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
    }

    interface Presenter{
        void getAllAudio();
        void PlayPauseButtonClick();
        void playSong(int position);
        void getSongDetails(int position);
        //void setSongDetails(List<String> songDetails);
//        ArrayList<MusicFiles> getSongsFromService();
//        void PreviousButtonClick();
//        void PlayPauseButtonClick();
//        void NextButtonClick();
        //updateSeekBar();
    }

    interface Model{
        void playPause();
        List<String> getAllAudio();
         void playSong(int position);
        List<String> getSongDetails(int position);
//        void getSongsFromService();
//        void playPreviousSong();
//        void playNextSong();
//        void playPause();
    }
}
