package gestao360.Gestao360.service;

import gestao360.Gestao360.model.Unidade;
import gestao360.Gestao360.model.Usuario;
import gestao360.Gestao360.repository.UnidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnidadeService {

    @Autowired
    private UnidadeRepository unidadeRepository;


    public List<Unidade> listarTodos(){
        return unidadeRepository.findAll();
    }

    public Unidade buscarPeloId(Long id){
        return unidadeRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Unidade não encontrada"));
    }
    public Unidade salvar(Unidade unidade){
        return unidadeRepository.save(unidade);
    }

    public void deletar(Long id){
        unidadeRepository.deleteById(id);
    }

    public Unidade atualizarUnidade(Long id ,Unidade unidadeAtualizada){
        return unidadeRepository.findById(id).map(unidade -> {
            unidade.setIdUnidade(unidadeAtualizada.getIdUnidade());
            unidade.setNomeUnidade(unidadeAtualizada.getNomeUnidade());
            unidade.setCidade(unidade.getCidade());
            unidade.setEstado(unidade.getEstado());
            return unidadeRepository.save(unidade);
        }).orElseThrow(() -> new RuntimeException("Unidade não encontrada pelo id " + id));
    }
}
