package gestao360.Gestao360.service;

import gestao360.Gestao360.model.Usuario;
import gestao360.Gestao360.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario>ListarTodos(){
        return usuarioRepository.findAll();
    }
    public Usuario buscarPeloId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
    }
    public Usuario salvar( Usuario usuario){
        return  usuarioRepository.save(usuario);
    }

    public void  deletar( Long id){
        usuarioRepository.deleteById(id);

    }

    public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado){
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNome(usuarioAtualizado.getNome());
            usuario.setCargo(usuarioAtualizado.getCargo());
            usuario.setEmail(usuarioAtualizado.getEmail());
            usuario.setSenha(usuarioAtualizado.getSenha());
            usuario.setUnidade(usuarioAtualizado.getUnidade());
            return usuarioRepository.save(usuario);
        }).orElseThrow(()-> new RuntimeException("Usuario não encontrado com o id" + id));
    }
}
