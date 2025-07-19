package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UsuarioRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

public class CadastrarUsuario {

    private final UsuarioRepository repository;

    public CadastrarUsuario(UsuarioRepository repository){
        this.repository = repository;
    }

    public Usuario cadastrarUsuario(Usuario usuario){
        return repository.cadastrarUsuario(usuario);
    }
}
