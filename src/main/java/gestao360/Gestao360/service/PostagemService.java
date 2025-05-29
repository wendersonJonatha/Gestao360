package gestao360.Gestao360.service;

import gestao360.Gestao360.dto.PostagemDto;
import gestao360.Gestao360.model.PostagemForum;
import gestao360.Gestao360.model.Usuario;
import gestao360.Gestao360.repository.PostagemForumRepository;
import gestao360.Gestao360.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostagemService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    public PostagemForumRepository postagemForumRepository;


    public List<PostagemForum> listar(){
        return postagemForumRepository.findAll();
    }

    public void deletar(Long id){
        postagemForumRepository.deleteById(id);
    }

    public PostagemForum buscarPeloId(Long id){
        return postagemForumRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Postagem não encontrada"));
    }


    public PostagemForum atualizarPostagem(Long idPostagem, PostagemDto dto) {
        PostagemForum postagem = postagemForumRepository.findById(idPostagem)
                .orElseThrow(() -> new RuntimeException("Postagem não encontrada"));


        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        postagem.setUsuario(usuario);

        postagem.setTitulo(dto.getTitulo());
        postagem.setConteudo(dto.getConteudo());
        postagem.setData(dto.getData());
        postagem.setCategoria(dto.getCategoria());


        return postagemForumRepository.save(postagem);
    }


    public PostagemForum criarPostagem(PostagemDto dto) {
        try {

            if (dto == null) {
                throw new IllegalArgumentException("DTO da postagem não pode ser nulo");
            }
            if (dto.getUsuarioId() == null) {
                throw new IllegalArgumentException("ID do usuário é obrigatório");
            }
            if (dto.getTitulo() == null || dto.getTitulo().trim().isEmpty()) {
                throw new IllegalArgumentException("Título não pode ser vazio");
            }

            Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                    .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));

            PostagemForum postagem = new PostagemForum();
            postagem.setTitulo(dto.getTitulo().trim());
            postagem.setConteudo(dto.getConteudo());
            postagem.setData(dto.getData() != null ? dto.getData() : LocalDate.now());
            postagem.setCategoria(dto.getCategoria());
            postagem.setUsuario(usuario);

            return postagemForumRepository.save(postagem);

        } catch (DataAccessException e) {
            throw new PersistenceException("Erro ao acessar o banco de dados", e);
        }
    }


}
