package com.proyectoIntegradorSpring.service;

import com.proyectoIntegradorSpring.entity.Odontologo;
import com.proyectoIntegradorSpring.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    private OdontologoRepository odontologoRepository;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    //metodos manuales
    public Odontologo guardarOdontologo(Odontologo odontologo){
        return odontologoRepository.save(odontologo);
    }
    public void actualizarOdontologo(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }
    public void eliminarOdontologo(Long id){
        odontologoRepository.deleteById(id);
    }
    public Optional<Odontologo> buscarPorId(Long id){
        return odontologoRepository.findById(id);
    }
    public Optional<Odontologo> buscarPorMatricula(String matricula){
        return odontologoRepository.findByMatricula(matricula);
    }
    public List<Odontologo> obtenerTodos(){
        return odontologoRepository.findAll();
    }
}
