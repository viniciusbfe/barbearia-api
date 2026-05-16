package com.viniciusbf.barbearia.controllers;

import com.viniciusbf.barbearia.entities.Usuario;
import com.viniciusbf.barbearia.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping("/me")
    public ResponseEntity<Usuario> getMe(@AuthenticationPrincipal UserDetails userDetails) {
        return ResponseEntity.ok(usuarioService.getByEmail(userDetails.getUsername()));
    }
}
