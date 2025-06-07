package gestao360.Gestao360.controller;


import gestao360.Gestao360.model.Usuario;
import gestao360.Gestao360.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public List<Usuario> listar(){
        return usuarioService.ListarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPeloId(@PathVariable Long  id){
        return ResponseEntity.ok(usuarioService.buscarPeloId(id));
    }

    @PostMapping
    public ResponseEntity<Usuario> criar( @RequestBody Usuario usuario){
        Usuario novoUsuario = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoUsuario);
    }

    @DeleteMapping("/{id}")
    public  ResponseEntity<Void> deletarUsuarioId(@PathVariable Long id ){
        usuarioService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuarioId(@PathVariable Long id, @RequestBody Usuario usuario){
        try{
            return ResponseEntity.ok(usuarioService.atualizarUsuario(id, usuario));
        } catch (Exception e) {
            return ResponseEntity.noContent().build();
        }
    }
}
