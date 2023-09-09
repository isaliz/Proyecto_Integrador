package com.proyectoIntegradorSpring.entity;


//import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
//import java.util.HashSet;
//import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "odontologos")
@Entity
public class Odontologo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String matricula;
    @Column
    private String nombre;
    @Column
    private String apellido;
   /* @OneToMany(mappedBy ="odontologo", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Turno> turnos= new HashSet<>();


    /se tiene documentado hasta crear la clase turno
*/
}