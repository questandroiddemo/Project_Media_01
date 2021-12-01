/**
 * @file    NowPlayingFragment.java
 *
 * @brief   Fragment for current playing song with its controls
 *
 * @author  Riyas VK
 */

package com.example.project_media_01;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.IOException;

public class NowPlayingFragment extends Fragment {
   static TextView title1,album1,artist1;
   static ImageView imageView;
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
        return v;
    }

    public void updateEditText(String title,String album,String artist , String path) {

        title1.setText("TITLE: "+title);
        album1.setText("ALBUM: "+album);
        artist1.setText("ARTIST: "+artist);
        mediaPlayer=new MediaPlayer();
        try {
            mediaPlayer.setDataSource(path);
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            mediaPlayer.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        mediaPlayer.start();
        if(mediaPlayer.isPlaying()) {
            System.out.println("playing");
        }
        //System.out.println(album);
    }
}