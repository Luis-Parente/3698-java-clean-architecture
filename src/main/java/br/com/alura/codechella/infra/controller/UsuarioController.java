package br.com.alura.codechella.infra.controller;

import br.com.alura.codechella.application.usecases.CadastrarUsuario;
import br.com.alura.codechella.application.usecases.ExcluirUsuario;
import br.com.alura.codechella.application.usecases.ListarUsuarios;
import br.com.alura.codechella.application.usecases.AtualizarPeloCpfUsuario;
import br.com.alura.codechella.domain.entities.usuario.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    private final CadastrarUsuario cadastrarUsuario;

    private final ListarUsuarios listarUsuarios;

    private final AtualizarPeloCpfUsuario atualizarPeloCpfUsuario;

    private final ExcluirUsuario excluiUsuario;


    public UsuarioController(CadastrarUsuario cadastrarUsuario, ListarUsuarios listarUsuarios, AtualizarPeloCpfUsuario atualizarPeloCpfUsuario, ExcluirUsuario excluiUsuario) {
        this.cadastrarUsuario = cadastrarUsuario;
        this.listarUsuarios = listarUsuarios;
        this.atualizarPeloCpfUsuario = atualizarPeloCpfUsuario;
        this.excluiUsuario = excluiUsuario;


    }

    @PostMapping
    public UsuarioDTO insert(@RequestBody UsuarioDTO dto) {
        Usuario salvo = cadastrarUsuario.salvarUsuario(new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UsuarioDTO(salvo.getCpf(), salvo.getNome(), salvo.getNascimento(), salvo.getEmail());

    }

    @GetMapping
    public List<UsuarioDTO> findALl() {
        List<Usuario> usuarios = listarUsuarios.obterTodosUsuarios();
        return usuarios.stream().map(usuario -> new UsuarioDTO(usuario.getCpf(), usuario.getNome(), usuario.getNascimento(), usuario.getEmail())).toList();

    }

    @PutMapping(value = "/{cpf}")
    public UsuarioDTO update(@PathVariable String cpf, @RequestBody UsuarioDTO dto){
        Usuario atualizado = atualizarPeloCpfUsuario.atualizaPeloCpf(cpf, new Usuario(dto.cpf(), dto.nome(), dto.nascimento(), dto.email()));
        return new UsuarioDTO(atualizado.getCpf(), atualizado.getNome(), atualizado.getNascimento(), atualizado.getEmail());
    }

    @DeleteMapping("/{cpf}")
    public void excluirUsuario(@PathVariable String cpf) {
        excluiUsuario.excluirUsuario(cpf);
    }
}
