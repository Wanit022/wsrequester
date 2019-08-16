/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.xml.internal.messaging.saaj.soap.Envelope;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;
import org.tempuri.Calculator;

/**
 *
 * @author 8402-01
 */
@WebServlet(urlPatterns = {"/test01"})

public class test01 extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/www.dneonline.com/calculator.asmx.wsdl")
    private Calculator service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet test01</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Calcutor  " + request.getContextPath() + "</h1>");
            int i = 10;
            int j = 5;
            // TODO process result here
            int result = add(i, j);
            int result1 = divide(i, j);
            int result2 = multiply(i, j);
            int result3 = subtract(i, j);

            out.println("add() 10+5 = " + result + "<p>");
            out.println("divide() 10/5 = " + result1 + "<p>");
            out.println("multiply() 10*5 = " + result2 + "<p>");
            out.println("subtract() 10-5 = " + result3 + "<p>");

            out.println("</body>");
            out.println("</html>");
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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

    private int add(int intA, int intB) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap12();
        return port.add(intA, intB);
    }

    private int divide(int intA, int intB) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap12();
        return port.divide(intA, intB);
    }

    private int multiply(int intA, int intB) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap12();
        return port.multiply(intA, intB);
    }

    private int subtract(int intA, int intB) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        org.tempuri.CalculatorSoap port = service.getCalculatorSoap12();
        return port.subtract(intA, intB);
    }

}
