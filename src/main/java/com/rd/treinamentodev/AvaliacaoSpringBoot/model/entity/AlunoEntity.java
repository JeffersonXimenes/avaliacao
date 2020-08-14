package com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "TB_ALUNO")
@Data
@NamedQuery(name = "validarCpf", query = "SELECT * FROM  where =: ?")
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAluno;

    @Column(name = "DS_ALUNO")
    private String nomeAluno;

    @Column(name = "DS_CPF")
    private String cpf;

}
