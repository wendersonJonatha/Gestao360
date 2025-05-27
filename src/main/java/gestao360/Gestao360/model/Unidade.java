package gestao360.Gestao360.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "unidade")
public class Unidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUnidade;

    @Column(nullable = false)
    private String nomeUnidade;

    @Column(nullable = false)
    private String cidade;

    @Column(nullable = false)
    private String estado;
}
