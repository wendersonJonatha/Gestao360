package gestao360.Gestao360.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meta")
public class Meta {

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public Long getIdMeta() {
        return idMeta;
    }

    public void setIdMeta(Long idMeta) {
        this.idMeta = idMeta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMeta;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDate prazo;

    @Column(nullable = false)
    private Boolean concluida;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

}
