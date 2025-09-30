package br.com.etechas.tarefas.entity;

import br.com.etechas.tarefas.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "TBL_USUARIO")
@Getter
@Setter
public class Usuario {

    @Id
    @Column(name = "ID_USER")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TX_USERNAME")
    private String username;

    @Column(name = "TX_PASSWORD")
    private String password;

    @Column(name = "TX_ROLE")
    @Enumerated(EnumType.STRING)
    private RoleEnum role;
}
