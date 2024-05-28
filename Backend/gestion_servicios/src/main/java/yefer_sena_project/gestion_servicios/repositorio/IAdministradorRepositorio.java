package yefer_sena_project.gestion_servicios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yefer_sena_project.gestion_servicios.modelo.Administrador;

import java.util.Optional;

@Repository
public interface IAdministradorRepositorio extends JpaRepository<Administrador, Integer> {
    Optional<Administrador> findByCorreo(String correo);
}
