package gestao360.Gestao360.service;

import gestao360.Gestao360.model.Tarefa;
import gestao360.Gestao360.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;


    public List<Tarefa> listarTodas(){
         return tarefaRepository.findAll();
    }
    public Tarefa buscarPeloId(Long id){
        return tarefaRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Tarefa não encontrada"));
    }
    public Tarefa salvar(Tarefa tarefa){
        return tarefaRepository.save(tarefa);
    }
    public void deletar(Long id){
        tarefaRepository.deleteById(id);
    }
}
