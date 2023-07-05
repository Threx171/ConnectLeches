package com.example.dev_final_app.registro;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.dev_final_app.Persona;
import com.example.dev_final_app.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
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
    private FirebaseDatabase ddbb = FirebaseDatabase.getInstance("https://datingbbdd-default-rtdb.europe-west1.firebasedatabase.app");
    private DatabaseReference usersRef = ddbb.getReference("Users");
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
        //mAuth sera la variable que enchufará el metodo de autenticacion de Firebase
        mAuth = FirebaseAuth.getInstance();
        //Objeto newUser para rellenar los datos del usuario en la BD
        newUser = new Persona();
        //Al clicar en el boton continuar se enviaran los datos si son correctos
        btnContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(nom.getText().toString(),
                        pass.getText().toString()).addOnCompleteListener(Registro.this,
                        new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    //Si se crea el usuario correctamente, mostrarlo en consola
                                    Log.d(TAG, "createUserWithEmail:success");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    //Rellenar datos del usuario nuevo en la base de datos
                                    String uid = user.getUid();//El uid es la id que se genera con la cuenta de correo
                                    DatabaseReference userDataRef = usersRef.child(uid);
                                    //Calculamos edad
                                    edad = newUser.calcEdad(
                                            Integer.parseInt(año.getText().toString()),
                                            Integer.parseInt(mes.getText().toString()),
                                            Integer.parseInt(dia.getText().toString())
                                    );
                                    //Miramos el genero con el que se identifica el usuario
                                    if (hombre.isChecked()) {
                                        userDataRef.child("Genero").setValue(0);
                                    } else if (mujer.isChecked()) {
                                        userDataRef.child("Genero").setValue(1);
                                    } else if (hombre_trans.isChecked()) {
                                        userDataRef.child("Genero").setValue(2);
                                    } else if (mujer_trans.isChecked()) {
                                        userDataRef.child("Genero").setValue(3);
                                    }
                                    //Miramos la preferencia sexual del usuario
                                    if (pre_hombre.isChecked()) {
                                        userDataRef.child("Orientacion").setValue(0);
                                    } else if (pre_mujer.isChecked()) {
                                        userDataRef.child("Orientacion").setValue(1);
                                    } else if (pre_bi.isChecked()) {
                                        userDataRef.child("Orientacion").setValue(2);
                                    }
                                    //Establecemos en la base de datos el resto de datos del usuario
                                    userDataRef.child("Nombre").setValue(nom.getText().toString());
                                    userDataRef.child("Edad").setValue(edad);
                                    userDataRef.child("Contraseña").setValue(pass.getText().toString());

                                }else{
                                    //Si falla el registro, se muestra
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(Registro.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}