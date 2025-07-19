package br.com.alura.codechella.config;

import br.com.alura.codechella.application.gateways.RepositorioDeUsuario;
import br.com.alura.codechella.application.usecases.AtualizarPeloCpfUsuario;
import br.com.alura.codechella.application.usecases.CadastrarUsuario;
import br.com.alura.codechella.application.usecases.ExcluirUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.infra.gateway.RepositorioDeUsuarioJpa;
import br.com.alura.codechella.infra.gateway.UsuarioEntityMapper;
import br.com.alura.codechella.infra.persistense.UsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    CadastrarUsuario cadastrarUsuario(RepositorioDeUsuario repositorio){
        return new CadastrarUsuario(repositorio);
    }

    @Bean
    ListarUsuarios listarUsuarios(RepositorioDeUsuario repositorio){
        return new ListarUsuarios(repositorio);
    }

    @Bean
    AtualizarPeloCpfUsuario atualizarPeloCpfUsuario(RepositorioDeUsuario repositorio){
        return new AtualizarPeloCpfUsuario(repositorio);
    }

    @Bean
    ExcluirUsuario excluiUsuario(RepositorioDeUsuario repositorioDeUsuario){
        return new ExcluirUsuario(repositorioDeUsuario);
    }

    @Bean
    RepositorioDeUsuarioJpa repositorioDeUsuario(UsuarioRepository repository, UsuarioEntityMapper mapper){
    return new RepositorioDeUsuarioJpa(repository, mapper);
    }

    @Bean
    UsuarioEntityMapper entityMapper(){
        return new UsuarioEntityMapper();
    }

}
