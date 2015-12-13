package com.mycompany.atividade.web1.pp.gerenciadores;

import com.mycompany.atividade.web1.pp.entidades.Usuario;
import com.mycompany.atividade.web1.pp.fabricas.DaoFactory;
import com.mycompany.atividade.web1.pp.fabricas.DaoFactoryIF;
import com.mycompany.atividade.web1.pp.interfaces.UsuarioDaoIF;
import java.sql.SQLException;
import java.util.List;

public class GerenciadorDeUsuario {

    public boolean adicionarUsuario(String nome, String sobrenome, int idade) throws SQLException {
        Usuario novoUsu = new Usuario();
        novoUsu.setNome(nome);
        novoUsu.setSobrenome(sobrenome);
        novoUsu.setIdade(idade);

        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.cadastrar(novoUsu);
    }

    public boolean removerUsuario(int id) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.remover(id);
    }


    public List<Usuario> listaUsuarios() throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        return usuDao.listaUsuarios();
    }
}
