package com.example.project_media_01;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.project_media_01.Model.MusicFiles;
import com.example.project_media_01.Presenter.Presenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    Presenter presenter;
    public static final int REQUEST_CODE = 1;
    SongsFragment songFrag;
    NowPlayingFragment nowPlayFrag;
    ViewPager viewPager;
    TabLayout tabLayout;
    ViewPagerAdapter viewPagerAdapter;
    static ArrayList<MusicFiles> musicFiles;
    private AidlInterface iMyAidlInterface;
    Boolean connected=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        songFrag = new SongsFragment();
        nowPlayFrag = new NowPlayingFragment();
      //  permission();
//        bindToAIDLService();
        Intent intent = new Intent("com.example.project_media_service_01.AIDL");

        intent.setClassName("com.example.project_media_service_01",
                "com.example.project_media_service_01.MyService");
        if(getBaseContext().getApplicationContext().bindService(intent, serviceCon, Context.BIND_AUTO_CREATE)){
            connected=true;
            Toast.makeText(getApplicationContext(), "BindServiceSuccess", Toast.LENGTH_SHORT).show();
            System.out.println("Binding success");
        }else
            System.out.println("Failed");
        Toast.makeText(getApplicationContext(), "BindServiceFailed", Toast.LENGTH_SHORT).show();

    }
    private final ServiceConnection serviceCon=new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            iMyAidlInterface = AidlInterface.Stub.asInterface(iBinder);
            initViewPager();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    private void permission() {
        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE);
        }
        else
        {
            //musicFiles = getAllAudio(this);
            musicFiles = presenter.getSongsFromService();

            initViewPager();
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==REQUEST_CODE){
            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
                //do whatever we want permission related
                //musicFiles = getAllAudio(this);
                musicFiles = presenter.getSongsFromService();
                initViewPager();
            }
            else{
                ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE);
            }
        }
    }

    private void initViewPager() {
        viewPager= findViewById(R.id.viewpager);
        tabLayout= findViewById(R.id.tab_layout);
        viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new NowPlayingFragment(),"Now playing");
        viewPagerAdapter.addFragments(new SongsFragment(),"Song List");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
    public static class ViewPagerAdapter extends FragmentPagerAdapter {
        private final ArrayList<Fragment> fragments;
        private final ArrayList<String> titles;

        public ViewPagerAdapter(@NonNull FragmentManager fm) {
            super(fm);
            this.fragments= new ArrayList<>();
            this.titles= new ArrayList<>();

        }

        void addFragments(Fragment fragment,String title){
            fragments.add(fragment);
            titles.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }

    }
}