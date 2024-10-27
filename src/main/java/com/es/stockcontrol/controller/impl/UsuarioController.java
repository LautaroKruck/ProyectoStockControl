package com.es.stockcontrol.controller.impl;


import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.Usuario;
import com.es.stockcontrol.repository.UsuarioRepository;

public class UsuarioController implements UserControllerAPI {

    private UsuarioRepository userRepository;


    public UsuarioController() {
        this.userRepository = new UsuarioRepository();
    }

    public RespuestaHTTP<Usuario> login(String userInput, String passInput) {
        try {
            Usuario usuario = userRepository.getUsuario(userInput);

            if (usuario != null && usuario.getPassword().equals(passInput)) {
                return new RespuestaHTTP<>(200, "Autenticación exitosa", usuario);
            } else {
                return new RespuestaHTTP<>(401, "Credenciales inválidas", null);
            }
        } catch (Exception e) {
            return new RespuestaHTTP<>(500, "Error interno del servidor", null);
        }
    }
}
