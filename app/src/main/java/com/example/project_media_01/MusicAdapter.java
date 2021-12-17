/**
 * @file    MusicAdapter.java
 *
 * @brief   Adapter class for song list
 *
 * @author  Riyas VK
 */

package com.example.project_media_01;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project_media_01.Presenter.Presenter;

import java.time.Instant;
import java.util.List;


public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.MyViewHolder>  {
    Presenter presenter;
    private Context mContext;
    //private ArrayList<MusicFiles> mFiles;
    private List<String> allAudio;

    private InterfaceClick listener;
    private Instant Glide;


//    MusicAdapter(Context mContext, List<String> mFiles, InterfaceClick send){
//        this.mContext = mContext;
//        this.mFiles = mFiles;
//        this.listener= send;
//
//    }

    MusicAdapter(Context mContext, List<String> allAudio,InterfaceClick send){
        //this.presenter = presenter;
        this.mContext = mContext;
        this.allAudio=allAudio;
        this.listener= send;
        System.out.println("-------------------"+listener);
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
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       // MusicFiles model = mFiles.get(position);

        //holder.file_name.setText(model.getTitle());
        //holder.file_name.setText(mFiles.get(position).getTitle());
        holder.file_name.setText(allAudio.get(position));

//to diaplay album cover

//        byte[] image = getAlbumArt(mFiles.get(position).getPath());
//        if(image != null){
//            Glide.with(mContext).asBitmap().load(image).into(holder.album_art);
//        }
//        else {
//            Glide.with(mContext).asBitmap().load(R.drawable.ic_launcher_foreground).into(holder.album_art);
//        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("list onclick worked "+allAudio.get(position));
                System.out.println("position--------------- "+position);
                System.out.println("listerner  "+ listener);

                //  Toast.makeText(mContext, model.getTitle(), Toast.LENGTH_SHORT).show();
                //listener.clickFunction(model.getTitle(), model.getAlbum(), model.getArtist(), model.getPath());
                listener.clickFunction(position);
                //presenter.PlayPauseButtonClick();
                //System.out.println("presenter---------------"+ presenter);
                //presenter.playSong();
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