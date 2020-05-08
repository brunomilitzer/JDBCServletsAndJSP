package br.com.brunomilitzer.training.servlets.jdbc.preparedstatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {

    private static final long serialVersionUID = 6878549426257305238L;

    private Connection connection;

    PreparedStatement preparedStatement;

    @Override
    public void init( ) {

        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            connection = DriverManager.getConnection( "jdbc:mysql://localhost/jdbcservlets", "bmilitzer", "s8mbt10a");
            preparedStatement = connection.prepareStatement( "INSERT INTO product VALUES (?, ?, ?, ?)" );

        } catch ( ClassNotFoundException | SQLException e ) {
            e.printStackTrace( );
        }
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) {

        int id = Integer.parseInt( request.getParameter( "id" ));
        String name = request.getParameter( "name" );
        String description = request.getParameter( "description" );
        int price = Integer.parseInt( request.getParameter( "price" ));

        try {
            preparedStatement.setInt( 1, id );
            preparedStatement.setString( 2, name );
            preparedStatement.setString( 3, description );
            preparedStatement.setInt( 4, price );

            int result = preparedStatement.executeUpdate( );

            response.setContentType( "text/html" );
            PrintWriter out = response.getWriter( );
            out.print( "<b>" + result + " Product Created</b>" );

        } catch ( SQLException | IOException e ) {
            e.printStackTrace( );
        }
    }

    @Override
    public void destroy( ) {

        try {
            preparedStatement.close();
            connection.close();
        } catch ( SQLException e ) {
            e.printStackTrace( );
        }
    }
}
