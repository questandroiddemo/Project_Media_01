/**
 * @file    NowPlayingFragment.java
 *
 * @brief   Fragment for current playing song with its controls
 *
 * @author  Mayukh P V
 */

package com.example.project_media_01.View;

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

import com.example.project_media_01.Presenter.Presenter;
import com.example.project_media_01.R;

import java.util.List;

public class NowPlayingFragment extends Fragment implements InowPlayingView {
    Presenter presenter;
   static TextView title1,album1,artist1,totalDuration,playerPosition;
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
        totalDuration=v.findViewById(R.id.totalDuration);
        playerPosition=v.findViewById(R.id.playerPosition);
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
                System.out.println("play pause onclick called");
                //play/pause logo changes based on   media player play/pause status
                if(playStatus==true) {
                    //button logo changes to play
                    btn_play_pause.setBackgroundResource(R.drawable.ic_baseline_play_arrow_24);
                }
                else {
                    //button logo changes to pause
                    btn_play_pause.setBackgroundResource(R.drawable.ic_baseline_pause_24);
                }

            }
        });

        // on Next Button click
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.NextClick();
            }
        });

        // on Previous Button click
        btn_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.PreviousClick();
            }
        });
        //on seekbar drag user action
        songSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                System.out.println("progress value"+progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                System.out.println("onStopTrackingTouch "+seekBar.getProgress());
                presenter.seekToCall(seekBar.getProgress());
            }
        });


        return v;
    }

    @Override
    public void setSongDetails(List<String> songDetails) {
        System.out.println("call reached to setSongDetails in nowPlaying");
        System.out.println("songDetails.get(0)  value " +songDetails.get(0));
        title1.setText("Song name   :   "+songDetails.get(0));//to set song title
        album1.setText("album   :   "+songDetails.get(1));//to set album name
        artist1.setText("Artist   :   "+songDetails.get(2));//to set artist name
        String duration = convert(songDetails.get(4));//to convert total duration into minutes and seconds
        totalDuration.setText(duration);//to set total song duration

        String uri = songDetails.get(5);
        if(uri!=null) {
//            byte[] img = uri.getBytes();
//            Bitmap bitmap = BitmapFactory.decodeByteArray(img, 0, img.length);
//            imageView.setImageBitmap(bitmap);
            imageView.setImageResource(R.drawable.coverart);
        }
        else
        {
            imageView.setImageResource(R.drawable.coverart);
        }

        btn_play_pause.setBackgroundResource(R.drawable.ic_baseline_pause_24);
        playStatus = true;
    }

    // to convert millisecond to hour:minutes:second format
    private String convert(String time) {
        int milliseconds= Integer.parseInt(time);
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

        // return timer string in hour:minutes:seconds format
        return finalTimerString;
    }

    @Override
    public void setProgress(int currentPosition) {
        songSeekBar.setProgress(currentPosition);
        //playerPosition.setText(String.valueOf(currentPosition));

    }


    @Override
    public void setMax(int totalDuration) {
        songSeekBar.setMax(totalDuration);
    }

}