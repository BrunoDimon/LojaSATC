package com.Atividade.satc.oja.repository;

import com.Atividade.satc.oja.model.Servico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicoRepository extends JpaRepository<Servico, Long>, CustomQuerydslPredicateExecutor<Servico> {
}
