package com.doomies.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.doomies.demo.controller.UserDTO;

class UserDTOTest {

    @Test
    void testConstructorYGetters() {
        UserDTO dto = new UserDTO("Juan", "juan@test.com");

        assertEquals("Juan", dto.getNombre());
        assertEquals("juan@test.com", dto.getEmail());
    }

    @Test
    void testSetters() {
        UserDTO dto = new UserDTO();

        dto.setNombre("Ana");
        dto.setEmail("ana@test.com");

        assertEquals("Ana", dto.getNombre());
        assertEquals("ana@test.com", dto.getEmail());
    }
}