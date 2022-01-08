package com.ahmedhossny61.quran;

public class test {
    private String test;
    private String audio;
    private String Name;
    private String id;
    public test(String mtest,String maudio){
        test=mtest;
        audio=maudio;
        Name="";
        id="";
    }
    public test(String Name,String id,int x){
        this.Name=Name;
        this.id=id;
        test="";
        audio="";
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public String getAudio() {
        return audio;
    }

    public String getTest() {
        return test;
    }
}
