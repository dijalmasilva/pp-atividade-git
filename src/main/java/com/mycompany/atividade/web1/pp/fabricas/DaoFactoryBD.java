package com.mycompany.atividade.web1.pp.fabricas;

import com.mycompany.atividade.web1.pp.dao.UsuarioDao;
import com.mycompany.atividade.web1.pp.interfaces.UsuarioDaoIF;

public class DaoFactoryBD implements DaoFactoryIF {

    private DaoFactoryBD instance;

    public UsuarioDaoIF criaUsuarioDao() {
        return new UsuarioDao();
    }

}
