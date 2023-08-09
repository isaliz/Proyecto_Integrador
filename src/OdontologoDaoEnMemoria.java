import java.util.List;

public class OdontologoDaoEnMemoria implements IDao<Odontologo> {
    private List<Odontologo>odontologoRepositorio;

    public OdontologoDaoEnMemoria(List<Odontologo> odontologoRepositorio) {
        this.odontologoRepositorio = odontologoRepositorio;
    }

    @Override
    public List <Odontologo> buscarTodos() {
        return odontologoRepositorio;
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
