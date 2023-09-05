package com.proyectoIntegradorSpring.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Paciente {
    private Integer id;
    private String nombre;
    private String apellido;
    private String cedula;
    private LocalDate fechaIngreso;
       private String email;

    public Paciente() {
    }

    public Paciente(String nombre, String apellido, String cedula, LocalDate fechaIngreso,  String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaIngreso = fechaIngreso;
        this.email = email;
    }

    public Paciente(Integer id, String nombre, String apellido, String cedula, LocalDate fechaIngreso, String email) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.fechaIngreso = fechaIngreso;
        this.email = email;
    }
}
