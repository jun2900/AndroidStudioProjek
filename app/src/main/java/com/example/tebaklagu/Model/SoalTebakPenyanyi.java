package com.example.tebaklagu.Model;

public class SoalTebakPenyanyi {
    private int imgid;
    private String penyanyi;

    public SoalTebakPenyanyi(int imgid, String penyanyi){
        this.imgid = imgid;
        this.penyanyi = penyanyi;
    }

    public int getImgid() {
        return imgid;
    }

    public String getPenyanyi(){
        return penyanyi;
    }
}
