package com.example.proyectoIntegradorSpring.model;


public class Odontologo {
    //Propiedades
    private int ID;
    private int NumeroMatricula;
    private String Nombre;
    private String Apellido;

    public Odontologo(int NumeroMatricula, String Nombre, String Apellido) {
        this.NumeroMatricula = NumeroMatricula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public Odontologo(int ID, int NumeroMatricula, String Nombre, String Apellido) {
        this.NumeroMatricula = NumeroMatricula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getNumeroMatricula() {
        return NumeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        NumeroMatricula = numeroMatricula;
    }

    public String getApellido() {
        return this.Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = Apellido;
    }

    public String getNombre() {return this.Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = Nombre;
    }

    public int getMatricula() {
        return this.NumeroMatricula;
    }

    public void setMatricula(int Numeromatricula) {
        this.NumeroMatricula = NumeroMatricula;
    }

    @Override
    public String toString() {
        return "\n"+"Odontologo: " + NumeroMatricula +  " - " + Nombre + " - " + Apellido;
}
}
