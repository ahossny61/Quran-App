package com.ahmedhossny61.quran;

public class Surrah {
    private String text;
    private int number;
    public Surrah(String mtext,int mnumber){
        text=mtext;
        number=mnumber;
    }

    public String getText() {
        return text;
    }

    public int getNumber() {
        return number;
    }
}
