/**
 * @file    Contract.java
 *
 * @brief   interface class - contains model,view,nowPlayingView & presenter interfaces
 *
 *
 * @author  Mayukh P V
 */
package com.example.project_media_01.ContractInterface;

import java.util.List;

public interface Contract {

    //for songListFragment
    interface View{
        //updateEditText(String title,String album,String artist , String path);
        void setSongList(List<String> allAudio);
        //void setSongDetails(List<String> songDetails);
    }

    //for nowPlayingFragment
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
        //updateSeekBar();
    }

    interface Model{
        List<String> getAllAudio();
        void playSong(int position);
        boolean playPauseSong();
        List<String> getSongDetails(int position);
        int getcPosition();
        void seekToCall(int progress);

    }
}
