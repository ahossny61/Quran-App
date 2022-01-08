package com.ahmedhossny61.quran;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonResponse {
public static ArrayList<test> read(String j){
    try {
        Thread.sleep(2000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    ArrayList<test>Tests=new ArrayList<>();
    try {

        JSONObject root = new JSONObject(j);
        JSONObject data=root.getJSONObject("data");
        JSONArray arr=data.getJSONArray("ayahs");
        for (int i = 0; i <arr.length() ; i++) {
            JSONObject object =arr.getJSONObject(i);
            String audio=object.optString("audio");
            String test_text=object.optString("text");
            Tests.add(new test(test_text,audio));
        }
    } catch (JSONException e) {
        e.printStackTrace();
    }
    return Tests;
}
}
