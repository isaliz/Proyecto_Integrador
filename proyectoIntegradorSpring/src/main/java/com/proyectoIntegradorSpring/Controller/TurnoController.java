package com.proyectoIntegradorSpring.Controller;

import com.proyectoIntegradorSpring.entity.Turno;
import com.proyectoIntegradorSpring.service.OdontologoService;
import com.proyectoIntegradorSpring.service.PacienteService;
import com.proyectoIntegradorSpring.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnoController {
    @Autowired
    private TurnoService turnoService= new TurnoService();
    @GetMapping
    public ResponseEntity<List<Turno>> buscarTodos(){
        return ResponseEntity.ok(turnoService.obtenerTodosLosTurnos());
    }
    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno){
        //aca tengo el primer filtro
        OdontologoService odontologoService= new OdontologoService();
        PacienteService pacienteService= new PacienteService();
        if(pacienteService.buscarPorID(turno.getPaciente().getId())!=null&&odontologoService.buscarOdontologo(turno.getOdontologo().getId())!=null){
            //ambos existen
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
                    }
        else{
            return ResponseEntity.badRequest().build();
        }

    }
}
