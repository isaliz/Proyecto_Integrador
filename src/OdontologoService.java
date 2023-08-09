import java.util.List;

public class OdontologoService {
    private IDao<Odontologo> odontologoIDao;

    public OdontologoService(){

    }

    public OdontologoService(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }

    public void setOdontologoIDao(IDao<Odontologo> odontologoIDao) {
        this.odontologoIDao = odontologoIDao;
    }
    public List<Odontologo> buscarTodos(){

        return odontologoIDao.buscarTodos();
    }
    public Odontologo agregarOdontologo(Odontologo odontologo){
        odontologoIDao.agregar(odontologo);
        return odontologo;
    }
    public Odontologo modificarOdontologo(Odontologo odontologo){
        odontologoIDao.modificar(odontologo);
        return odontologo;
    }
    public void eliminarOdontologo(Long id){
        odontologoIDao.eliminar(id);
    }
}
