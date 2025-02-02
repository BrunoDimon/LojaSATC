package com.Atividade.satc.oja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ItemVenda extends EntityId {

    @ManyToOne
    @JoinColumn(name = "produto_servico_id")
    private ItemVendavel produtoServico;

    @Column(name = "valor_unitario")
    private Double valorUnitario;
    @Column(name = "quantidade")
    private Double quantidade;
    @Column(name = "desconto")
    private Double desconto;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    private Venda venda;

    public ItemVenda(ItemVendavel produtoServico, Double valorUnitario, Double quantidade, Double desconto) {
        this.produtoServico = produtoServico;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
        this.desconto = desconto;
    }

    public ItemVendavel getProdutoServico() {
        return produtoServico;
    }

    public void setProdutoServico(ItemVendavel produtoServico) {
        this.produtoServico = produtoServico;
    }

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public Double getDesconto() {
        return desconto;
    }

    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    public Double getValorCalculado() {
        double valorTotal = this.getValorUnitario() * this.getQuantidade();
        double descontoCalculado = valorTotal * (this.getDesconto() / 100);
        return valorTotal - descontoCalculado;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    @Override
    public String toString() {
        return "ItemVenda{" +
                "produtoServico=" + produtoServico +
                ", valorUnitario=" + valorUnitario +
                ", quantidade=" + quantidade +
                ", desconto=" + desconto +
                '}';
    }
}
