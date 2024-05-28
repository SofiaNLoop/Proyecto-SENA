package yefer_sena_project.gestion_servicios.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yefer_sena_project.gestion_servicios.modelo.Cliente;

@Repository
public interface IClienteRepositorio extends JpaRepository<Cliente, Integer> {
}
