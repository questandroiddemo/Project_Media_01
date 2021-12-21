/**
 * @file    NowPlayingFragment.java
 *
 * @brief   Fragment for current playing song with its controls
 *
 * @author  Mayukh P V
 */

package com.example.project_media_01;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project_media_01.ContractInterface.Contract;
import com.example.project_media_01.Presenter.Presenter;

import java.util.List;

public class NowPlayingFragment extends Fragment implements Contract.NowPlayingView {
    Presenter presenter;

   static TextView title1,album1,artist1;
   static ImageView imageView;
   static ImageButton btn_play_pause,btn_previous,btn_next;
   static SeekBar songSeekBar;
    View v;
    boolean playStatus;

    public NowPlayingFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_now_playing, container, false);
        title1=v.findViewById(R.id.text);
        album1=v.findViewById(R.id.album);
        artist1=v.findViewById(R.id.artist);
        imageView=v.findViewById(R.id.imageView);
        btn_play_pause=v.findViewById(R.id.btn_play_pause);
        btn_next=v.findViewById(R.id.btn_next);
        btn_previous=v.findViewById(R.id.btn_previous);
        songSeekBar=v.findViewById(R.id.songSeekBar);
        presenter = new Presenter();

        //Button click events

        //on play/pause button click
        btn_play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                playStatus= presenter.PlayPauseButtonClick();
                System.out.println("playpause onclick called");
                if(playStatus==true) {
                    btn_play_pause.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
                }
                else {
                    btn_play_pause.setBackgroundResource(R.drawable.ic_baseline_pause_24);
                }

            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.NextClick();

            }
        });
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.PreviousClick();
            }
        });
        return v;
    }
    @Override
    public void setSongDetails(List<String> songDetails) {
        System.out.println("call reached to setSongDetails in nowPlaying");
        System.out.println("songDetails.get(0)  value " +songDetails.get(0));
        title1.setText("Song name   :   "+songDetails.get(0));
        album1.setText("album   :   "+songDetails.get(1));
        artist1.setText("Artist   :   "+songDetails.get(2));
        btn_play_pause.setBackgroundResource(R.drawable.ic_baseline_pause_24);
        playStatus = true;
    }

}