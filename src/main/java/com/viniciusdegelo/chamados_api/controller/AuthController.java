package com.viniciusdegelo.chamados_api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viniciusdegelo.chamados_api.config.JwtUtil;
import com.viniciusdegelo.chamados_api.model.Usuario;
import com.viniciusdegelo.chamados_api.repository.UsuarioRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public Usuario registrar(@RequestBody Usuario usuario) {
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return usuarioRepository.save(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario dadosLogin) {
        Usuario usuarioEncontrado = usuarioRepository.findByUsername(dadosLogin.getUsername());

        if (usuarioEncontrado == null) {
            return "Usuário não encontrado";
        }

        boolean senhaCorreta = passwordEncoder.matches(dadosLogin.getSenha(), usuarioEncontrado.getSenha());

        if (senhaCorreta) {
            return jwtUtil.gerarToken(usuarioEncontrado.getUsername());
        } else {
            return "Senha inválida";
        }
    }
}