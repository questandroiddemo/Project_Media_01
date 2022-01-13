package com.example.project_media_01.Model;

import java.util.List;

public interface Imodel {
    List<String> getAllAudio();

    void playSong(int position);

    boolean playPauseSong();

    List<String> getSongDetails(int position);

    int getcPosition();

    void seekToCall(int progress);

}
