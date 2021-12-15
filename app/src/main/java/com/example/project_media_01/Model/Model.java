package com.example.project_media_01.Model;

import android.os.RemoteException;

import com.example.project_media_01.ContractInterface.Contract;
import com.example.project_media_01.MainFragment;

public class Model implements Contract.Model{
    MainFragment mainFragment;
    Contract.View view;

    public Model(Contract.Presenter presenter) {
        this.presenter = presenter;
        mainFragment =new MainFragment();
    }
    Contract.Presenter presenter;

    public Model() {

    }


//    MusicFiles musicFiles;
//    ListView listSongs;
//    String[] items;



//    @Override
//    public void getSongsFromService() {
//        try {
//            aidlObject.getAllAudio();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//        return;
//    }
//
//    @Override
//    public void playPreviousSong() {
//        try {
//            aidlObject.playPreviousSong();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    @Override
//    public void playNextSong() {
//        try {
//            aidlObject.playNextSong();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//
//    }

    @Override
    public void playPause() {
        //MainActivity.getInstance().playPauseSong();
        try {
            MainFragment.getAidl().playPauseSong();
            System.out.println("MainFragment.getAidl().playPauseSong(); method in model class called");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
//        try {
//           aidlObject.playPauseSong();
//           System.out.println("aidlObject.playPauseSong() method in model class called");
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }

    }
    public void getAllAudio() {
        try {
            MainFragment.getAidl().getAllAudio();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
