package br.com.brunomilitzer.user.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

@WebServlet( urlPatterns = "/addServlet")
public class CreateUserServlet extends HttpServlet {

    private static final long serialVersionUID = 8439033159605638084L;

    private Connection connection;

    public void init( ServletConfig config ) {

        try {
            ServletContext context = config.getServletContext( );
            System.out.println("init()" );
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            connection = DriverManager.getConnection( context.getInitParameter( "dbUrl" ), context.getInitParameter( "dbUser" ), context.getInitParameter( "dbPassword" ) );
        } catch ( SQLException | ClassNotFoundException e ) {
            e.printStackTrace( );
        }
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String firstName = request.getParameter( "firstName" );
        String lastName = request.getParameter( "lastName" );
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );

        try {
            Statement statement = connection.createStatement( );
            int result = statement.executeUpdate( "INSERT INTO user VALUES ('" + firstName + "', '" + lastName + "', '" + email + "', '" + password + "')" );

            PrintWriter out = response.getWriter( );

            if (result > 0) {
                out.println( "<h1>User created</h1>" );
            } else {
                out.println( "<h1>Error creating the user</h1>" );
            }
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
    }

    public void destroy() {

        try {
            connection.close();
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
    }
}
