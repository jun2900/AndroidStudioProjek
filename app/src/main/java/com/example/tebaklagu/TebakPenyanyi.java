package com.example.tebaklagu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tebaklagu.Model.SoalTebakPenyanyi;
import com.example.tebaklagu.Model.StoragePenyanyi;

import java.util.ArrayList;
import java.util.Random;

public class TebakPenyanyi extends AppCompatActivity {
    SoalTebakPenyanyi soalTebakPenyanyi;
    TextView nomorSoal3;
    ImageView gambarPenyanyi;
    Button pilihanA3;
    Button pilihanB3;
    Button pilihanC3;
    Button pilihanD3;

    TextView judulsebenarnya3;
    Button lanjut3;
    int nomorsoal3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebak_penyanyi);

        nomorSoal3 = findViewById(R.id.nomorsoal3);
        gambarPenyanyi = findViewById(R.id.ivPenyanyi);
        pilihanA3 = findViewById(R.id.buttonA3);
        pilihanB3 = findViewById(R.id.buttonB3);
        pilihanC3 = findViewById(R.id.buttonC3);
        pilihanD3 = findViewById(R.id.buttonD3);

        judulsebenarnya3 = findViewById(R.id.penyanyiSebenarnya);
        lanjut3 = findViewById(R.id.lanjut3);

        soalBaru();
    }

    private void soalBaru(){
        soalTebakPenyanyi = StoragePenyanyi.getImg(nomorsoal3);

        nomorsoal3++;
        nomorSoal3.setText(nomorsoal3+".");
        ArrayList<String> jawabansalah= StoragePenyanyi.getPilihanSalah();

        Random random = new Random();
        int posisiJawabanBenar = random.nextInt(4);
        int counter = 0;

        if (posisiJawabanBenar == 0) {
            pilihanA3.setText("A. " + soalTebakPenyanyi.getPenyanyi());
            pilihanA3.setOnClickListener(correct());

        } else {
            pilihanA3.setText("A. "+jawabansalah.get(counter));
            pilihanA3.setOnClickListener(notcorrect());
            counter++;
        }
        if (posisiJawabanBenar == 1) {
            pilihanB3.setText("B. " + soalTebakPenyanyi.getPenyanyi());
            pilihanB3.setOnClickListener(correct());

        } else {
            pilihanB3.setText("B. "+jawabansalah.get(counter));
            pilihanB3.setOnClickListener(notcorrect());
            counter++;
        }
        if (posisiJawabanBenar == 2) {
            pilihanC3.setText("C. " + soalTebakPenyanyi.getPenyanyi());
            pilihanC3.setOnClickListener(correct());

        } else {
            pilihanC3.setText("C. "+jawabansalah.get(counter));
            pilihanC3.setOnClickListener(notcorrect());
            counter++;
        }
        if (posisiJawabanBenar == 3) {
            pilihanD3.setText("D. " + soalTebakPenyanyi.getPenyanyi());
            pilihanD3.setOnClickListener(correct());

        } else {
            pilihanD3.setText("D. "+jawabansalah.get(counter));
            pilihanD3.setOnClickListener(notcorrect());
            counter++;
        }


        ImageView imageView = findViewById(R.id.ivPenyanyi);
        imageView.setImageDrawable(getDrawable(soalTebakPenyanyi.getImgid()));

    }

    private View.OnClickListener correct() {
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
                setCorrect(true);
            }
        };
    }

    public void setCorrect(boolean correct) {
        if (correct) {
            judulsebenarnya3.setText("kamu benar!");
            if (nomorsoal3 == 4) {
                lanjut3.setText("ke main menu");
            }
        } else {
            judulsebenarnya3.setText("kamu salah!");
            nomorsoal3 = 0;

        }
        if (nomorsoal3 == 4 && correct) {
            lanjut3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(TebakPenyanyi.this, MainActivity.class);
                    startActivity(intent);
                }
            });
        }else {
            lanjut3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    judulsebenarnya3.setText("");
                    soalBaru();
                }
            });
        }
    }
}
