package gestao360.Gestao360.controller;

import gestao360.Gestao360.model.Unidade;
import gestao360.Gestao360.service.UnidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/unidade")
public class UnidadeController {

    @Autowired
    private UnidadeService unidadeService;

    @GetMapping
    public List<Unidade> listar(){
        return  unidadeService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Unidade> buscarPeloId(@PathVariable Long id ){
        return ResponseEntity.ok(unidadeService.buscarPeloId(id));
    }

    @PostMapping
    public ResponseEntity<Unidade> criar(@RequestBody Unidade unidade){
        Unidade unidadeNOva = unidadeService.salvar(unidade);
        return ResponseEntity.status(HttpStatus.CREATED).body(unidadeNOva);
    }
    @DeleteMapping("/{id}")
     public ResponseEntity<Void> deletarPeloId(@PathVariable Long id ){
        unidadeService.deletar(id);
        return ResponseEntity.noContent().build();
     }

     @PutMapping("/{id}")
     public ResponseEntity<Unidade> atualizarUnidade(@PathVariable Long id, @RequestBody Unidade unidade){
        try{
            return ResponseEntity.ok(unidadeService.atualizarUnidade(id, unidade));
        } catch (Exception e){
            return ResponseEntity.noContent().build();
        }
     }
}
