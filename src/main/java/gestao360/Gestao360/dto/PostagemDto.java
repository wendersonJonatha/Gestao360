package gestao360.Gestao360.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PostagemDto {
     private String titulo;
     private String conteudo;
     private LocalDate data;
     private String categoria;
     private Long usuarioId;


}
