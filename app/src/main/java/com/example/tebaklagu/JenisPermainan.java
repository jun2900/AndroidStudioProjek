package com.example.tebaklagu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class JenisPermainan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jenis_permainan);
        Btn1();
        Btn2();
    }
    private void Btn1(){
        Button next = (Button) findViewById(R.id.tebakLagu);
        System.out.println(next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(JenisPermainan.this, TebakLagu.class);
                startActivity(myIntent);
            }
        });
    }
    private void Btn2(){
        Button next = (Button) findViewById(R.id.tebakPenyanyi);
        System.out.println(next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(JenisPermainan.this, TebakPenyanyi.class);
                startActivity(myIntent);
            }
        });
     }
}
