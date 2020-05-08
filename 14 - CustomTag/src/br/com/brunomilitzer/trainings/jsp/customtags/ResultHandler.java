package br.com.brunomilitzer.trainings.jsp.customtags;

import javax.servlet.ServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.sql.*;

public class ResultHandler extends TagSupport {

    private Connection connection;
    private PreparedStatement statement;

    public ResultHandler( ) {

        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );

            Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3308/jdbcservlets?useSSL=false&serverTimezone=UTC", "bmilitzer", "s8mbt10a" );
            statement = connection.prepareStatement( "select * from user where email = ?" );
        } catch ( ClassNotFoundException | SQLException e ) {
            e.printStackTrace();
        }
    }

    @Override
    public int doStartTag( ) throws JspException {

        ServletRequest request = pageContext.getRequest();
        String email = request.getParameter( "email" );

        try {
            statement.setString( 1, email );
            ResultSet rs = statement.executeQuery();

            JspWriter out = pageContext.getOut();

            if (rs.next()) {
                out.print( "User Details are: <br/> First Name:" );
                out.print( rs.getString( 1 ) );
                out.print( "<br/> Last Name:" );
                out.print( rs.getString( 2 ) );
            } else {

                out.print( "User not found" );
            }
        } catch ( SQLException | IOException e ) {
            e.printStackTrace();
        }

        return Tag.SKIP_BODY;
    }

    @Override
    public void release( ) {

        try {
            statement.close();
            connection.close();
        } catch ( SQLException  e ) {
             e.printStackTrace();
        }
    }
}
