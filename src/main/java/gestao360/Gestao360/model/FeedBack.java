package gestao360.Gestao360.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "FeedBack")
public class FeedBack {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFeedBack;

    @Column(nullable = false)
    private String mensagem;

    @Column(nullable = false)
    private Boolean anonimo;

    @Column(nullable = false, name = "Data_envio")
    private LocalDateTime dataDeEnvio;
}
