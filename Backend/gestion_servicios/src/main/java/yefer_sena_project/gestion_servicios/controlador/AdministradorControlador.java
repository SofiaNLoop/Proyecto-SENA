package yefer_sena_project.gestion_servicios.controlador;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import yefer_sena_project.gestion_servicios.modelo.Administrador;
import yefer_sena_project.gestion_servicios.modelo.MensajeRespuesta;
import yefer_sena_project.gestion_servicios.servicios.AdministradorServicio;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/v1/admin")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AdministradorControlador {

    private final AdministradorServicio adminService;
    private MensajeRespuesta mensajeRespuesta = new MensajeRespuesta(null);

    @PostMapping(value = "/create")
    public MensajeRespuesta createAdmin(@RequestBody Administrador admin){
        mensajeRespuesta.setMsj(adminService.saveAdmin(admin));
        return mensajeRespuesta;
    }

    @GetMapping(value = "/")
    public List<Administrador> getAllAdmins(){
        return adminService.getAdmins();
    }

    @PutMapping(value = "/update/{id}")
    public MensajeRespuesta updateAdmin(@PathVariable Integer id, @RequestBody Administrador admin){
        mensajeRespuesta.setMsj(adminService.updateAdmin(id, admin));
        return mensajeRespuesta;
    }

    @DeleteMapping(value = "/delete/{id}")
    public MensajeRespuesta deleteAdmin(@PathVariable Integer id){
        mensajeRespuesta.setMsj(adminService.delete(id));
        return mensajeRespuesta;
    }

    @PostMapping(value = "/login")
    public MensajeRespuesta loginAdmin(@RequestBody Map<String, Object> loginBody){
        mensajeRespuesta.setMsj(adminService.login(loginBody));
        return mensajeRespuesta;
    }
}
