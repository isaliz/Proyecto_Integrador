import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    private final static String DB_JDBC_DRIVER = "org.h2.Driver";
    private final static String DB_URL="jdbc:h2:~/test";
    private final static String DB_USER="sa";
    private final static String DB_PASSWORD="";
    @Override
    public List<Odontologo> buscarTodos() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        List<Odontologo>odontologos = new ArrayList<>();
        try{
            Class.forName(DB_JDBC_DRIVER);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Odontologo agregar(Odontologo odontologo) {
        return null;
    }

    @Override
    public Odontologo modificar(Odontologo odontologo) {
        return null;
    }

    @Override
    public void eliminar(Long id) {

    }
}
