package com.c3.ClinicaOdontologica.repository;

import java.util.List;

public interface iDao<T> {
    T guardar(T t);
    T buscar(Integer id);
    void eliminar(Integer id);
    void actualizar(T t);
    List<T> buscarTodos();
    T buscarPorString(String valor);
}
