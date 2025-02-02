package com.Atividade.satc.oja.Service;

import com.Atividade.satc.oja.model.Produto;
import com.Atividade.satc.oja.model.QProduto;
import com.Atividade.satc.oja.model.Status;
import com.Atividade.satc.oja.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProdutoRepository repository;

    public Produto salvar(Produto entity) {

        if (entity.getValorUnitario() < entity.getPrecoCompra()) {
            throw new ValidationException("O valor unitário não pode ser menos que o preço da compra do produto!");
        }

        if (!repository.findAll(QProduto.produto.descricao.eq(entity.getDescricao())).isEmpty()) {
            throw new ValidationException("Já existe um prduto com essa descrição cadastrada");
        }
        return repository.save(entity);
    }

    public List<Produto> buscaTodos(String filter) {
        return repository.findAll(filter, Produto.class);
    }

    public Page<Produto> buscaTodos(String filter, Pageable pageable) {
        return repository.findAll(filter, Produto.class, pageable);
    }

    public Produto buscaPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Produto alterar(Long id, Produto entity) {
        Optional<Produto> existingProdutoOptional = repository.findById(id);
        if (existingProdutoOptional.isEmpty()) {
            throw new NotFoundException("Produto Não Encontrado");
        }

        Produto existingProduto = existingProdutoOptional.get();

        modelMapper.map(entity, existingProduto);

        return repository.save(existingProduto);
    }
    public void remover(Long id) {
        repository.deleteById(id);
    }

}
