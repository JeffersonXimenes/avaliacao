package com.rd.treinamentodev.AvaliacaoSpringBoot.service.bo;


import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.CursoDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.CursoEntity;
import org.springframework.stereotype.Component;

@Component
public class CursoBO {

    public CursoDTO parseToDTO(CursoEntity entity) {
        CursoDTO cursos = new CursoDTO();

        if (entity == null) {
            return cursos;
        }

        cursos.setIdCurso(entity.getIdCurso());
        cursos.setNome(entity.getNomeCurso());
        cursos.setCargaHoraria(entity.getNrCargaHoraria());

        return cursos;
    }

    public CursoEntity parseToEntity(CursoDTO curso, CursoEntity entity) {
        if (entity == null) {
            entity = new CursoEntity();
        }

        if (curso == null) {
            return entity;
        }

        entity.setIdCurso(curso.getIdCurso());
        entity.setNomeCurso(curso.getNome());
        entity.setNrCargaHoraria(curso.getCargaHoraria());

        return entity;
    }
}
