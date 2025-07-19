package br.com.alura.codechella.domain.entities.usuario;

import br.com.alura.codechella.domain.Endereco;

import java.time.LocalDate;

public class FabricaUsuario {
    private Usuario entity;

    public Usuario criarUsuarioComNomeCpfNascimento(String nome, String cpf, LocalDate nascimento){
        this.entity = new Usuario(cpf, nome, nascimento, "");
        return entity;
    }

    public Usuario insereEndereco(String cep, Integer numero, String complemento){
        this.entity.setEndereco(new Endereco(cep, numero, complemento));
        return entity;
    }
;}
