package com.example.tebaklagu.Model;

import com.example.tebaklagu.R;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;

public class StorageLagu {
    static ArrayList<SoalTebakLagu> soalTebakLagus;
    static ArrayList<String> pilihanSalah;

    static {
        soalTebakLagus = new ArrayList<>();

        soalTebakLagus.add(new SoalTebakLagu(R.raw.boombaya, "Boombayah"));
        soalTebakLagus.add(new SoalTebakLagu(R.raw.fancy, "Fancy"));
        soalTebakLagus.add(new SoalTebakLagu(R.raw.kill_this_love, "Kill This Love"));
        soalTebakLagus.add(new SoalTebakLagu(R.raw.senorita, "Senorita"));
        soalTebakLagus.add(new SoalTebakLagu(R.raw.solo, "Solo"));

        pilihanSalah = new ArrayList<>();
        pilihanSalah.add("Flow");
        pilihanSalah.add("Latata");
        pilihanSalah.add("Bbbi-bbi");
        pilihanSalah.add("Pray");
        pilihanSalah.add("Anjing Kacili");
        pilihanSalah.add("Paris");
        pilihanSalah.add("I'm So Hot");
        pilihanSalah.add("Dalla - Dalla");
        pilihanSalah.add("Gotta go");
        pilihanSalah.add("Gangnam Style");
        pilihanSalah.add("Violetta");
        pilihanSalah.add("Bad Boy");
    }

    public static SoalTebakLagu getLagu(int index) {
        return soalTebakLagus.get(index);
    }

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
