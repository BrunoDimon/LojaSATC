package com.Atividade.satc.oja.resorce;

import
        com.Atividade.satc.oja.Service.NotFoundException;
import com.Atividade.satc.oja.Service.ProdutoService;
import com.Atividade.satc.oja.enterprise.ProdutoDTO;
import com.Atividade.satc.oja.model.Produto;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController extends AbstractController{

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid Produto entity) {
        Produto save = service.salvar(entity);
        return ResponseEntity.created(URI.create("/api/produtos/" + entity.getId())).body(save);
    }

    @GetMapping
    public ResponseEntity findAll(@RequestParam(required = false) String filter,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "10") int size) {
        Page<Produto> produtos = service.buscaTodos(filter, PageRequest.of(page, size));
        Page<ProdutoDTO> produtosDTOS = ProdutoDTO.fromEntity(produtos);
        return ResponseEntity.ok(produtosDTOS);
    }

    @GetMapping("{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Produto produto = service.buscaPorId(id);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity remove(@PathVariable("id") Long id) {
        service.remover(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity update(@PathVariable("id") Long id, @RequestBody Produto entity) {
        try {
            Produto alterado = service.alterar(id, entity);
            return ResponseEntity.ok().body(alterado);
        } catch (NotFoundException nfe) {
            return ResponseEntity.noContent().build();
        }
    }
}
