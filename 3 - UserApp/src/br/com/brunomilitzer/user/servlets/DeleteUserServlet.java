package br.com.brunomilitzer.user.servlets;

import javax.servlet.ServletConfig;
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

@WebServlet(urlPatterns = "/deleteServlet", initParams = {@WebInitParam( name = "dbUrl", value = "jdbc:mysql://localhost/jdbcservlets"), @WebInitParam( name = "dbUser", value = "bmilitzer"), @WebInitParam( name = "dbPassword", value = "s8mbt10a")})
public class DeleteUserServlet extends HttpServlet {

    private static final long serialVersionUID = -5816488406252510362L;

    private Connection connection;

    public void init( ServletConfig config ) {

        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );
            connection = DriverManager.getConnection( config.getInitParameter( "dbUrl" ), config.getInitParameter( "dbUser" ), config.getInitParameter( "dbPassword" ) );
        } catch ( SQLException | ClassNotFoundException e ) {
            e.printStackTrace( );
        }
    }

    @Override
    protected void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {

        String email = request.getParameter( "email" );

        try {
            Statement statement = connection.createStatement( );
            int result = statement.executeUpdate( "DELETE FROM user WHERE email = '" + email + "'" );

            PrintWriter out = response.getWriter( );

            if (result > 0) {
                out.println( "<h1>User deleted</h1>" );
            } else {
                out.println( "<h1>Invalid User</h1>" );
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
