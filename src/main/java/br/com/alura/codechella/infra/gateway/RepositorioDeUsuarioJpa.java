package br.com.alura.codechella.infra.gateway;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import br.com.alura.codechella.infra.persistense.UsuarioEntity;
import br.com.alura.codechella.infra.persistense.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;

public class RepositorioDeUsuarioJpa implements RepositorioDeUsuario {

    private final UsuarioRepository repository;

    private final UsuarioEntityMapper mapper;

    public RepositorioDeUsuarioJpa(UsuarioRepository repository, UsuarioEntityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Usuario cadastrarUsuario(Usuario usuario) {
        UsuarioEntity entity = mapper.toEntity(usuario);
        repository.save(entity);
        return mapper.toDomain(entity);
    }

    @Override
    public List<Usuario> listarTodos() {
        return repository.findAll().stream().map(mapper::toDomain).toList();
    }

    @Override
    public Usuario atualizarPeloCpf(String cpf, Usuario usuario) {
        UsuarioEntity entity = repository.findByCpf(cpf);
        if (entity != null) {
            var atualizado = mapper.toEntity(usuario);
            atualizado.setId(entity.getId());
            repository.save(atualizado);
            return mapper.toDomain(atualizado);
        }
        return null;
    }

    @Override
    public void excluiUsuario(String cpf) {
        UsuarioEntity entity = repository.findByCpf(cpf);
        repository.deleteById(entity.getId());
    }

}
