package com.ahmedhossny61.quran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ArrayList<test>names;
    SiekhAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //
        setContentView(R.layout.activity_main);
       listView=findViewById(R.id.Custom_list_main);
       names=new ArrayList<>();
       mAdapter =new SiekhAdapter(this,names);
        getData();
       listView.setAdapter(mAdapter);

     listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
         @Override
         public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
             test test_object=mAdapter.getItem(i);
             String id =test_object.getId();
             Intent intent=new Intent(MainActivity.this,surrahActivity.class);
             intent.putExtra("id",id);
             startActivity(intent);
         }
     });
    }
    Response.Listener<String> listener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            names = JsonRead.read(response);
            //
            if (names.size()!=0) {
               // Toast.makeText(MainActivity.this,names.size()+"",Toast.LENGTH_LONG).show();
                mAdapter.addAll(names);
                listView.invalidateViews();
            }
        }
    };

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };

    private void getData() {
        String final_url="http://api.alquran.cloud/edition/format/audio";
        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, final_url, listener, errorListener);
        queue.add(stringRequest);

    }


}

