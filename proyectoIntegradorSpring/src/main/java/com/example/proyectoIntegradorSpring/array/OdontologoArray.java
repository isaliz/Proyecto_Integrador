package com.example.proyectoIntegradorSpring.array;

import com.example.proyectoIntegradorSpring.model.Odontologo;

import java.util.List;
import java.util.logging.Logger;

public class OdontologoArray implements iDAO<Odontologo> {

        private static final Logger LOGGER = Logger.getLogger(String.valueOf(OdontologoArray.class));
        private List<Odontologo> odontologoRepository;

        public OdontologoArray(List<Odontologo> odontologoRepository) {
            this.odontologoRepository = odontologoRepository;
        }

        @Override
        public Odontologo registrar(Odontologo odontologo) {
            odontologo.setMatricula(odontologoRepository.size() + 1);
            odontologoRepository.add(odontologo);
            LOGGER.info("Odontologo guardado:" + odontologo) ;
            return odontologo;
        }

        @Override
        public List<Odontologo> listarTodos() {
            LOGGER.info("Listado de todos los odontologos:\n" + odontologoRepository);
             return odontologoRepository;
        }

    }


