package com.es.stockcontrol.controller.api;

import com.es.stockcontrol.model.RespuestaHTTP;
import com.es.stockcontrol.model.Usuario;

public interface UserControllerAPI {

    /**
     * Método para realizar un login en la aplicacion.
     *
     * @param userInput String. Parametro con el usuario introducido por teclado
     * @param passInput String. Parametro con la pass introducida por teclado
     * @return RespuestaHTTP<User>
     */
    RespuestaHTTP<Usuario> login(String userInput, String passInput);
}
