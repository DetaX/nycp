/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.TypedQuery;
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
    @EJB
    private JudicialDecisionLocal judicial_decision;
    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException
            {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher dispatcher;
        
        switch(request.getServletPath()) {
            case "/incarcerate":
                String test= "Teeeeest";
                request.setAttribute("test",test);
                dispatcher = request.getRequestDispatcher("WEB-INF/incarcerate.jsp");
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
                TypedQuery<String[]> query = _entity_manager.createQuery("SELECT p.givenName,p.surname,p.prisonFileNumber from Prisoner p", String[].class);
                List<String[]> results = query.getResultList();
                request.setAttribute("prisoners",results);
                dispatcher = request.getRequestDispatcher("WEB-INF/shortened_sentence.jsp");
                dispatcher.forward(request,response);
                break;
            case "/shortened_sentence/add":
                Integer duration = Integer.valueOf(request.getParameter("duration"));
                String strDate = request.getParameter("date");
                String prisoner = request.getParameter("prisoner");
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
                judicial_decision.insert_shortened_sentence(prisoner, date, duration);
                out.println("Shortened sentence by " + duration + " on prisoner " + prisoner);
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
