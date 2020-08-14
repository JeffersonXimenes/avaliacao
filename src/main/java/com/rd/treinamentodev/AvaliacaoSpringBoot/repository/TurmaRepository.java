package com.rd.treinamentodev.AvaliacaoSpringBoot.repository;

import com.rd.treinamentodev.AvaliacaoSpringBoot.model.entity.TurmaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaEntity, Long> {

}
