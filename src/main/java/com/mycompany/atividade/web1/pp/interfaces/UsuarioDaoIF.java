package com.mycompany.atividade.web1.pp.interfaces;


import com.mycompany.atividade.web1.pp.entidades.Usuario;
import java.sql.SQLException;

public interface UsuarioDaoIF {
    
    public void cadastrar(Usuario u)throws SQLException;
    
    public void remover(Usuario u)throws SQLException;       

}
