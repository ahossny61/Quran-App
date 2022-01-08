package com.ahmedhossny61.quran;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class itemHolder extends RecyclerView.ViewHolder {
    TextView test;
    public itemHolder(@NonNull View itemView) {
        super(itemView);
        test=itemView.findViewById(R.id.test_text);
    }
}
