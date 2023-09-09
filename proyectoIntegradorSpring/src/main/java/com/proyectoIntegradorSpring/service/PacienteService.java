package com.proyectoIntegradorSpring.service;

import com.proyectoIntegradorSpring.entity.Paciente;
import com.proyectoIntegradorSpring.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PacienteService {

    private PacienteRepository pacienteRepository;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository) {
        this.pacienteRepository = pacienteRepository;
    }

    //metodos manuales
    public Paciente registrarPaciente(Paciente paciente){
        return pacienteRepository.save(paciente);
    }
    public void actualizarPaciente(Paciente paciente){
         pacienteRepository.save(paciente);
    }
    public void eliminarPaciente(Long id){
        pacienteRepository.deleteById(id);
    }
    public List<Paciente> listarPacientes(){
        return pacienteRepository.findAll();
    }
    public Optional<Paciente> buscarPorId(Long id){
        return pacienteRepository.findById(id);
    }
    public Optional<Paciente> buscarporDNI(Long dni){
        return pacienteRepository.findById(dni);
    }
}
