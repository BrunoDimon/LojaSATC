package com.Atividade.satc.oja.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Pessoa extends EntityId {

    @Column(name = "name", nullable = true)
    private String nome;
    @Column(name = "telefone", nullable = true)
    private String telefone;
    @Column(name = "endereco", nullable = true)
    private String endereco;
    @Column(name = "email", nullable = true)
    private String email;

    public abstract String getDocumentoPrincipal();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
