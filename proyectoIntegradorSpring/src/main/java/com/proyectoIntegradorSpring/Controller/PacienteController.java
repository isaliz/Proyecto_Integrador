package com.proyectoIntegradorSpring.Controller;

import com.proyectoIntegradorSpring.entity.Paciente;
import com.proyectoIntegradorSpring.exception.ResourceNotFoundException;
import com.proyectoIntegradorSpring.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    //asociamos la vista con el DAO

    private PacienteService pacienteService;

    @Autowired
    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Paciente>> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.buscarPorId(id));
    }
    @GetMapping
    public ResponseEntity<List<Paciente>> listarPacientes(){
        return ResponseEntity.ok(pacienteService.listarPacientes());
    }
    @PostMapping
    public ResponseEntity<Paciente> registrarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.registrarPaciente(paciente));
    }
    @GetMapping("/buscar/{matricula}")
    public ResponseEntity<Optional<Paciente>> buscarporDNI(@PathVariable Long DNI){
        return ResponseEntity.ok(pacienteService.buscarPorId(DNI));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminarPaciente(@PathVariable Long id){
        Optional<Paciente> pacienteBuscado= pacienteService.buscarPorId(id);
        if(pacienteBuscado.isPresent()){
            pacienteService.eliminarPaciente(id);
            return ResponseEntity.ok("Se elimino correctamente");
        }else{
            return ResponseEntity.badRequest().body("No se encontro lo solicitado para eliminar");
        }
    }
    @PutMapping
    public ResponseEntity<String> actualizarPaciente(@RequestBody Paciente paciente){
        Optional<Paciente> odontologoBuscado= pacienteService.buscarPorId(paciente.getId());
        if(odontologoBuscado.isPresent()){
            pacienteService.actualizarPaciente(paciente);
            return ResponseEntity.ok("Se Actualizo correctamente");
        }else{
            return ResponseEntity.badRequest().body("No se encontro lo solicitado para actualizar");
        }
    }



}
