package com.doomies.demo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.doomies.demo.model.User;
import com.doomies.demo.repository.UserRepository;
import com.doomies.demo.service.CasinoService;

class CasinoServiceComplejaTest {

    private UserRepository repo;
    private CasinoService service;

    @BeforeEach
    void setup() {
        repo = Mockito.mock(UserRepository.class);
        service = new CasinoService(repo);
    }

    @Test
    void testUsuarioNoExiste() {

        when(repo.findById(1L)).thenReturn(Optional.empty());

        assertThrows(
                RuntimeException.class,
                () -> service.apostar(1L, 50)
        );
    }

    @Test
    void testSaldoInsuficiente() {

        User user = new User("Carlos","carlos@mail.com",25);
        user.setSaldo(10);

        when(repo.findById(1L)).thenReturn(Optional.of(user));

        assertThrows(
                IllegalArgumentException.class,
                () -> service.apostar(1L, 50)
        );
    }

    @Test
    void testApuestaValida() {

        User user = new User("Carlos","carlos@mail.com",25);
        user.setSaldo(500);

        when(repo.findById(1L)).thenReturn(Optional.of(user));

        service.apostar(1L,100);

        verify(repo, times(1)).save(user);
    }
}