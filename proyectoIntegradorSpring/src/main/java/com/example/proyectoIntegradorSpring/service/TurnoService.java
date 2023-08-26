package com.example.proyectoIntegradorSpring.service;

import com.example.proyectoIntegradorSpring.dao.TurnoDAOLista;
import com.example.proyectoIntegradorSpring.dao.iDao;
import com.example.proyectoIntegradorSpring.model.Turno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnoService {

    private iDao<Turno> turnoiDao;

   @Autowired
    public TurnoService() {
        turnoiDao= new TurnoDAOLista();
    }

    //metodos manuales
    public List<Turno> obtenerTodosLosTurnos(){
        return turnoiDao.buscarTodos();
    }
    public Turno buscarPorId(Integer id){
        return turnoiDao.buscar(id);
    }
    public void eliminarTurno(Integer id){
        turnoiDao.eliminar(id);
    }
    public void actualizarTurno(Turno turno){
        turnoiDao.actualizar(turno);
    }
    public Turno guardarTurno(Turno turno){
        return turnoiDao.guardar(turno);
    }
}
