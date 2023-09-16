package com.proyectoIntegradorSpring.DTO;


import com.proyectoIntegradorSpring.entity.Odontologo;
import com.proyectoIntegradorSpring.entity.Paciente;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@Setter
public class TurnoDTO {

    private Integer id;
    private LocalDate date;
    private LocalTime time;
    private Odontologo odontologo;
    private Paciente paciente;

}
