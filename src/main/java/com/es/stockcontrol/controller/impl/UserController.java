package com.es.stockcontrol.controller.impl;


import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UserController implements UserControllerAPI {
    List<Usuario> userList = new ArrayList<>();

    public void addUser(Usuario user){
        userList.add(new Usuario("usuarioejemplo@gmail.com","12345"));
    }

    @Override
    public RespuestaHTTP<Usuario> login(String userInput, String passInput) {
        return null;
    }
}
