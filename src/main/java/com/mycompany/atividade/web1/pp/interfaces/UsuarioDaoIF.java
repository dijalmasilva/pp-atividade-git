package com.mycompany.atividade.web1.pp.interfaces;


import com.mycompany.atividade.web1.pp.entidades.Usuario;
import java.sql.SQLException;
import java.util.List;

public interface UsuarioDaoIF {
    
    public boolean cadastrar(Usuario u)throws SQLException;
    
    public boolean remover(int id)throws SQLException;       

    public List<Usuario> listaUsuarios() throws SQLException;
}
