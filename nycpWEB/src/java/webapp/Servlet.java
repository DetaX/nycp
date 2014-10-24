/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.IncarcerationLocal;
import session.JudicialDecisionLocal;

/**
 *
 * @author zex
 */
@WebServlet(urlPatterns = {"/incarcerate", 
                           "/incarcerate/new", 
                           "/under_remand", 
                           "/conviction", 
                           "/conviction/add", 
                           "/final_discharge", 
                           "/final_discharge/add", 
                           "/shortened_sentence", 
                           "/shortened_sentence/add"})
public class Servlet extends HttpServlet {
    @EJB
    private IncarcerationLocal incarceration;
    private JudicialDecisionLocal judicial_decision;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        switch(request.getServletPath()) {
            case "/incarcerate":
                String test= "Teeeeest";
                request.setAttribute("test",test);
                RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/incarcerate.jsp");
                dispatcher.forward(request,response);
                break;
            case "/incarcerate/new":
                // TODO
                break;
            case "/under_remand":
                // TODO
                break;
            case "/conviction":
                // TODO
                break;
            case "/conviction/add":
                // TODO
                break;
            case "/final_discharge":
                // TODO
                break;
            case "/final_discharge/add":
                // TODO
                break;
            case "/shortened_sentence":
                // TODO
                break;
            case "/shortened_sentence/add":
                // TODO
                break;
            default: 
                // TODO redirect to index.html
                break;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
            {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
