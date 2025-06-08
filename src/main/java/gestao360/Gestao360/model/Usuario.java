package gestao360.Gestao360.model;

import gestao360.Gestao360.enums.Cargo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario {




        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_usuario")
        private Long idUsuario;

        @Column(nullable = false)
        private String nome;

        @Column(nullable = false, unique = true)
        private String email;

        @Column(nullable = false)
        private String senha;

        @Enumerated(EnumType.STRING)
        @Column(nullable = false)
        private Cargo cargo;

        @ManyToOne
        @JoinColumn(name = "Unidade_id", nullable = false)
        private Unidade unidade;


        public Long getIdUsuario() {
                return idUsuario;
        }

        public void setIdUsuario(Long idUsuario) {
                this.idUsuario = idUsuario;
        }

        public String getNome() {
                return nome;
        }

        public void setNome(String nome) {
                this.nome = nome;
        }

        public String getEmail() {
                return email;
        }

        public void setEmail(String email) {
                this.email = email;
        }

        public String getSenha() {
                return senha;
        }

        public void setSenha(String senha) {
                this.senha = senha;
        }

        public Cargo getCargo() {
                return cargo;
        }

        public void setCargo(Cargo cargo) {
                this.cargo = cargo;
        }

        public Unidade getUnidade() {
                return unidade;
        }

        public void setUnidade(Unidade unidade) {
                this.unidade = unidade;
        }
    }


