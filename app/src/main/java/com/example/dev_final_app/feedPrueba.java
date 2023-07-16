package com.example.dev_final_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class feedPrueba extends AppCompatActivity {
    RecyclerView feedPubli;
    Persona [] publicaciones;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_prueba);
        //Inicializamos el recycle view.
        feedPubli = findViewById(R.id.feedRecycle);
        //Creamos un administrador del layout, lo insertamos en el recycle y le añadimos un adaptador.
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        feedPubli.setLayoutManager(linearLayoutManager);
        feedPubli.setAdapter(new AdapterFeed());

    }

    class AdapterFeed extends RecyclerView.Adapter <AdapterFeed.AdapterFeedHolder> {
        ImageView imgPerfil;
        TextView nombre;
        TextView fecha;
        TextView publicacion;

        @NonNull
        @Override
        //Este metodo crea una nueva vista del layout con la interfaz de la publicacion.
        public AdapterFeedHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new AdapterFeedHolder(getLayoutInflater().inflate(R.layout.publi_text_layout,parent,false));
        }
        //Este metodo imprime los valores en la interfaz
        @Override
        public void onBindViewHolder(@NonNull AdapterFeedHolder holder, int position) {
           // holder.imprimir(position);
        }
        //Obtiene el length del array de donde extraemos los datos.
        @Override
        public int getItemCount() {
            return publicaciones.length;
        }

        private class AdapterFeedHolder extends RecyclerView.ViewHolder{

            //Relacionamos las variables que hemos creado con los componentes de la interfaz.
            public AdapterFeedHolder(@NonNull View itemView) {
                super(itemView);
                imgPerfil = findViewById(R.id.fotoPerfil);
                nombre =  findViewById(R.id.nombre);
                fecha = findViewById(R.id.fecha);
                publicacion = findViewById(R.id.publi);
            }

            //Este metodo inserta las imagenes y el texto al layout que creamos.
            /*
            public void imprimir(int posicion){

                imgPerfil.setImageAlpha(publicaciones[posicion].getImage());
                nombre.setText((publicaciones[posicion].getNombre()));
                fecha.setText();
                publicacion.setText();
            }
            */


        }






    }






}