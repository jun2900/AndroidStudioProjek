package com.example.tebaklagu.Model;

import android.media.MediaPlayer;

import java.util.ArrayList;

public class SoalTebakLagu {
    private int mp3id;
    private String judul;


    public SoalTebakLagu(int mp3id, String judul) {
        this.mp3id = mp3id;
        this.judul = judul;
    }

    public int getMp3id() {
        return mp3id;
    }

    public String getJudul() {
        return judul;
    }
}
