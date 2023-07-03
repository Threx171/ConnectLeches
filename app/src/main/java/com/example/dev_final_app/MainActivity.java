package com.example.dev_final_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.dev_final_app.registro.Registro;

import java.time.LocalDate;
import java.util.Calendar;



public  class MainActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {




            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
        }



        public void registrarAction(View view){

            Intent i = new Intent(this, Registro.class);
            startActivity(i);


        }

    }

