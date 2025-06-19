package gestao360.Gestao360.service;

import gestao360.Gestao360.model.Meta;
import gestao360.Gestao360.repository.MetaRepository;
import gestao360.Gestao360.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetaService {

    @Autowired
    private  MetaRepository metaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Meta> listar(){
        return metaRepository.findAll();
    }
    public  void deletar(Long id){
        metaRepository.deleteById(id);
    }
    public Meta buscarPeloId(Long id){
        return metaRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Meta não encontrada."));
    }

    public  Meta atualizarMeta(Long id, Meta metaAtualizada){
        return metaRepository.findById(id).map(meta-> {
            meta.setDescricao(metaAtualizada.getDescricao());
            meta.setPrazo(metaAtualizada.getPrazo());
            meta.setConcluida(metaAtualizada.getConcluida());
            meta.setUsuario(metaAtualizada.getUsuario());
            return  metaRepository.save(meta);
        }).orElseThrow(()-> new RuntimeException("Meta não encontrada pelo id " + id));
    }
}
