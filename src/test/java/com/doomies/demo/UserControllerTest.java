package com.doomies.demo;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.doomies.demo.controller.UserController;
import com.doomies.demo.controller.UserDTO;
import com.doomies.demo.model.User;
import com.doomies.demo.service.UserService;

class UserControllerTest {

    @Test
    void testObtenerUsuarios() {
        UserService service = mock(UserService.class);
        UserController controller = new UserController(service);

        User user = new User();
        user.setNombre("Juan");
        user.setEmail("juan@test.com");

        when(service.obtenerUsuarios()).thenReturn(List.of(user));

        List<User> resultado = controller.obtenerUsuarios();

        assertEquals(1, resultado.size());
        assertEquals("Juan", resultado.get(0).getNombre());
    }

    @Test
    void testCrearUsuario() {
        UserService service = mock(UserService.class);
        UserController controller = new UserController(service);

        UserDTO dto = new UserDTO("Ana", "ana@test.com");

        User user = new User();
        user.setNombre("Ana");
        user.setEmail("ana@test.com");

        when(service.crearUsuario(any(User.class))).thenReturn(user);

        User resultado = controller.crearUsuario(dto);

        assertEquals("Ana", resultado.getNombre());
        assertEquals("ana@test.com", resultado.getEmail());
    }

    @Test
    void testObtenerUsuarioPorId() {
        UserService service = mock(UserService.class);
        UserController controller = new UserController(service);

        User user = new User();
        user.setNombre("Carlos");

        when(service.obtenerUsuario(1L)).thenReturn(user);

        User resultado = controller.obtenerUsuario(1L);

        assertEquals("Carlos", resultado.getNombre());
    }

    @Test
    void testEliminarUsuario() {
        UserService service = mock(UserService.class);
        UserController controller = new UserController(service);

        controller.eliminarUsuario(1L);

        verify(service).eliminarUsuario(1L);
    }
}