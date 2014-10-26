/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webapp;

import entity.Prisoner;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import session.UnderRemandLocal;

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
    @EJB
    private UnderRemandLocal under_remand;
    @javax.persistence.PersistenceContext(name = "nycpEJBPU")
    private javax.persistence.EntityManager _entity_manager;
    
    private void setPrisoners(HttpServletRequest request) {
        TypedQuery<String[]> query = _entity_manager.createQuery("SELECT p.givenName,p.surname,p.prisonFileNumber from Prisoner p", String[].class);
        List<String[]> results = query.getResultList();
        request.setAttribute("prisoners",results);
    }
            
    private void setPrisoners(HttpServletRequest request, List<Prisoner> prisoners) {
        List<String[]> results = new ArrayList<>();
        for (Prisoner p : prisoners) {
            String[] info = new String[5];
            info[0] = p.getGivenName();
            info[1] = p.getSurname();
            info[2] = p.getPlaceOfBirth();
            info[3] = p.getPrisonFileNumber();
            info[4] = p.getDateOfBirth().toString();
            results.add(info);
        }
        request.setAttribute("prisoners",results);
    }       
    
    private void setJurisdiction(HttpServletRequest request){
        TypedQuery<String> query = _entity_manager.createQuery("SELECT DISTINCT c.criminalCasePK.jurisdictionName from CriminalCase c", String.class);
        List<String> results = query.getResultList();
        request.setAttribute("jurisdiction", results);
    }
    
    private void setMotive(HttpServletRequest request){
        TypedQuery<String[]> query = _entity_manager.createQuery("SELECT m.motiveNumber, m.motiveLabel from Motive m", String[].class);
        List<String[]> results = query.getResultList();
        request.setAttribute("motive", results);
    }
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
                setJurisdiction(request);
                setMotive(request);
                dispatcher = request.getRequestDispatcher("WEB-INF/incarcerate.jsp");
                dispatcher.forward(request,response);
                break;
            case "/incarcerate/new":
                String jurisdiction;
                String motive;
                String newJurisdiction = request.getParameter("newJurisdiction");
                if(newJurisdiction.equals(""))
                    jurisdiction = request.getParameter("jurisdiction");
                else
                    jurisdiction = request.getParameter("newJurisdiction");
                
                String newMotive = request.getParameter("newMotive");
                if(newMotive.equals(""))
                    motive = request.getParameter("motive");
                else{  
                    motive = incarceration.insert_motive(request.getParameter("newMotive"));
                }    
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String bd = request.getParameter("birthDate");
                Date birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(bd);
                String birthPlace = request.getParameter("birthPlace");
                
                String id = request.getParameter("incarcerationDate");
                Date incarcerationDate = new SimpleDateFormat("yyyy-MM-dd").parse(id);
                String d = request.getParameter("date");
                Date date = new SimpleDateFormat("yyyy-MM-dd").parse(d);
                
                incarceration.incarcerate(name, surname, birthDate, birthPlace, jurisdiction, date, incarcerationDate, motive);
                out.println("<a href='../index.html'>Home</a><br/>");
                out.println("Incarcerated prisoner : " + name + " " + "surname" + ", born on " + birthDate + " in " + birthPlace + ". Criminal case pronounced on " + date + " (" + jurisdiction + ")");
                out.println("<br/>Incarcerated on " + incarcerationDate + " for motive : " + motive);
                break;
            case "/under_remand":
                List<Prisoner> prisoners = under_remand.get_under_remand();
                setPrisoners(request, prisoners);
                dispatcher = request.getRequestDispatcher("WEB-INF/under_remand.jsp");
                dispatcher.forward(request,response);
                break;
            case "/conviction":
                setPrisoners(request);
                dispatcher = request.getRequestDispatcher("WEB-INF/conviction.jsp");
                dispatcher.forward(request,response);
                break;
            case "/conviction/add":
                Integer duration = Integer.valueOf(request.getParameter("duration"));
                String strDate = request.getParameter("date");
                String prisoner = request.getParameter("prisoner");
                date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
                judicial_decision.insert_conviction(prisoner, date, duration);
                out.println("<a href='../index.html'>Home</a><br/>");
                out.println("Convicted prisoner " + prisoner + " to " + duration + " days");
                break;
            case "/final_discharge":
                setPrisoners(request);
                dispatcher = request.getRequestDispatcher("WEB-INF/final_discharge.jsp");
                dispatcher.forward(request,response);
                break;
            case "/final_discharge/add":
                prisoner = request.getParameter("prisoner");
                strDate = request.getParameter("decisionDate");
                Date decisionDate = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
                strDate = request.getParameter("dischargeDate");
                Date dischargeDate = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
                judicial_decision.insert_final_discharge(prisoner, decisionDate, dischargeDate);
                out.println("<a href='../index.html'>Home</a><br/>");
                out.println("Prisoner "+ prisoner + " gets discharged on " + dischargeDate);
                break;
            case "/shortened_sentence":
                setPrisoners(request);
                dispatcher = request.getRequestDispatcher("WEB-INF/shortened_sentence.jsp");
                dispatcher.forward(request,response);
                break;
            case "/shortened_sentence/add":
                duration = Integer.valueOf(request.getParameter("duration"));
                strDate = request.getParameter("date");
                prisoner = request.getParameter("prisoner");
                date = new SimpleDateFormat("yyyy-MM-dd").parse(strDate);
                judicial_decision.insert_shortened_sentence(prisoner, date, duration);
                out.println("<a href='../index.html'>Home</a><br/>");
                out.println("Shortened sentenceof prisoner " + prisoner + " by " + duration + " days");
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
