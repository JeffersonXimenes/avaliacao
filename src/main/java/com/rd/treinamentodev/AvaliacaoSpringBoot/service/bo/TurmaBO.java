package com.rd.treinamentodev.AvaliacaoSpringBoot.service.bo;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.dto.TurmaDTO;
import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import com.rd.treinamentodev.AvaliacaoSpringBoot.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TurmaBO {

    @Autowired
    private TurmaRepository turmaRepository;

    public TurmaDTO parseToDTO(TurmaEntity entity) {
        TurmaDTO turma = new TurmaDTO();

        if (entity == null) {
            return null;
        }
        // TODO


        return null;

    }

}
