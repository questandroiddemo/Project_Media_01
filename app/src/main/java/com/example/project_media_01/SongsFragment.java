/**
 * @file    SongsFragment.java
 *
 * @brief   Fragment for song list having song name and
 *          its corresponding coverArt
 *
 * @author  Riyas VK
 */

package com.example.project_media_01;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_media_01.Model.MusicFiles;
import com.example.project_media_01.Presenter.InterfaceClick;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment {
    RecyclerView recyclerView;
    MusicAdapter musicAdapter;
    Button btn ;
    private InterfaceClick listener;
    public SongsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_songs, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

//        ArrayList<MusicFiles> musicFiles = null;
//        if(!(musicFiles.size()<1)){
//            musicAdapter = new MusicAdapter(getContext(),musicFiles,listener);
//            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));
//            recyclerView.setAdapter(musicAdapter);
//        }
//        return view;
        return null;
    }

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof InterfaceClick) {
//            listener = (InterfaceClick) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement FragmentAListener");
//        }
//    }
//    @Override
//    public void onDetach() {
//        super.onDetach();
//        listener = null;
//    }
}