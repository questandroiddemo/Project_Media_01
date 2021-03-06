/**
 * @file    SongsFragment.java
 *
 * @brief   Fragment for song list having song name and
 *          its corresponding coverArt
 *
 * @author  Riyas VK
 */

package com.example.project_media_01.View;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_media_01.Presenter.Presenter;
import com.example.project_media_01.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SongsFragment extends Fragment implements IsongListView {
    Presenter presenter;
    RecyclerView recyclerView;
    MusicAdapter musicAdapter;

    public SongsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_songs, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        presenter = new Presenter(this);
        presenter.getAllAudio();//get all song title list only
        return view;
    }

    @Override
    public void setSongList(List<String> allAudio) {
        System.out.println("inside setSongList"+allAudio);
        musicAdapter = new MusicAdapter(getContext(),allAudio);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(musicAdapter);
    }


}