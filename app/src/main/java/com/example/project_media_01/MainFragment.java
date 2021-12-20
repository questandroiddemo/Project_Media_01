package com.example.project_media_01;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.project_media_01.ContractInterface.Contract;
import com.google.android.material.tabs.TabLayout;

import AidlPackage.AidlInterface;

public class MainFragment extends Fragment  {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    static AidlInterface aidlInterface;
    Boolean connected = false;
    Contract.Model model;
    Contract.View view;
    private  InterfaceClick listener;

    View v;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_main, container, false);
        viewPager= (ViewPager) v.findViewById(R.id.viewpager);
        tabLayout= (TabLayout) v.findViewById(R.id.tabLayout);

        ViewPagerAdapter viewPagerAdapter= new ViewPagerAdapter(getActivity().getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPagerAdapter.addFragments(new NowPlayingFragment(),"Now playing");
        viewPagerAdapter.addFragments(new SongsFragment(),"Song List");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);

        //initViewPager();

        Intent intent = new Intent("com.example.mediaservice.AIDL");

        intent.setClassName("com.example.mediaservice",
                "com.example.mediaservice.MediaService");
        if (getActivity().getBaseContext().getApplicationContext().bindService(intent, serviceConnectionObject, Context.BIND_AUTO_CREATE)) {
            connected = true;
            Toast.makeText(getContext(), "Bind service Successful - " + connected, Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getContext(), "BindServiceFailed" + connected, Toast.LENGTH_SHORT).show();

        }
        //return inflater.inflate(R.layout.fragment_main, container, false);
        return v;
    }

    ServiceConnection serviceConnectionObject = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {

            aidlInterface = AidlInterface.Stub.asInterface(iBinder);
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
        }
    };

    public static void playSong(int position) {
        try {
            MainFragment.getAidl().playSong(position);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    public static boolean playPauseSong() {
        boolean playStatus = false;
        try {
            playStatus=MainFragment.getAidl().playPauseSong();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return playStatus;
    }
    public static AidlInterface getAidl(){
        return aidlInterface;
    }

}