import com.example.proyectoIntegradorSpring.model.Paciente;
import com.example.proyectoIntegradorSpring.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController  //ahora trabajo con vista, no va RestController
@RequestMapping("/paciente")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService= new PacienteService();


    @PostMapping //<<-- me va a permitir crear un nuevo paciente
    public Paciente registrarPaciente(@RequestBody Paciente paciente){
        return pacienteService.guardarPaciente(paciente);
    }
    @PutMapping
    public String actualizarPaciente(@RequestBody Paciente paciente){
       Paciente pacienteBuscado= pacienteService.buscarPorID(paciente.getId());
       if(pacienteBuscado!=null){
           pacienteService.actualizarPaciente(paciente);
           return "Paciente Actualizado con Exito: "+paciente.getNombre();
       }else{
           return "No se pudo actualizar el paciente solicitado: "+paciente.getNombre();
       }
    }

   /* @GetMapping
    public String buscarPorCorreo(Model model, @RequestParam("email") String correo){
        //busqueda la tiene en el paciente
        Paciente paciente= pacienteService.buscarPorEmail(correo);
        model.addAttribute("nombre",paciente.getNombre());
        model.addAttribute("apellido",paciente.getApellido());
        //estos resultados se los debo pasar a la vista
        return "index";
    }*/

}
