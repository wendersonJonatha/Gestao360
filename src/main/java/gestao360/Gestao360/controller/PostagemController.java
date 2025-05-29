package gestao360.Gestao360.controller;

import gestao360.Gestao360.dto.PostagemDto;
import gestao360.Gestao360.model.PostagemForum;
import gestao360.Gestao360.service.PostagemService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/postagem")
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @GetMapping
    public List<PostagemForum> listar(){
        return postagemService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostagemForum> buscarPeloId(@PathVariable Long id){
        return  ResponseEntity.ok(postagemService.buscarPeloId(id));
    }

    @PostMapping
    public ResponseEntity<PostagemForum> criar(@Valid @RequestBody PostagemDto postagemDto){
        PostagemForum novaPostagem = postagemService.criarPostagem(postagemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaPostagem);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        postagemService.deletar(id);
        return ResponseEntity.noContent().build();
    }
    public ResponseEntity<PostagemForum> atualizarPostagem(@PathVariable Long id , @Valid @RequestBody PostagemDto postagemDto){
        PostagemForum postagemAtualizada = postagemService.atualizarPostagem(id, postagemDto);
        return ResponseEntity.ok(postagemAtualizada);
    }

}
