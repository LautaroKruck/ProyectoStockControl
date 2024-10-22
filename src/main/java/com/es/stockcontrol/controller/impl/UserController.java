package com.es.stockcontrol.controller.impl;


import com.es.stockcontrol.controller.api.UserControllerAPI;
import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserController implements UserControllerAPI {
    List<User> userList = new ArrayList<>();

    public void addUser(User user){
        userList.add(new User("usuarioejemplo@gmail.com","12345"));
    }

    @Override
    public RespuestaHTTP<User> login(String userInput, String passInput) {
        return null;
    }
}
