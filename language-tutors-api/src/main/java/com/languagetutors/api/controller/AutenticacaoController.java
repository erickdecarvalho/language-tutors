package com.languagetutors.api.controller;

import com.languagetutors.api.domain.usuario.DadosAutenticacao;
import com.languagetutors.api.domain.usuario.Usuario;
import com.languagetutors.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {

        // verifica se o usuário existe no banco de dados
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(token);

        // retorna o token do usuário após a verificação se ele existe no banco
        return ResponseEntity.ok(tokenService.gerarToken((Usuario) authentication.getPrincipal()));

    }
}
