package com.example.dev_final_app;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dev_final_app.registro.Registro;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.time.LocalDate;
import java.util.Calendar;



public  class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText email, password;


    private Button btnLogin;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            //Email y pass
            email = (EditText) findViewById(R.id.editTextText);
            password = (EditText) findViewById(R.id.Pass);

            //Boton login
            btnLogin = (Button) findViewById(R.id.Iniciar);

            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Login

                    mAuth = FirebaseAuth.getInstance();
                    mAuth.signInWithEmailAndPassword(email.getText().toString(),
                                    password.getText().toString())
                            .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        //Login correcto
                                        Log.w(TAG, "signInWithEmail:success");
                                        FirebaseUser user = mAuth.getCurrentUser();
                                        Toast.makeText(MainActivity.this, "Autenticación exitosa.", Toast.LENGTH_SHORT).show();
                                        initSesion(user);
                                    }else{
                                        //Login no correcto, se muestra mensaje al usuario
                                        Log.w(TAG, "signInWithEmail:failure", task.getException());
                                        Toast.makeText(MainActivity.this, "Autenticación erronea.",
                                                Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });

                }



            });


        }



        public void registrarAction(View view){

            Intent i = new Intent(this, Registro.class);
            startActivity(i);


        }
        public void initSesion(FirebaseUser user){

            Intent i = new Intent(this, interApp.class);
           i.putExtra("Usuario", user);
            startActivity(i);


        }
    }

