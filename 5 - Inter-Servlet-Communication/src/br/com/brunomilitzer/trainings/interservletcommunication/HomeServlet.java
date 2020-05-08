package br.com.brunomilitzer.trainings.interservletcommunication;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {

    private static final long serialVersionUID = 1812276149340964537L;

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        PrintWriter out = response.getWriter( );
        response.setContentType( "text/html" );
        out.print( request.getAttribute( "message" ) );
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws IOException {

        PrintWriter out = response.getWriter( );
        response.setContentType( "text/html" );
        out.print( request.getAttribute( "message" ) );
    }


}
