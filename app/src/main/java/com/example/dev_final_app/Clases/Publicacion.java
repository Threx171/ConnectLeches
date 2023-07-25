package com.example.dev_final_app.Clases;

import android.media.Image;

public class Publicacion {
    //Foto de perfil
    private Image fPerfil;
    //Foto de publicacion: sin uso hasta que se ppuedan publicar fotos.
    private Image fPublicacion;
    //Texto de la publicacion
    private String publicacion;
    //Fecha de publicacion
    private String fechas;
    //Nombre de usuario
    private String nombre;
    //Almacenar al usuario que lo ha publicado(se hablara si se usa)
    private Persona userPubli;

    public Publicacion(String nombre,Image fPerfil,Image fPublicacion, String fecha){

        this.nombre = nombre;

        this.fPerfil = fPerfil;

        this.fPublicacion = fPublicacion;

        this.fechas = fecha;

    }

    public Publicacion(String nombre,Image fPerfil, String fecha, String publicacion){

        this.nombre = nombre;

        this.fPerfil = fPerfil;

        this.publicacion = publicacion;

        this.fechas = fecha;

    }




}
