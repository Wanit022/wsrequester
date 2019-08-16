/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.gama_system.webservices.ServerTime;
import com.learnwebservices.services.hello.HelloRequest;
import com.learnwebservices.services.hello.HelloResponse;
import com.learnwebservices.services.hello.SimpleHelloEndpointService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author 8402-01
 */
@WebServlet(name = "ServerTimeServlet", urlPatterns = {"/ServerTimeServlet"})
public class ServerTimeServlet extends HttpServlet {
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/www.learnwebservices.com/services/hello.wsdl")
    private SimpleHelloEndpointService service_1;
    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/webservices.gama-system.com/servertime.asmx.wsdl")
    private ServerTime service;

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
            out.println("<title>Daniyan P.</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1><center>My server Time " + "</h1><hr>");
            
       
            out.println("<h1><center>Date : " + getDate()+"</h1>");
            out.println("<h1><center>DateTime : " + getDateTime()+"</h1>");
            out.println("<h1><center>Time : " + getTime()+"</h1>");
            
            //call sayHello web services
HelloRequest h = new HelloRequest();
h.setName("Daniyan Prommoon");
HelloResponse hres = sayHello(h);
String resultHello = hres.getMessage();
out.println("<h2><center> "+resultHello+"<center></h2>");
            

            
            
            
            
            
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

    private String getDate() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.gama_system.webservices.ServerTimeSoap port = service.getServerTimeSoap12();
        return port.getDate();
    }

    private String getDate_1() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.gama_system.webservices.ServerTimeSoap port = service.getServerTimeSoap();
        return port.getDate();
    }

    private String getdate() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getDate_2() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.gama_system.webservices.ServerTimeSoap port = service.getServerTimeSoap12();
        return port.getDate();
    }

    private String getDateTime() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.gama_system.webservices.ServerTimeSoap port = service.getServerTimeSoap12();
        return port.getDateTime();
    }

    private String getTime() {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.gama_system.webservices.ServerTimeSoap port = service.getServerTimeSoap12();
        return port.getTime();
    }

    private HelloResponse sayHello(com.learnwebservices.services.hello.HelloRequest helloRequest) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.learnwebservices.services.hello.HelloEndpoint port = service_1.getSimpleHelloEndpointPort();
        return port.sayHello(helloRequest);
    }

}
