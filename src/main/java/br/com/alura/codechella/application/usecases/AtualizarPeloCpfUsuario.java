package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class AtualizarPeloCpfUsuario {
    private final RepositorioDeUsuario repository;

    public AtualizarPeloCpfUsuario(RepositorioDeUsuario repository) {
        this.repository = repository;
    }

    public Usuario atualizaPeloCpf(String cpf, Usuario usuario){
        return repository.atualizarPeloCpf(cpf, usuario);
    }
}
