package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.AlunoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.ResultData;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.AlunoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @PersistenceContext
    private EntityManager cpfTest;

    public boolean testeCpf (String cpf) {
        if (cpfTest.createNamedQuery("validarCpf", AlunoEntity.class).setParameter("", cpf).getResultList() != null) {
            return true;
        }

        return false;
    }

    public ResponseEntity gravar(AlunoDTO alunoDTO) throws Exception{
        ResultData resultData = null;
        AlunoEntity entity = new AlunoEntity();
        entity.setNomeAluno(alunoDTO.getNome());
        entity.setCpf(alunoDTO.getCpf());

        if(resultData != null) {
            return ResponseEntity.badRequest().body(resultData);
        }

        //TODO validar se o CPF existe no banco antes de existir, caso exista retornar mensagem de erro


        // TENTANDO IMPLEMENTAR
        if (testeCpf(alunoDTO.getCpf()))
            return ResponseEntity.badRequest().body(new ResultData(HttpStatus.BAD_REQUEST.value(),"CPF JÁ EXISTENTE!"));
        //


        if(resultData != null) {
            return ResponseEntity.badRequest().body(resultData);
        } else {
           try {
               entity = alunoRepository.save(entity);
               resultData = new ResultData(HttpStatus.CREATED.value(), "Aluno cadastrado com sucesso", entity);
               return ResponseEntity.status(HttpStatus.CREATED).body(resultData);
           } catch (Exception e) {
               resultData = new ResultData(HttpStatus.INTERNAL_SERVER_ERROR.value(), "ERRO AO REGISTRAR O ALUNO", e.getMessage());
               return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(resultData);
           }

       }
    }

    public List<AlunoEntity> cpf(String cpf){
        return alunoRepository.findByCpf(cpf);
    }
}
