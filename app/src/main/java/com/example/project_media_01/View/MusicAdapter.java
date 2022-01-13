/**
 * @file    MusicAdapter.java
 *
 * @brief   Adapter class for song list
 *
 * @author  Mayukh P V
 */

package com.example.project_media_01.View;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_media_01.Presenter.Ipresenter;
import com.example.project_media_01.Presenter.Presenter;
import com.example.project_media_01.R;

import java.util.List;


public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder>  {
    Ipresenter iPresenter;
    private Context mContext;
    private List<String> allAudio;
    MusicAdapter(Context mContext, List<String> allAudio){
        this.mContext = mContext;
        this.allAudio=allAudio;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.music_items,parent,false);
//        return new MyViewHolder(view);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.file_name.setText(allAudio.get(position));
        iPresenter = new Presenter();
        System.out.println("presenter----------------"+iPresenter);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("list onclick worked "+allAudio.get(position));
                System.out.println("position--------------- "+position);
                iPresenter.playSong(position);//plays the selected song
                iPresenter.getSongDetails(position);//get details of selected song
                //viewPager.setCurrentItem(0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return allAudio.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView file_name;
        ImageView album_art;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            file_name = itemView.findViewById(R.id.music_file_name);
            album_art = itemView.findViewById(R.id.music_img);
        }
    }

}