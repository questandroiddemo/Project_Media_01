package com.example.project_media_01.Presenter;

import com.example.project_media_01.ContractInterface.Contract;
import com.example.project_media_01.Model.Model;

public class Presenter implements Contract.Presenter {
    Model model;


    @Override
    public void PreviousButtonClick() {

        model.playPreviousSong();
    }

    @Override
    public void PlayPauseButtonClick() {
        model.playPause();

    }

    @Override
    public void NextButtonClick() {
        model.playNextSong();

    }
}
