/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.atividade.web1.pp.servlets;

/**
 *
 * @author dijalma
 */

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

@WebServlet(urlPatterns = {"/removeUser"})
public class RemoveCliente extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("id"));
        
        boolean r = false;
        
        try {
            r = new GerenciadorDeUsuario().removerUsuario(id);
        } catch (SQLException ex) {
            Logger.getLogger(RemoveCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        req.setAttribute("removeu", r);
        
        req.getRequestDispatcher("users").forward(req, resp);
    }
    
    
}
