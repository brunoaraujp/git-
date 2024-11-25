package com.bruno.demo_park.api.entidades;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;


@Getter @Setter @NoArgsConstructor
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email" , nullable = false ,unique = true, length = 100)
    private String email;

    @Column(name = "senha" ,nullable = false, length = 200)
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil" , nullable = false ,length = 100 )
    private  perfil perfil;

    @Column(name = "data_Criacao")
    private LocalDateTime dataCriacao;

    @Column(name = "data_Atualizacao")
    private LocalDateTime dataAtualizacao;

    @Column(name = "criado_Por")
    private String criadoPor;

    @Column(name = "atualizado_por")
    private String atualizadoPor;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public enum perfil {
        PERFIL_Usuario,PERFIL_adm
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", perfil=" + perfil +
                ", dataCriacao=" + dataCriacao +
                ", dataAtualizacao=" + dataAtualizacao +
                ", criadoPor='" + criadoPor + '\'' +
                ", atualizadoPor='" + atualizadoPor + '\'' +
                '}';
    }
}
