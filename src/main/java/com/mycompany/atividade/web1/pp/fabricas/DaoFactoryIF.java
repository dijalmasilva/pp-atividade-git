package com.mycompany.atividade.web1.pp.fabricas;

import com.mycompany.atividade.web1.pp.interfaces.UsuarioDaoIF;

public interface DaoFactoryIF {

    public UsuarioDaoIF criaUsuarioDao();

}
