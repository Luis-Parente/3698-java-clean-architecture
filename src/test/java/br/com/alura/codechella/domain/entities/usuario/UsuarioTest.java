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
    public void usuarioShouldReturnUsuarioWhenCpfFormatIsValid() {
        Usuario usuario = new Usuario("123.456.789-99", "Jacque", LocalDate.parse("1990-09-08"), "email@email.com");

        Assertions.assertEquals("123.456.789-99", usuario.getCpf());
        Assertions.assertEquals("Jacque", usuario.getNome());
        Assertions.assertEquals(LocalDate.parse("1990-09-08"), usuario.getNascimento());
        Assertions.assertEquals("email@email.com", usuario.getEmail());
    }
}
