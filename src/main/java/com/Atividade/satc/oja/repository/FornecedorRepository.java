package com.Atividade.satc.oja.repository;

import com.Atividade.satc.oja.enterprise.CustomQuerydslPredicateExecutor;
import com.Atividade.satc.oja.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>, CustomQuerydslPredicateExecutor<Fornecedor> {
}
