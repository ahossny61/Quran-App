package com.ahmedhossny61.quran;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SiekhAdapter extends ArrayAdapter<test> {
    public SiekhAdapter(Activity context, ArrayList<test> Shiekh) {
        super(context, 0, Shiekh);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View ListItemView = convertView;
        if (ListItemView == null) {
            ListItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_view, parent, false);
        }
        test Current_test = getItem(position);

        TextView name = (TextView) ListItemView.findViewById(R.id.test_text);
        name.setText(Current_test.getName());
        return ListItemView;

    }
}
