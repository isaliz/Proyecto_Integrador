import java.util.List;

public class PacienteService {
    private IDao<Paciente> pacienteIDao;
    public PacienteService(){

    }

    public PacienteService(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }

    public void setPacienteIDao(IDao<Paciente> pacienteIDao) {
        this.pacienteIDao = pacienteIDao;
    }
    public List<Paciente> buscarTodos(){
        return pacienteIDao.buscarTodos();
    }
}
