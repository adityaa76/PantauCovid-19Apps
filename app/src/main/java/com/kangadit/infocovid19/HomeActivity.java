package com.kangadit.infocovid19;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    ImageView homeImg;
    TextView homeText;
    RelativeLayout btnTentang, btnProvinsi;
    Intent tentang, provinsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        homeImg = findViewById(R.id.home_img);
        homeText = findViewById(R.id.home_text);
        btnProvinsi = findViewById(R.id.btn_provinsi);
        btnTentang = findViewById(R.id.btn_tentang_kami);

        btnProvinsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                provinsi = new Intent(HomeActivity.this, MainActivity.class);
                startActivity(provinsi);
            }
        });

        btnTentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 tentang = new Intent(HomeActivity.this, TentangKamiActivity.class);
                 startActivity(tentang);
            }
        });
        home();

    }

    @SuppressLint("SetTextI18n")
    private void home(){
        Calendar calendar = Calendar.getInstance();
        int timeOfDay = calendar.get(Calendar.HOUR_OF_DAY);

        if (timeOfDay >= 0 && timeOfDay < 12){
            homeImg.setImageResource(R.drawable.img_default_half_morning);
        } else if (timeOfDay >= 12 && timeOfDay < 15) {
            homeImg.setImageResource(R.drawable.img_default_half_afternoon);
        } else if (timeOfDay >= 15 && timeOfDay < 18) {
            homeImg.setImageResource(R.drawable.img_default_half_without_sun);
        } else if (timeOfDay >= 18 && timeOfDay < 24) {
            homeImg.setImageResource(R.drawable.img_default_half_night);
        }
    }

}
