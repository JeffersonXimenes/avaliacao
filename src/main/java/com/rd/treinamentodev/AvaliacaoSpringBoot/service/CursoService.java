package com.rd.treinamentodev.AvaliacaoSpringBoot.service;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.CursoRepository;
import com.rd.treinamentodev.AvaliacaoSpringBoot.service.bo.CursoBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private CursoBO cursoBO;


    public List<CursoDTO> buscarTodosCursos() {
        List<CursoEntity> listEntity = cursoRepository.findAll();
        List<CursoDTO> listDTO = new ArrayList<>();

        for (CursoEntity entity : listEntity) {
            CursoDTO curso = cursoBO.parseToDTO(entity);
            listDTO.add(curso);
        }
        return  listDTO;
    }

    public void inserirCursos(CursoDTO curso) {
        CursoEntity entity = cursoBO.parseToEntity(curso, null);
        if(curso.getIdCurso() != null) {
            cursoRepository.save(entity);
        }
    }

    // foi apenas teste, porem nao testado
    //public List<CursoEntity> buscarPorCurso(String curso){
    //    return cursoRepository.findByNomeCurso(curso);
    //}

}
