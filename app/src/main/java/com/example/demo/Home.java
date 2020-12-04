package com.example.demo;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;

public class Home extends AppCompatActivity {

    Button btnThoat, btnPlayer;

    AlertDialog dialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Anhxa();


        AddEvent();

    }

    protected void Anhxa() {
        btnThoat = findViewById(R.id.btn_thoat);
        btnPlayer = findViewById(R.id.btn_player);

    }

    protected void AddEvent() {
        btnThoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowAlertDialog();
            }
        });

        btnPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnPlayer.startAnimation(AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scale_btn));

                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(Home.this, Menu.class);
                        startActivity(intent);
                    }
                }, 100);
            }
        });

    }

    private void ShowAlertDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Game Caro");
        builder.setMessage("Bạn chắc chắn muốn thoát không?");
        builder.setCancelable(false);
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.setNegativeButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });

        dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        ShowAlertDialog();
    }
}
