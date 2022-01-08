package com.ahmedhossny61.quran;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonRead {
    public static ArrayList<test> read(String j){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ArrayList<test>Tests=new ArrayList<>();
        try {

            JSONObject root = new JSONObject(j);
            JSONArray arr=root.getJSONArray("data");
            for (int i = 0; i <arr.length() ; i++) {
                JSONObject object =arr.getJSONObject(i);
                String Language=object.optString("language");
                if(!Language.equals("ar"))
                    continue;
                    String id = object.optString("identifier");
                    String Name = object.optString("englishName");
                    Tests.add(new test(Name, id, 0));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return Tests;
    }
}
