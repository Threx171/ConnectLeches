package com.example.dev_final_app.Clases;

import com.example.dev_final_app.ContainerUsers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Persona {

    private String nombre;

    private int edad;

    private int genero;

    private int orientacionSex;

    List <Integer> rangoEdad = new ArrayList <Integer> ();

    private Calendar nacimiento;

    private String contraseña;
    private ContainerUsers likesEnviados;

    private ContainerUsers likesRecibidos;

    private ContainerUsers likesMutuos;


    public Persona() {

    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }

    public int getOrientacionSex() {
        return orientacionSex;
    }

    public void setOrientacionSex(int orientacionSex) {
        this.orientacionSex = orientacionSex;
    }

    public List getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(int edadMin, int edadMax) {

        if(rangoEdad.size() == 0){

            this.rangoEdad.add(edadMin);
            this.rangoEdad.add(edadMax);

        }
        else{
            this.rangoEdad.set(0, edadMin);
            this.rangoEdad.set(1,edadMax);
        }

    }


    public Calendar getNacimiento() {
        return nacimiento;
    }




    public int calcEdad(int año, int mes, int dia){

        Calendar fechaActual = Calendar.getInstance();

        nacimiento = Calendar.getInstance();
        nacimiento.set(año,mes-1,dia);

        int diff = fechaActual.get(Calendar.YEAR) - nacimiento.get(Calendar.YEAR);

        if (nacimiento.get(Calendar.MONTH) > fechaActual.get(Calendar.MONTH) ||
                (nacimiento.get(Calendar.MONTH) == fechaActual.get(Calendar.MONTH) &&
                        nacimiento.get(Calendar.DATE) > fechaActual.get(Calendar.DATE))) {
            diff--;
        }

        return diff;

    }

}
