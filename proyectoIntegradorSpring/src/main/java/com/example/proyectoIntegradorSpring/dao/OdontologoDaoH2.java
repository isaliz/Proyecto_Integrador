package com.example.proyectoIntegradorSpring.dao;

import com.example.proyectoIntegradorSpring.dao.iDao;
import com.example.proyectoIntegradorSpring.model.Odontologo;

import java.util.List;

public class OdontologoDaoH2 implements iDao<Odontologo> {


    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL = "jdbc:h2:~/clinicaOdontologica";
    private final static String DB_USER = "sa";
    private final static String DB_PASSWORD = "";

    @Override
    public Odontologo guardar(Odontologo odontologo) {
    return null;
    }

    @Override
    public Odontologo buscar(Integer id) {
        return null;
    }

    @Override
    public void eliminar(Integer id) {

    }

    @Override
    public void actualizar(Odontologo odontologo) {

    }

    @Override
    public List<Odontologo> buscarTodos() {
        return null;
    }

    @Override
    public Odontologo buscarPorString(String valor) {
        return null;
    }
}



