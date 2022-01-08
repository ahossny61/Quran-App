package com.ahmedhossny61.quran;

import android.app.Application;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;

public class testAdapter extends RecyclerView.Adapter<itemHolder> {
  private MediaPlayer player ;
    ArrayList<test>tests=new ArrayList<>();
    public testAdapter(ArrayList<test>t){
        tests=t;
    }
    @NonNull
    @Override
    public itemHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_view, viewGroup, false);

        itemHolder itemViewHolder = new itemHolder(v);

        // انشاء وربط الديزين بالادباتر
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull itemHolder itemViewHolder,final int i) {
    itemViewHolder.test.setText(tests.get(i).getTest());
        itemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   if(player!=null)
                      player.release();
                   player = new MediaPlayer();
                    String url=tests.get(i).getAudio();
                    player.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    player.setDataSource(url);
                    player.prepare();
                    player.start();
                } catch(Exception e) {
                    System.out.println(e.toString());
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return tests.size();
    }
}
