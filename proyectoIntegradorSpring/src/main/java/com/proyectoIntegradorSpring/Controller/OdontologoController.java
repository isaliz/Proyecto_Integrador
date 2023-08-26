package com.proyectoIntegradorSpring.Controller;

import com.proyectoIntegradorSpring.entity.Odontologo;
import com.proyectoIntegradorSpring.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    //asociamos la vista con el DAO
    @Autowired
    private OdontologoService odontologoService= new OdontologoService();
    @GetMapping("/{id}")
    public ResponseEntity<Odontologo> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(odontologoService.buscarOdontologo(id));
    }
    @GetMapping
    public ResponseEntity<List<Odontologo>> listarOdontologos(){
        return ResponseEntity.ok(odontologoService.listarTodos());
    }
    @PostMapping
    public ResponseEntity<Odontologo> registrarOdontologo(@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.guardarOdontologo(odontologo));
    }



}
