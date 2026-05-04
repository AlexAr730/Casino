package com.doomies.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.doomies.demo.model.User;
import com.doomies.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> obtenerUsuarios() {
        return service.obtenerUsuarios();
    }

    @PostMapping
    public User crearUsuario(@RequestBody UserDTO userDTO) {
        User user = new User();
        user.setNombre(userDTO.getNombre());
        user.setEmail(userDTO.getEmail());

        return service.crearUsuario(user);
    }

    @GetMapping("/{id}")
    public User obtenerUsuario(@PathVariable Long id) {
        return service.obtenerUsuario(id);
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        service.eliminarUsuario(id);
    }
}