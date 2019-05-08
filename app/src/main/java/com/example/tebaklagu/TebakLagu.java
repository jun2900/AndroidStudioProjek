package com.example.tebaklagu;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tebaklagu.Model.SoalTebakLagu;
import com.example.tebaklagu.Model.StorageLagu;

import java.util.ArrayList;
import java.util.Random;

public class TebakLagu extends AppCompatActivity {
    SoalTebakLagu soalTebakLagu;
    TextView nomorSoal;
    ImageButton playButton;
    Button pilihanA;
    Button pilihanB;
    Button pilihanC;
    Button pilihanD;

    TextView judulsebenarnya;
    Button lanjut;
    int nomorsoal= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebak_lagu);

        nomorSoal = findViewById(R.id.nomorsoal3);
        playButton = findViewById(R.id.play3);
        pilihanA = findViewById(R.id.buttonA);
        pilihanB = findViewById(R.id.buttonB);
        pilihanC = findViewById(R.id.buttonC);
        pilihanD = findViewById(R.id.buttonD);


        judulsebenarnya = findViewById(R.id.judulSebenarnya);
        lanjut = findViewById(R.id.lanjut);

        soalBaru();

    }

    private void soalBaru(){
        soalTebakLagu = StorageLagu.getLagu(nomorsoal);

        nomorsoal++;
        nomorSoal.setText(nomorsoal+".");
        ArrayList<String> jawabansalah= StorageLagu.getPilihanSalah();

        Random random = new Random();
        int posisiJawabanBenar = random.nextInt(4);

        int counter =0;

        if (posisiJawabanBenar == 0) {
            pilihanA.setText("A. " + soalTebakLagu.getJudul());
            pilihanA.setOnClickListener(correct());

        } else {
            pilihanA.setText("A. "+jawabansalah.get(counter));
            pilihanA.setOnClickListener(notcorrect());
            counter++;
        }

        if (posisiJawabanBenar == 1) {
            pilihanB.setText("B. " + soalTebakLagu.getJudul());
            pilihanB.setOnClickListener(correct());

        } else {
            pilihanB.setText("B. "+jawabansalah.get(counter));
            pilihanB.setOnClickListener(notcorrect());
            counter++;
        }

        if (posisiJawabanBenar == 2) {
            pilihanC.setText("C. " + soalTebakLagu.getJudul());
            pilihanC.setOnClickListener(correct());
        } else {
            pilihanC.setText("C. "+jawabansalah.get(counter));
            pilihanC.setOnClickListener(notcorrect());
            counter++;
        }

        if (posisiJawabanBenar == 3) {
            pilihanD.setText("D. " + soalTebakLagu.getJudul());
            pilihanD.setOnClickListener(correct());
        } else {
            pilihanD.setText("D. "+jawabansalah.get(counter));
            pilihanD.setOnClickListener(notcorrect());
            counter++;
        }

        final MediaPlayer media = MediaPlayer.create(TebakLagu.this, soalTebakLagu.getMp3id());

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                media.start();
            }
        });


    }

    public View.OnClickListener correct() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCorrect(true);
            }
        };
    }

    public View.OnClickListener notcorrect() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCorrect(false);
            }
        };
    }

    public void setCorrect(boolean correct) {
        if (correct) {
            judulsebenarnya.setText("kamu benar!");
            if (nomorsoal == 4) {
                lanjut.setText("ke main menu");
            }
        } else {
            judulsebenarnya.setText("kamu salah!");
            nomorsoal = 0;

        }
        if (nomorsoal == 4 && correct) {
            lanjut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TebakLagu.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }else {
            lanjut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    judulsebenarnya.setText("");
                    soalBaru();
                }
            });
        }
    }


}
