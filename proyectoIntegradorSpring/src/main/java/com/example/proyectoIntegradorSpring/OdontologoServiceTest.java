package com.example.proyectoIntegradorSpring;

import Services.OdontologoService;
import com.example.proyectoIntegradorSpring.model.Odontologo;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.assertions.Assertions.assertFalse;
import static com.mongodb.assertions.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class OdontologoServiceTest {

    // JDBC driver nombre base de datos
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:tcp://localhost/~/consultorio";
    //  usuario y contraseña
    static final String USER = "sa";
    static final String PASS = "sa";

        //variable conexion
        private static Connection connection = null;

        //variable statement
        private static Statement stmt = null;
        private static final Logger LOGGER = Logger.getLogger(OdontologoServiceTest.class);

        @BeforeAll
        static void init(){
            LOGGER.info("Creación de la tabla ODONTOLOGOS");

            try {

               // STEP 1: Registro Motor Base de Datos
                Class.forName(JDBC_DRIVER);

                //STEP 2: Estableciendo Conexion
                LOGGER.info("Conetando a la base de datos");
                connection = DriverManager.getConnection(DB_URL,USER,PASS);
                //STEP 3: Creando tabla y cargando registros iniciales
                LOGGER.info("Creando Tabla Odontologos");
                stmt = connection.createStatement();
                String sql =  "DROP TABLE IF EXISTS ODONTOLOGOS;"+
                              "CREATE TABLE ODONTOLOGOS (ID INT AUTO_INCREMENT PRIMARY KEY,NumeroMatricula INT,Nombre VARCHAR(50),Apellido VARCHAR(50))";

                stmt.executeUpdate(sql);

                // STEP 3.1: cargando registros iniciales
                String sqlinsert = "INSERT INTO ODONTOLOGOS (NumeroMatricula,Nombre,Apellido) VALUES " + "(100, 'Sara', 'Guzman'),(101, 'Carlos', 'Carrillo'),(102, 'Ismael', 'Gomez'),(103, 'Esteban', 'Gonzalez')";
                stmt.executeUpdate(sqlinsert);
                // STEP 4: Limpieza variables
                stmt.close();
                connection.close();
                LOGGER.info("Creacion y carga inicial, exitosa");
            } catch (Exception e){
                LOGGER.error("Se genera error creando la tabla ODONTOLOGOS");
                LOGGER.error(e.getMessage());
                e.printStackTrace();
            } finally {
                try {
                    connection.close();
                } catch (Exception ex){
                    LOGGER.error("Se genera error cerrando la conexión");
                    LOGGER.error(ex.getMessage());
                    ex.printStackTrace();
                }
            }
        }


    OdontologoService odontologoService = new OdontologoService(new OdontologoH2Dao());

    @Test
    void AgregarOdontologoH2(){
        LOGGER.info("--------------------------------------------------");
        LOGGER.info("           Test: Agregando un nuevo odontologo       ");
        LOGGER.info("--------------------------------------------------");
        Odontologo ent1 = new Odontologo(104, "Pepito", "Perez");
        Odontologo odontologoInsertado = odontologoService.registrarOdontologo(ent1);

        assertNotNull(odontologoInsertado.getMatricula());
        LOGGER.info("-----------------Fin Test-------------------------");
    }

    @Test
    public void ListarOdontologosH2(){
        LOGGER.info("--------------------------------------------------");
        LOGGER.info("       Test: Listar Odontologos          ");
        LOGGER.info("--------------------------------------------------");


        List<Odontologo> entidadesTest = odontologoService.listarTodosLosOdontologos();
        assertFalse(entidadesTest.isEmpty());
        assertTrue(entidadesTest.size() >= 1);

        LOGGER.info("-----------------Fin Test-------------------------");
        LOGGER.info("-----------------Fin Test-------------------------");
    }



    OdontologoService odontologoServiceMemoria = new OdontologoService(new OdontologoArray(new ArrayList<>()));
    @Test
    void AgregarUnOdontologoArray(){
        LOGGER.info("--------------------------------------------------");
        LOGGER.info("           Test: AgregarUnOdontologo       ");
        LOGGER.info("--------------------------------------------------");
        Odontologo ent1 = new Odontologo(100, "Miguel", "Buitrago");
        odontologoServiceMemoria.registrarOdontologo(ent1);
        Odontologo ent2 = new Odontologo(101, "Pepito", "Perez");
        odontologoServiceMemoria.registrarOdontologo(ent2);
        Odontologo ent3 = new Odontologo(102, "Jacinto", "Ramirez");
        odontologoServiceMemoria.registrarOdontologo(ent3);
        Odontologo ent4 = new Odontologo(103, "Isabel", "Lizarralde");
        odontologoServiceMemoria.registrarOdontologo(ent4);

        LOGGER.info("-----------------Fin Test-------------------------");
    }

   @Test
   public void ListarOdontologosArray(){
            LOGGER.info("--------------------------------------------------");
            LOGGER.info("       Test: Listar todos los odontologos          ");
            LOGGER.info("--------------------------------------------------");
            AgregarUnOdontologoArray();
            List rs =odontologoServiceMemoria.listarTodosLosOdontologos();
             LOGGER.info("-----------------Fin Test-------------------------");
        }

}
