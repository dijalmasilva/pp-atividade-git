package com.mycompany.atividade.web1.pp.servlets;

import com.mycompany.atividade.web1.pp.gerenciadores.GerenciadorDeUsuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dijalma
 */
@WebServlet(urlPatterns = {"/users"})
public class CarregaUsers extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        try {
            req.getSession().setAttribute("usuarios", new GerenciadorDeUsuario().listaUsuarios());
        } catch (SQLException ex) {
            Logger.getLogger(CarregaUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        req.getRequestDispatcher("removeUsuario.jsp").forward(req, resp);
    }
    
    
}
