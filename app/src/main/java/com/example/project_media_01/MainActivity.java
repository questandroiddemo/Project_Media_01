package com.example.project_media_01;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.project_media_01.Model.MusicFiles;
import com.example.project_media_01.Presenter.Presenter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import AidlPackage.AidlInterface;

public class MainActivity extends AppCompatActivity {
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

//        instance = this;
//        songFrag = new SongsFragment();
//        nowPlayFrag = new NowPlayingFragment();
////        permission();
//        bindToAIDLService();
//        initViewPager();


    }

//    public static MainActivity getInstance(){
//        return instance;
//    }


//
//    private void permission() {
//        if(ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE)
//                != PackageManager.PERMISSION_GRANTED){
//            ActivityCompat.requestPermissions(MainActivity.this,new String[]{
//                    Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE);
//        }
//        else
//        {
//            //musicFiles = getAllAudio(this);
//            musicFiles = presenter.getSongsFromService();
//
//            //initViewPager();
//        }
//    }

//    private void bindToAIDLService() {
//        Intent aidlServiceIntent = new Intent("connect_to_aidl_service");
//
//        bindService(implicitIntentToExplicitIntent(aidlServiceIntent,this),serviceConnectionObject,BIND_AUTO_CREATE);
//    }
//    ServiceConnection serviceConnectionObject =new ServiceConnection() {
//        @Override
//        public void onServiceConnected(ComponentName name, IBinder iBinder) {
//            aidlObject = AidlInterface.Stub.asInterface(iBinder);
//
//        }
//
//        @Override
//        public void onServiceDisconnected(ComponentName name) {
//
//        }
//    };


    //converting implicit intent ot explicit intent
//    public Intent implicitIntentToExplicitIntent(Intent implicitIntent, Context context){
//        PackageManager packageManager = context.getPackageManager();
//        List<ResolveInfo> resolveInfoList = packageManager.queryIntentServices(implicitIntent,0);
//        if(resolveInfoList == null || resolveInfoList.size()!=1){
//            return null;
//        }
//        ResolveInfo serviceInfo = resolveInfoList.get(0);
//        ComponentName component = new ComponentName(serviceInfo.serviceInfo.packageName,serviceInfo.serviceInfo.name);
//        Intent explicitIntent = new Intent(implicitIntent);
//        explicitIntent.setComponent(component);
//        return explicitIntent;
//    }


//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if(requestCode==REQUEST_CODE){
//            if(grantResults[0] == PackageManager.PERMISSION_GRANTED){
//                //do whatever we want permission related
//                //musicFiles = getAllAudio(this);
//                musicFiles = presenter.getSongsFromService();
//                //initViewPager();
//            }
//            else{
//                ActivityCompat.requestPermissions(MainActivity.this,new String[]{
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE},REQUEST_CODE);
//            }
//        }
//    }

//    private void initViewPager() {
//        viewPager= findViewById(R.id.viewpager);
//        tabLayout= findViewById(R.id.tab_layout);
//        viewPagerAdapter= new ViewPagerAdapter(getSupportFragmentManager(), FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
//        viewPagerAdapter.addFragments(new NowPlayingFragment(),"Now playing");
//        viewPagerAdapter.addFragments(new SongsFragment(),"Song List");
//        viewPager.setAdapter(viewPagerAdapter);
//        tabLayout.setupWithViewPager(viewPager);
//    }

//    public void playPauseSong() {
//        try {
//            aidlObject.playPauseSong();
//        } catch (RemoteException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static class ViewPagerAdapter extends FragmentPagerAdapter {
//        private final ArrayList<Fragment> fragments;
//        private final ArrayList<String> titles;
//
//        public ViewPagerAdapter(@NonNull FragmentManager fm, int behaviorResumeOnlyCurrentFragment) {
//            super(fm);
//            this.fragments= new ArrayList<>();
//            this.titles= new ArrayList<>();
//
//        }
//
//        void addFragments(Fragment fragment,String title){
//            fragments.add(fragment);
//            titles.add(title);
//        }
//
//        @NonNull
//        @Override
//        public Fragment getItem(int position) {
//            return fragments.get(position);
//        }
//
//        @Override
//        public int getCount() {
//            return fragments.size();
//        }
//
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return titles.get(position);
//        }
//
//    }
}