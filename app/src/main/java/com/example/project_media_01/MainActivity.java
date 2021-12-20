package com.example.project_media_01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.project_media_01.Model.MusicFiles;
import com.example.project_media_01.Presenter.Presenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import AidlPackage.AidlInterface;

public class MainActivity extends AppCompatActivity implements InterfaceClick{
    Presenter presenter;
    public static final int REQUEST_CODE = 1;
    SongsFragment songFrag;
    NowPlayingFragment nowPlayFrag;
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    static ArrayList<MusicFiles> musicFiles;
    private AidlInterface aidlObject;
    private static MainActivity instance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportFragmentManager().findFragmentById(android.R.id.content)==null) {
            getSupportFragmentManager().beginTransaction()
                    .add(android.R.id.content, new MainFragment())
                    .setReorderingAllowed(true)
                    .commit();
        }

    }

    @Override
    public void clickFunction(int position) {
        System.out.println("reached at clickFunction");
        System.out.println("presenter "+presenter);
        presenter.playSong(position);

    }

}