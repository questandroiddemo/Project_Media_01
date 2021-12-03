/**
 * @file    NowPlayingFragment.java
 *
 * @brief   Fragment for current playing song with its controls
 *
 * @author  Mayukh P V
 */

package com.example.project_media_01;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.project_media_01.ContractInterface.Contract;
import com.example.project_media_01.Presenter.Presenter;

public class NowPlayingFragment extends Fragment implements Contract.View {
    Presenter presenter;
   static TextView title1,album1,artist1;
   static ImageView imageView;
   static ImageButton btn_play_pause,btn_previous,btn_next;
   static SeekBar songSeekBar;
    View v;
    static MediaPlayer mediaPlayer;


    public NowPlayingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        title1=view.findViewById(R.id.text);
        album1=view.findViewById(R.id.album);
        artist1=view.findViewById(R.id.artist);
        imageView=view.findViewById(R.id.imageView);

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


        //presenter = new Presenter(this);

        //Button click events

        //on play/pause button click
        btn_play_pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.PlayPauseButtonClick();


            }
        });
        //on previous button click
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.PreviousButtonClick();

            }
        });
        //on next button click
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.NextButtonClick();

            }
        });
        //on seekbar change
        songSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress()); //move it to model or service
            }
        });

        return v;


    }

    //only method call needed no need of definition for update text here
//    public void updateEditText(String title,String album,String artist , String path) {
//
//        title1.setText("TITLE: "+title);
//        album1.setText("ALBUM: "+album);
//        artist1.setText("ARTIST: "+artist);
//        mediaPlayer=new MediaPlayer();
//        try {
//            mediaPlayer.setDataSource(path);
//        } catch (IllegalArgumentException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IllegalStateException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        try {
//            mediaPlayer.prepare();
//        } catch (IllegalStateException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        mediaPlayer.start();
//        if(mediaPlayer.isPlaying()) {
//            System.out.println("playing");
//        }
//        //System.out.println(album);
//    }

}