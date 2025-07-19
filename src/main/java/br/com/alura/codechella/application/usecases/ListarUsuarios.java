package br.com.alura.codechella.application.usecases;

import br.com.alura.codechella.application.gateways.UsuarioRepository;
import br.com.alura.codechella.domain.entities.usuario.Usuario;

import java.util.List;

public class ListarUsuarios {

    private final UsuarioRepository repository;

    public ListarUsuarios(UsuarioRepository repository){
        this.repository = repository;
    }

    public List<Usuario> listarUsuarios(){
        return repository.listarTodos();
    }
}
