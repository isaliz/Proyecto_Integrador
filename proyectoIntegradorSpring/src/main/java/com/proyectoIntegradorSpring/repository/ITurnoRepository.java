package com.proyectoIntegradorSpring.repository;

import com.proyectoIntegradorSpring.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Integer> {
}
