package com.Atividade.satc.oja.repository;

import com.Atividade.satc.oja.enterprise.CustomQuerydslPredicateExecutor;
import com.Atividade.satc.oja.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>, CustomQuerydslPredicateExecutor<Produto> {

}

