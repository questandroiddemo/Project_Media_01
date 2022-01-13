package com.example.project_media_01.Model;

import android.os.RemoteException;

import com.example.project_media_01.Presenter.Ipresenter;
import com.example.project_media_01.View.MainFragment;

import java.util.ArrayList;
import java.util.List;

public class Model implements Imodel {
    MainFragment mainFragment;
    Ipresenter iPresenter;

    public Model(Ipresenter iPresenter) {
        this.iPresenter = iPresenter;
        mainFragment =new MainFragment();
    }

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
