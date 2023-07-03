package com.example.dev_final_app;

import java.time.LocalDate;
import java.util.Calendar;

public class Persona {



    private String nombre;

    private int edad;

    private int genero;

    private int orientacionSex;

    private int [] rangoEdad = {0,0};

    private LocalDate nacimiento;


    public Persona(String nombre, int genero, int orientacionSex, int[] rangoEdad, int año, int mes, int dia) {
        this.nombre = nombre;

        edad = calcEdad(año, mes, dia);
        this.genero = genero;
        this.orientacionSex = orientacionSex;
        this.rangoEdad = rangoEdad;

    }




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public int[] getRangoEdad() {
        return rangoEdad;
    }

    public void setRangoEdad(int[] rangoEdad) {
        this.rangoEdad = rangoEdad;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }


    public int calcEdad(int año, int mes, int dia){

        Calendar fechaActual = Calendar.getInstance();

        Calendar nacimiento = Calendar.getInstance();
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
