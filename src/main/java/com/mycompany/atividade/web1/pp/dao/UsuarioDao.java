package com.mycompany.atividade.web1.pp.dao;

import com.mycompany.atividade.web1.pp.conexao.ClasseConexao;
import com.mycompany.atividade.web1.pp.conexao.ConnectionFactory;
import com.mycompany.atividade.web1.pp.entidades.Usuario;
import com.mycompany.atividade.web1.pp.interfaces.UsuarioDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDao implements UsuarioDaoIF {

    ConnectionFactory factory = new ConnectionFactory();
    ClasseConexao co = new ClasseConexao();
    Connection con;
    PreparedStatement pstm;

    public UsuarioDao() {
        try {
            con = co.abrir();
        } catch (Exception e) {
        }
    }

    public void cadastrar(Usuario entidade) throws SQLException {

        try {
            String SQL = "insert into usuario(nome, sobrenome, idade) values (?,?,?)";
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, entidade.getNome());
            pstm.setString(2, entidade.getSobrenome());
            pstm.setInt(3, entidade.getIdade());

            pstm.executeUpdate();
        } finally {
            co.liberar();
        }
    }

    public void remover(Usuario entidade) throws SQLException {
        try {

            String SQL = "delete from usuario where nome=?";

            pstm = con.prepareStatement(SQL);
            pstm.setString(1, entidade.getNome());

            pstm.executeUpdate();
        } finally {
            co.liberar();
        }
    }

}
