package com.mycompany.atividade.web1.pp.gerenciadores;

import com.mycompany.atividade.web1.pp.entidades.Usuario;
import com.mycompany.atividade.web1.pp.fabricas.DaoFactory;
import com.mycompany.atividade.web1.pp.fabricas.DaoFactoryIF;
import com.mycompany.atividade.web1.pp.interfaces.UsuarioDaoIF;
import java.sql.SQLException;

public class GerenciadorDeUsuario {

    public void adicionarUsuario(String nome, String sobrenome, int idade) throws SQLException {
        Usuario novoUsu = new Usuario();
        novoUsu.setNome(nome);
        novoUsu.setSobrenome(nome);
        novoUsu.setIdade(idade);

        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.cadastrar(novoUsu);
    }

    public void removerUsuario(Usuario u) throws SQLException {
        DaoFactoryIF fabrica = DaoFactory.creatFactory();
        UsuarioDaoIF usuDao = fabrica.criaUsuarioDao();
        usuDao.remover(u);
    }

}
