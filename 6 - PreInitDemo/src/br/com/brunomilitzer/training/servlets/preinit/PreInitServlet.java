package br.com.brunomilitzer.training.servlets.preinit;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "/preInitServlet", loadOnStartup = 0)
public class PreInitServlet extends HttpServlet {

    private static final long serialVersionUID = -354434358269405814L;

    @Override
    public void init( ) throws ServletException {

        System.out.println("Inside the init method" );
    }

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        response.getWriter().write( "From the pre init servlet" );
    }

}
