package gestao360.Gestao360.repository;

import gestao360.Gestao360.model.Unidade;
import gestao360.Gestao360.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
