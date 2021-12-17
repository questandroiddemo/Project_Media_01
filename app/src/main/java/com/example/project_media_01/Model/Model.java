package com.example.project_media_01.Model;

import android.os.RemoteException;

import com.example.project_media_01.ContractInterface.Contract;
import com.example.project_media_01.MainFragment;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void playPause() {
        //MainActivity.getInstance().playPauseSong();
        try {
            MainFragment.getAidl().playPauseSong();
            System.out.println("MainFragment.getAidl().playPauseSong(); method in model class called");
        } catch (RemoteException e) {
            e.printStackTrace();
        }


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
}
