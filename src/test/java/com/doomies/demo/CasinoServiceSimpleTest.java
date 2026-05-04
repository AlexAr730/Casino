package com.doomies.demo;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import com.doomies.demo.service.CasinoService;

class CasinoServiceSimpleTest {

    @Test
    void testMontoInvalido() {

        CasinoService service = new CasinoService(null);

        assertThrows(
                IllegalArgumentException.class,
                () -> service.apostar(1L, -50)
        );
    }
}