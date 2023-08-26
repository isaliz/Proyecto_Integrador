package com.proyectoIntegradorSpring.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Odontologo {
    private Integer id;
    private String matricula;
    private String nombre;
    private String apellido;
}
