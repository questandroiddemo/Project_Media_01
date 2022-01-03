/**
 * @file    NowPlayingFragment.java
 *
 * @brief   Fragment for current playing song with its controls
 *
 * @author  Mayukh P V
 */

package com.example.project_media_01;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

    private Context mContext;

   static TextView title1,album1,artist1,totalDuration;
   static ImageView imageView;
   static ImageButton btn_play_pause,btn_previous,btn_next;
   static SeekBar songSeekBar;
    View v;
    boolean playStatus;
    Thread updateSeekBar;
    //int totalDuration=0;
    int cPosition=0;

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
        totalDuration=v.findViewById(R.id.totalDuration);
        presenter = new Presenter();

        //presenter.getSongDetails(0);//to display song details on launch of app plays first mp3file

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

        // Next Button click
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.NextClick();

            }
        });

        // Previous Button click
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.PreviousClick();
            }
        });
        return v; //now playing view
    }

    @Override
    public void setSongDetails(List<String> songDetails) {
        System.out.println("call reached to setSongDetails in nowPlaying");
        System.out.println("songDetails.get(0)  value " +songDetails.get(0));
        title1.setText("Song name   :   "+songDetails.get(0));
        album1.setText("album   :   "+songDetails.get(1));
        artist1.setText("Artist   :   "+songDetails.get(2));
        String totalTime = convertTimeDuration(songDetails.get(4));
        totalDuration.setText(totalTime);//seekbar time at right side


        String uri = songDetails.get(5);
        if(uri!=null){
            byte[] img = uri.getBytes();
            //System.out.println("byte[] img  byte value : "+img);
             if(img!=null) {
                 Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
//                 Glide.with(mContext)
//                         .load(bitmap)
//                         .dontTransform()
//                         .into(imageView);
                    imageView.setImageBitmap(bitmap);
                    //imageView.setImageBitmap(Bitmap.createScaledBitmap(bitmap, imageView.getWidth(), imageView.getHeight(), false));
             }
        }
        else {
            imageView.setImageResource(R.drawable.coverart);

        }


        btn_play_pause.setBackgroundResource(R.drawable.ic_baseline_pause_24);
        playStatus = true;
    }

    private String convertTimeDuration(String timeDuration) {
        int milliseconds = Integer.parseInt(timeDuration);
        String finalTimerString = "";
        String secondsString = "";

        // Convert total duration into time
        int hours = (int) (milliseconds / (1000 * 60 * 60));
        int minutes = (int) (milliseconds % (1000 * 60 * 60)) / (1000 * 60);
        int seconds = (int) ((milliseconds % (1000 * 60 * 60)) % (1000 * 60) / 1000);

        // Add hours if there
        if (hours > 0) {
            finalTimerString = hours + ":";
        }

        // Prepending 0 to seconds if it is one digit
        if (seconds < 10) {
            secondsString = "0" + seconds;
        } else {
            secondsString = "" + seconds;
        }

        finalTimerString = finalTimerString + minutes + ":" + secondsString;

        //      return  String.format("%02d Min, %02d Sec",
        //                TimeUnit.MILLISECONDS.toMinutes(milliseconds),
        //                TimeUnit.MILLISECONDS.toSeconds(milliseconds) -
        //                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milliseconds)));

        // return timer string
        return finalTimerString;
    }

    @Override
    public void setProgress(int currentPosition) {
        songSeekBar.setProgress(currentPosition);
    }

    @Override
    public void setMax(int totalDuration) {
        songSeekBar.setMax(totalDuration);
    }

}