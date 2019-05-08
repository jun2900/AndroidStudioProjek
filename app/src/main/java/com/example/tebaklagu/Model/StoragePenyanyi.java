package com.example.tebaklagu.Model;

import com.example.tebaklagu.R;

import java.util.ArrayList;
import java.util.Random;

public class StoragePenyanyi {
    static ArrayList<SoalTebakPenyanyi> soalTebakPenyanyis;
    static ArrayList<String> pilihanSalah;

    static {
        soalTebakPenyanyis = new ArrayList<>();
        soalTebakPenyanyis.add(new SoalTebakPenyanyi(R.drawable.alan_walker,"Alan Walker"));
        soalTebakPenyanyis.add(new SoalTebakPenyanyi(R.drawable.ariana_grande,"Ariana Grande"));
        soalTebakPenyanyis.add(new SoalTebakPenyanyi(R.drawable.billie_eilish,"Billie eilish"));
        soalTebakPenyanyis.add(new SoalTebakPenyanyi(R.drawable.blackpink,"Blackpink"));
        soalTebakPenyanyis.add(new SoalTebakPenyanyi(R.drawable.ed_sheeran,"Ed Sheeran"));

        pilihanSalah = new ArrayList<>();
        pilihanSalah.add("Marshmello");
        pilihanSalah.add("Michael Jackson");
        pilihanSalah.add("Red Velvet");
        pilihanSalah.add("IU");
        pilihanSalah.add("Beyonce");
        pilihanSalah.add("Mariah Carey");
        pilihanSalah.add("Marshmello");
        pilihanSalah.add("Lady Gaga");
        pilihanSalah.add("Aero Smith");
        pilihanSalah.add("Shawn Mendes");
        pilihanSalah.add("The Chainsmoker");
        pilihanSalah.add("Chad Krueger");
    }

    public static SoalTebakPenyanyi getImg (int index) {return soalTebakPenyanyis.get(index);}

    public static ArrayList<String> getPilihanSalah(){
        Random random = new Random();
        int[] numbers = new int[3];
        int counter = 0;
        while (counter < 3) {
            numbers[counter] = random.nextInt(12);
            boolean same = false;
            if (counter>0) {
                for (int i = counter-1; i >= 0; i--) {
                    if (numbers[i] == numbers[counter]) {   
                        same = true;
                    }
                }
            }
            if (!same) {
                counter++;
            }
        }
        ArrayList<String> pilihansalah = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            pilihansalah.add(pilihanSalah.get(numbers[i]));
        }

        return pilihansalah;
    }
}
