package com.es.stockcontrol.service;

import com.es.stockcontrol.model.Usuario;
import com.es.stockcontrol.repository.UsuarioRepository;

public class UsuarioService {
    private final UsuarioRepository repository;

    public UsuarioService(){
        this.repository = new UsuarioRepository();
    }

    public Usuario getUsuario(String nombre){
        if(nombre.length()>50 || nombre.isEmpty()){
            return null;
        }
        return repository.getUsuario(nombre);
    }
}
