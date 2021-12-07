package com.example.project_media_01.Model;

import android.os.RemoteException;

import com.example.project_media_01.AidlInterface;
import com.example.project_media_01.ContractInterface.Contract;


public class Model implements Contract.Model{
//    MusicFiles musicFiles;
//    ListView listSongs;
//    String[] items;
    private AidlInterface aidlObject;


    @Override
    public void getSongsFromService() {
        try {
            aidlObject.getAllAudio();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return;
    }

    @Override
    public void playPreviousSong() {
        try {
            aidlObject.playPreviousSong();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void playNextSong() {
        try {
            aidlObject.playNextSong();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void playPause() {

    }


}
