package com.example.project_media_01.View;

import java.util.List;

//for nowPlayingFragment
public interface InowPlayingView {
    void setSongDetails(List<String> songDetails);

    void setProgress(int currentPosition);

    void setMax(int totalDuration);
}
