package com.example.dev_final_app.registro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.dev_final_app.Persona;
import com.example.dev_final_app.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class Registro extends AppCompatActivity {
    //He metido las variables como atributos porque soy asi de chulo
    private EditText nom, pass, dia, mes, año;
    private int edad;
    private RadioButton hombre, mujer, hombre_trans, mujer_trans, pre_hombre, pre_mujer, pre_bi;
    private Button btnContinuar;
    private Persona newUser;
    private DatabaseReference ddbb;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);


        //Creamos las variables para extraer el texto nombre, contraseña y fecha de nacimiento:

        nom = (EditText) findViewById(R.id.TextNom);
        pass = (EditText) findViewById(R.id.TextPass);
        dia = (EditText) findViewById(R.id.TextData);
        mes = (EditText) findViewById(R.id.TextMes);
        año = (EditText) findViewById(R.id.TextAño);

        //RadioButtons selector de sexo
        hombre = (RadioButton) findViewById(R.id.menButton);
        mujer = (RadioButton) findViewById(R.id.womenButton);
        hombre_trans = (RadioButton)findViewById(R.id.MTrans);
        mujer_trans = (RadioButton) findViewById(R.id.WTrans);

        //RadioButtons preferencias sexuales
        pre_hombre = (RadioButton) findViewById(R.id.PreMan);
        pre_mujer = (RadioButton) findViewById(R.id.PreWoman);
        pre_bi = (RadioButton) findViewById(R.id.PreBisexual);

        //Button Continuar
        btnContinuar = (Button) findViewById(R.id.button);

        /*
        Lo comento porque soy subnormal y lo he hecho en tu rama :)

        //Referencia a la base de datos
        mAuth = FirebaseAuth.getInstance();
        ddbb = FirebaseDatabase.getInstance("https://datingbbdd-default-rtdb.europe-west1.firebasedatabase.app").getReference().child("Usuario");

        //Este objeto es el que llevara los datos a la BD
        newUser = new Persona();

        //Metemos listener al boton de continuar, para que meta el usuario con sus datos al clicar
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    //Seteamos datos con las variables recogidas
                    newUser.setNombre(nom.getText().toString());
                    //Comprobacion provisional, si mes es inferior a 1 o superior a 12,
                    //lanzar excepcion
                    newUser.setContraseña(pass.getText().toString());
                    if (Integer.parseInt(mes.getText().toString()) > 12 ||
                        Integer.parseInt(mes.getText().toString()) < 1) {
                        throw new Exception();
                    }
                    //Calculamos edad
                    edad = newUser.calcEdad(
                            Integer.parseInt(año.getText().toString()),
                            Integer.parseInt(mes.getText().toString()),
                            Integer.parseInt(dia.getText().toString())
                    );
                    newUser.setEdad(edad);
                    //Miramos el genero con el que se identifica el usuario
                    if (hombre.isChecked()) {
                        newUser.setGenero(0);
                    } else if (mujer.isChecked()) {
                        newUser.setGenero(1);
                    } else if (hombre_trans.isChecked()) {
                        newUser.setGenero(2);
                    } else if (mujer_trans.isChecked()) {
                        newUser.setGenero(3);
                    }
                    //Miramos la preferencia sexual del usuario
                    if (pre_hombre.isChecked()) {
                        newUser.setOrientacionSex(0);
                    } else if (pre_mujer.isChecked()) {
                        newUser.setOrientacionSex(1);
                    } else if (pre_bi.isChecked()) {
                        newUser.setOrientacionSex(2);
                    }
                    //Enviamos datos a la BD
                    ddbb.push().setValue(newUser);
                    //Volvemos a la pantalla inicial
                    setContentView(R.layout.activity_main);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(),
                            "Los datos no son válidos",
                            Toast.LENGTH_LONG).show();
                }
            }
        });

         */




    }
}