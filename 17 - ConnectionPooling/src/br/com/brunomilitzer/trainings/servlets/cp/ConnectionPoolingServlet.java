package br.com.brunomilitzer.trainings.servlets.cp;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/ConnectionPooling")
public class ConnectionPoolingServlet extends HttpServlet {

    private static final long serialVersionUID = 5710915718583945683L;

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        try {
            Context context = new InitialContext();
            DataSource datasource = ( DataSource ) context.lookup( "java:comp/env/myds" );
            Connection connection = datasource.getConnection();
            System.out.println(connection);

        } catch ( NamingException | SQLException e ) {
            e.printStackTrace();
        }
    }
}
