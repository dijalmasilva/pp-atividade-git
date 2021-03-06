/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 * @author IFPB
 */
@WebServlet(urlPatterns = {"/newCliente"})
public class NewCliente extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String nome = req.getParameter("nome");
        String sobrenome = req.getParameter("sobrenome");
        int idade = Integer.parseInt(req.getParameter("idade"));
        boolean cadastro = false;
        
        GerenciadorDeUsuario gu = new GerenciadorDeUsuario();
        try {
            cadastro = gu.adicionarUsuario(nome, sobrenome, idade);
        } catch (SQLException ex) {
            Logger.getLogger(NewCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        req.setAttribute("cadastro", cadastro);
        req.getRequestDispatcher("novoUsuario.jsp").forward(req, resp);
    }
    
    
}
