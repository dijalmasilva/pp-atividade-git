package com.mycompany.atividade.web1.pp.dao;

import com.mycompany.atividade.web1.pp.conexao.ClasseConexao;
import com.mycompany.atividade.web1.pp.conexao.ConnectionFactory;
import com.mycompany.atividade.web1.pp.entidades.Usuario;
import com.mycompany.atividade.web1.pp.interfaces.UsuarioDaoIF;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean cadastrar(Usuario entidade) throws SQLException {

        boolean result = false;
        
        try {
            String SQL = "insert into usuario(nome, sobrenome, idade) values (?,?,?)";
            pstm = con.prepareStatement(SQL);
            pstm.setString(1, entidade.getNome());
            pstm.setString(2, entidade.getSobrenome());
            pstm.setInt(3, entidade.getIdade());

            pstm.executeUpdate();
            result = true;
        } finally {
            co.liberar();
        }
        
        return result;
    }

    @Override
    public boolean remover(int id) throws SQLException {
        
        boolean result = false;
        
        try {

            String SQL = "delete from usuario where id = ?";

            pstm = con.prepareStatement(SQL);
            pstm.setInt(1, id);

            pstm.executeUpdate();
            
            result = true;
        } finally {
            co.liberar();
        }
        
        return result;
    }

    @Override
    public List<Usuario> listaUsuarios() throws SQLException{
        List<Usuario> users = new ArrayList<>();
        
        try{
            String SQL = "select * from usuario";
            
            pstm = con.prepareStatement(SQL);
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                Usuario u = new Usuario();
                u.setNome(rs.getString("nome"));
                u.setSobrenome(rs.getString("sobrenome"));
                u.setIdade(rs.getInt("idade"));
                u.setId(rs.getInt("id"));
                
                users.add(u);
            }
            
        }finally{
            co.liberar();
        }
        
        return users;
    }
}
