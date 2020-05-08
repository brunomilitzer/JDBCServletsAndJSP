package br.com.brunomilitzer.user.servlets;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Enumeration;

public class ReadUserServlet extends HttpServlet {

    private static final long serialVersionUID = 8439033159605638084L;

    private Connection connection;

    public void init( ServletConfig config ) {

        try {
            ServletContext context = config.getServletContext( );

            Enumeration<String> paramatersNames = config.getInitParameterNames( );

            while ( paramatersNames.hasMoreElements() ) {

                String eachName = paramatersNames.nextElement( );

                System.out.println("Context Param Name: " + eachName );
                System.out.println("Context Param Value: " + context.getInitParameter( eachName ) );
            }

            System.out.println("init()" );
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            connection = DriverManager.getConnection( context.getInitParameter( "dbUrl" ), context.getInitParameter( "dbUser" ), context.getInitParameter( "dbPassword" ) );
        } catch ( SQLException | ClassNotFoundException e ) {
            e.printStackTrace( );
        }
    }

    @Override
    protected void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        System.out.println("doGet()" );

        try {
            Statement statement = connection.createStatement( );
            ResultSet resultSet = statement.executeQuery( "SELECT * FROM user" );

            PrintWriter out = response.getWriter( );
            out.print( "<table>" );
            out.print( "<tr>" );
            out.print( "<th>" );
            out.println( "First Name" );
            out.print( "</th>" );
            out.print( "<th>" );
            out.println( "Last Name" );
            out.print( "</th>" );
            out.print( "<th>" );
            out.println( "E-mail" );
            out.print( "</th>" );
            out.print( "</tr>" );

            while ( resultSet.next() ) {

                out.println( "<tr>" );
                out.println( "<td>" );
                out.println( resultSet.getString( 1 ) );
                out.println( "</td>" );
                out.println( "<td>" );
                out.println( resultSet.getString( 2 ) );
                out.println( "</td>" );
                out.println( "<td>" );
                out.println( resultSet.getString( 3 ) );
                out.println( "</td>" );
                out.println( "</tr>" );
            }

            out.print( "</table>" );

        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
    }

    public void destroy() {

        System.out.println("destroy()" );

        try {
            connection.close();
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
    }
}
