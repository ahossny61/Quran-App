package com.ahmedhossny61.quran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.ArrayList;

public class ayaActivity extends AppCompatActivity {
    private ProgressBar progressBar;
    private RecyclerView recyclerView;
    private ArrayList<test>Tests;
    testAdapter mAdapt;
    private String Base_url="http://api.alquran.cloud/v1/surah/";
    private String final_url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aya);
        Bundle extras =getIntent().getExtras();
        int number =extras.getInt("Number");
        String id =extras.getString("id");
        number+=1;
        final_url=Base_url+number+"/"+id;
        //Toast.makeText(this,final_url,Toast.LENGTH_LONG).show();
        progressBar=findViewById(R.id.Progress_par);
        Tests = new ArrayList<>();
        mAdapt = new testAdapter(Tests);
        recyclerView = findViewById(R.id.Custom_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(mAdapt);
        getData();

    }

    Response.Listener<String> listener = new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Tests = JsonResponse.read(response);
            if (Tests.size()!=0) {
                progressBar.setVisibility(View.GONE);
                mAdapt = new testAdapter(Tests);
                recyclerView.setAdapter(mAdapt);

            }
        }
    };

    Response.ErrorListener errorListener = new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {

        }
    };

    private void getData() {

        RequestQueue queue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, final_url, listener, errorListener);
        queue.add(stringRequest);

    }


}
