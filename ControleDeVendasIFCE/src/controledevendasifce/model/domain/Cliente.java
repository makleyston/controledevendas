/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledevendasifce.model.domain;

/**
 *
 * @author makleyston
 */
public class Cliente {
    
    private String nome;
    private String cpf;
    private String telefone;
    private Endereco endenreco;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public Cliente(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Endereco getEndenreco() {
        return endenreco;
    }

    public void setEndenreco(Endereco endenreco) {
        this.endenreco = endenreco;
    }
    
}
