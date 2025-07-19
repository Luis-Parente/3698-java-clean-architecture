package br.com.alura.codechella.domain.entities.usuario;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class UsuarioTest {

    @Test
    public void usuarioShouldThrowIllegalArgumentExceptionWhenCpfFormatIsInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("12345678999", "Jacque", LocalDate.parse("1990-09-08"), "email@email.com");});
    }

    @Test
    public void fabricaUsuarioShouldReturnUsuarioWhenCpfFormatIsValid() {
        FabricaUsuario fabrica = new FabricaUsuario();

        Usuario usuario = fabrica.criarUsuarioComNomeCpfNascimento( "Jacque","123.456.789-99", LocalDate.parse("1990-09-08"));

        usuario = fabrica.insereEndereco("01234-567", 22, "casa 2");

        Assertions.assertEquals("123.456.789-99", usuario.getCpf());
        Assertions.assertEquals("Jacque", usuario.getNome());
        Assertions.assertEquals(LocalDate.parse("1990-09-08"), usuario.getNascimento());
        Assertions.assertEquals("01234-567", usuario.getEndereco().getCep());
    }

    @Test
    public void naoDeveCadastrarUsuarioComMenosDe18anos() {

        LocalDate dataNascimento = LocalDate.now().minusYears(17);  // Um usuário com 17 anos

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Usuario("123.456.789-00", "Fulano", dataNascimento, "fulano@example.com");
        });
    }
}
