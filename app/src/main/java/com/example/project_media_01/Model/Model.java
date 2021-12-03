package com.example.project_media_01.Model;

import com.example.project_media_01.ContractInterface.Contract;

import AidlPackage.AidlInterface;

public class Model implements Contract.Model{
//    MusicFiles musicFiles;
//    ListView listSongs;
//    String[] items;
    private AidlInterface aidlObject;


    @Override
    public void getSongsFromService() {
        aidlObject.getAllAudio();
        return;
    }

    @Override
    public void playPreviousSong() {
        aidlObject.playPreviousSong();


    }

    @Override
    public void playNextSong() {
        aidlObject.playNextsong();

    }

    @Override
    public void playPause() {

    }


}
