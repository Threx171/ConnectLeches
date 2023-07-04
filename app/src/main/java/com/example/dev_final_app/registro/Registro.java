package com.example.dev_final_app.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.dev_final_app.R;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        //Creamos las variables para extraer el texto nombre, contraseña y fecha de nacimiento:

        EditText nom = findViewById(R.id.TextNom);
        EditText pass = findViewById(R.id.TextPass);
        EditText dia = findViewById(R.id.TextData);
        EditText mes = findViewById(R.id.TextMes);
        EditText año = findViewById(R.id.TextAño);

        //RadioButtons selector de sexo
        RadioButton hombre = findViewById(R.id.menButton);
        RadioButton mujer = findViewById(R.id.menButton);
        RadioButton hombre_trans = findViewById(R.id.MTrans);
        RadioButton mujer_trans = findViewById(R.id.WTrans);

        //RadioButtons preferencias sexuales
        RadioButton pre_hombre = findViewById(R.id.PreMan);
        RadioButton pre_mujer = findViewById(R.id.PreWoman);
        RadioButton pre_bi = findViewById(R.id.PreBisexual);
    }
}