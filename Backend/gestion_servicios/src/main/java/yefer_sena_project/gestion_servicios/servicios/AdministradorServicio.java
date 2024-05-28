package yefer_sena_project.gestion_servicios.servicios;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import yefer_sena_project.gestion_servicios.modelo.Administrador;
import yefer_sena_project.gestion_servicios.repositorio.IAdministradorRepositorio;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdministradorServicio {

    private final IAdministradorRepositorio adminRepositorio;

    public List<Administrador> getAdmins(){
        return adminRepositorio.findAll();
    }

    public Optional<Administrador> findAdminById(Integer id){
        return adminRepositorio.findById(id);
    }

    public String saveAdmin (Administrador admin){
        if(adminRepositorio.findByCorreo(admin.getCorreo()).isPresent()){
            return "El administrador con ese correo ya está registrado";
        } else {
            adminRepositorio.save(admin);
            return "¡Administrador creado con éxito!";
        }
    }

    public String updateAdmin (Integer id, Administrador admin){
        Optional<Administrador> adminFind = findAdminById(id);
        if(adminFind.isPresent()){
            adminFind.get().setNombre(admin.getNombre());
            adminFind.get().setCorreo(admin.getCorreo());
            adminFind.get().setContraseña(admin.getContraseña());
            adminRepositorio.save(adminFind.get());
            return "¡Administrador actualizado correctamente!";
        } else {
            return "Administrador con ese ID, no existe.";
        }
    }

    public String delete(Integer id){
        adminRepositorio.deleteById(id);
        return "Administrador eliminado";
    }

    public String login(Map<String, Object> loginBody){
        Optional<Administrador> admin = adminRepositorio.findByCorreo(loginBody.get("correo").toString());
        if(admin.isPresent()){
            String contraseñaBody = (String)loginBody.get("contraseña");
            String contraseñaBD = admin.get().getContraseña();
            if(contraseñaBody.equals(contraseñaBD)){
                return "OK";
            } else {
                return "Credenciales incorrectas, revise e intente nuevamente.";
            }
        } else {
            return "Credenciales incorrectas, revise e intente nuevamente.";
        }
    }
}
