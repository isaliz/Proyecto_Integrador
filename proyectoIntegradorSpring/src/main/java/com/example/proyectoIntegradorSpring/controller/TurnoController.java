package com.example.proyectoIntegradorSpring.controller;

import com.example.proyectoIntegradorSpring.model.Turno;
import com.example.proyectoIntegradorSpring.service.OdontologoService;
import com.example.proyectoIntegradorSpring.service.PacienteService;
import com.example.proyectoIntegradorSpring.service.TurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        if(pacienteService.buscarPorID(turno.getPaciente().getId())!=null){
            //ambos existen
            return ResponseEntity.ok(turnoService.guardarTurno(turno));
                    }
        else{
            return ResponseEntity.badRequest().build();
        }

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Turno> eliminarTurno(@PathVariable("id") Integer id){
        ResponseEntity response = null;
        if (turnoService.buscarPorId(id)==null){
            response=new ResponseEntity(HttpStatus.NOT_FOUND);
        } else{
            turnoService.eliminarTurno(id);
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return response;


    }
    @PutMapping("/actualizar")
    public ResponseEntity<Turno> actualizarTurno(@RequestBody Turno turno){
        OdontologoService odontologoService = new OdontologoService();
        PacienteService pacienteService = new PacienteService();

        ResponseEntity response = null;
        if(turnoService.buscarPorId(turno.getId())==null){
            response = new ResponseEntity(HttpStatus.NOT_FOUND);

        } else{
            response =  ResponseEntity.ok(turnoService.guardarTurno(turno));
        }
        return  response;
    }
    @GetMapping
    public Turno buscar(@PathVariable("id")Integer id){
        return turnoService.buscarPorId(id);
    }
}
