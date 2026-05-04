package com.doomies.demo;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.doomies.demo.service.UserNotFoundException;
//Test test
class UserNotFoundExceptionTest {

    @Test
    void testExceptionMessage() {
        UserNotFoundException ex = new UserNotFoundException("Usuario no encontrado");

        assertEquals("Usuario no encontrado", ex.getMessage());
    }
}