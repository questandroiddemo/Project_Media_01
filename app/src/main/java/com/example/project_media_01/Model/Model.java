package com.example.project_media_01.Model;

import android.os.RemoteException;

import com.example.project_media_01.ContractInterface.Contract;
import com.example.project_media_01.MainFragment;

import java.util.ArrayList;
import java.util.List;

public class Model implements Contract.Model{
    MainFragment mainFragment;

    public Model(Contract.Presenter presenter) {
        this.presenter = presenter;
        mainFragment =new MainFragment();
    }
    Contract.Presenter presenter;

    public Model() {

    }
    @Override
    public List<String> getAllAudio() {
        ArrayList<String> songTitle = new ArrayList<>();
        try {
            songTitle= (ArrayList<String>) MainFragment.getAidl().getAllAudio();
            System.out.println(MainFragment.getAidl().getAllAudio());
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return songTitle;
    }

    @Override
    public void playSong(int position) {
        try {
            MainFragment.getAidl().playSong(position);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> getSongDetails(int position) {
        System.out.println("getSongDetails()  called in model -----------------");
        List<String> songDetails = null;
        try {
            System.out.println("song details received at model");
            songDetails= (List<String>) MainFragment.getAidl().getSongDetails(position);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return songDetails;
    }

    @Override
    public int getcPosition() {
        int cPosition = 0;
        try {
            cPosition = mainFragment.getAidl().getcPosition();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return cPosition;
    }

    @Override
    public void seekToCall(int progress) {
        try {
            MainFragment.getAidl().seekToCall(progress);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public boolean playPauseSong() {
        boolean playPauseStatus = false;
        try {
            playPauseStatus=MainFragment.getAidl().playPauseSong();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("playPause in model called");
        return playPauseStatus;
    }

}
