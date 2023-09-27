package com.Atividade.satc.oja.health;

import ch.qos.logback.core.net.server.Client;
import com.Atividade.satc.oja.model.*;
import com.Atividade.satc.oja.repository.ClienteRepository;
import com.Atividade.satc.oja.repository.ProdutoRepository;
import com.Atividade.satc.oja.repository.ServicoRepository;
import com.Atividade.satc.oja.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HealthCheckController {

    @Autowired
    public ProdutoRepository produtoRepository;

    @Autowired
    public ServicoRepository servicoRepository;

    @Autowired
    public ClienteRepository clienteRepository;

    @Autowired
    public VendaRepository vendaRepository;

    @GetMapping("/health")
    public String healthCheck(){
        return "Ok";
    }
    @GetMapping("/teste")
    public String healthCheck2(){
        Produto produto = new Produto();
        produto.setDescricao("Intel Pentium I5");
        produto.setNome("PC Intel");
        produto.setValorUnitario(1000.00);
        produto.setDataPrazo(LocalDate.now());
        produto.setPrecoCompra(850.00);
        produto.setStatus(Status.ATIVO);
        produto.setEstocavel(Boolean.TRUE);

        produtoRepository.save(produto);


        Servico servico = new Servico();
        servico.setQuantidadeHoras(20.00);
        servico.setDescricao("Instalação Office");
        servico.setEstocavel(Boolean.TRUE);
        servico.setValorUnitario(150.00);

        servico = servicoRepository.save(servico);

        Cliente cliente = new Cliente();
        cliente.setCpf("10768338964");
        cliente.setRg("7043045");
        cliente.setNome("Bruno");
        cliente.setEmail("brunojdbsl@gmail.com");
        cliente.setEndereco("Rua tal");
        cliente.setTelefone("998544344");

        cliente = clienteRepository.save(cliente);

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setDataVenda(LocalDate.now());
        venda.setObservacao("teste");
        venda.setFormaPagamento(FormaPagamento.PIX);

        ItemVenda itemVenda = new ItemVenda(produto, 1000.00, 1.0, 10.00);
        ItemVenda itemVenda2 = new ItemVenda(servico, 120.00, 1.0, 10.00);

        venda.addItemVenda(itemVenda);
        venda.addItemVenda(itemVenda2);

        vendaRepository.save(venda);

        return "Comando Executado " + produto.getId();
    }
}
