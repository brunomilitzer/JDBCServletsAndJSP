package br.com.brunomilitzer.trainings.interservletcommunication;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = -9159505882907492122L;

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String userName = request.getParameter( "userName" );
        String password = request.getParameter( "password" );

        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );

            Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost/jdbcservlets", "bmilitzer", "s8mbt10a" );
            Statement statement = connection.createStatement( );

            ResultSet resultSet = statement.executeQuery( "SELECT * FROM user WHERE email = '" + userName + "' AND password = '" + password + "'" );
            RequestDispatcher requestDispatcher = request.getRequestDispatcher( "homeServlet" );

            if (resultSet.next()) {

                request.setAttribute( "message", "Welcome to Interserlet Communication " + userName );

                requestDispatcher.forward( request, response );
            } else {

                requestDispatcher = request.getRequestDispatcher( "login.html" );
                requestDispatcher.include( request, response );
            }

        } catch ( ClassNotFoundException | SQLException e ) {
            e.printStackTrace( );
        }
    }

}
