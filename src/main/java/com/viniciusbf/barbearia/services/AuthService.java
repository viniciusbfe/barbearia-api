package com.viniciusbf.barbearia.services;

import com.viniciusbf.barbearia.dtos.LoginRequestDTO;
import com.viniciusbf.barbearia.dtos.RegisterRequestDTO;
import com.viniciusbf.barbearia.entities.Usuario;
import com.viniciusbf.barbearia.exceptions.ResourceNotFoundException;
import com.viniciusbf.barbearia.repositories.UsuarioRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, JwtService jwtService, AuthenticationManager authenticationManager){
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public String register(RegisterRequestDTO registerRequestDTO){
        Usuario usuario = new Usuario(null, registerRequestDTO.getNome(), registerRequestDTO.getEmail(), passwordEncoder.encode(registerRequestDTO.getSenha()), registerRequestDTO.getRole());
        usuarioRepository.save(usuario);
        return jwtService.generateToken(usuario);
    }

    public String login(LoginRequestDTO loginRequestDTO){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDTO.getEmail(), loginRequestDTO.getSenha()));

        Usuario usuario = usuarioRepository.findByEmail(loginRequestDTO.getEmail()).orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
        return jwtService.generateToken(usuario);
    }
}
