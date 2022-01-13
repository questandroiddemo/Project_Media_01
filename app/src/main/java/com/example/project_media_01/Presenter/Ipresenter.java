package com.example.project_media_01.Presenter;

public interface Ipresenter {
    void getAllAudio();

    boolean PlayPauseButtonClick();

    void playSong(int position);

    void NextClick();

    void PreviousClick();

    void getSongDetails(int position);

}
