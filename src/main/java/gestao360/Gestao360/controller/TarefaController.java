package gestao360.Gestao360.controller;

import gestao360.Gestao360.model.Tarefa;
import gestao360.Gestao360.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @GetMapping
    public List<Tarefa> listar(){
        return tarefaService.listarTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tarefa> buscarPeloId(@PathVariable Long id){
        return ResponseEntity.ok(tarefaService.buscarPeloId(id));
    }

    @PostMapping
    public ResponseEntity<Tarefa> criar (@RequestBody Tarefa tarefa){
        Tarefa novaTarefa = tarefaService.salvar(tarefa);
        return  ResponseEntity.status(HttpStatus.CREATED).body(novaTarefa);
    }
    public  ResponseEntity<Void> deletar(@PathVariable Long id){
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
