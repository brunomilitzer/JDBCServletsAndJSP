<%--
  Created by IntelliJ IDEA.
  User: bruno
  Date: 4/16/2020
  Time: 3:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.sql.*" contentType="text/html;charset=UTF-8" language="java" %>

<%!
    Connection connection;
    PreparedStatement statement;

    public void jspInit() {

        try {
            Class.forName( "com.mysql.cj.jdbc.Driver" );

            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3308/jdbcservlets?useSSL=false&serverTimezone=UTC", "bmilitzer", "s8mbt10a" );
            statement = connection.prepareStatement( "insert into account values (?, ?, ?, ?)" );

        } catch ( Exception exception ) {

            exception.printStackTrace();
        }
    }

    public void jspDestroy() {

        try {
            statement.close();
            connection.close();

        } catch ( Exception exception ) {
            exception.printStackTrace();
        }
    }
%>

<%
    int accno = Integer.parseInt( request.getParameter( "accno" ) );
    int bal = Integer.parseInt( request.getParameter( "bal" ) );
    String lastname = request.getParameter( "lastname" );
    String firstname = request.getParameter( "firstname" );

    try {
        statement.setInt( 1, accno );
        statement.setString( 2, lastname );
        statement.setString( 3, firstname );
        statement.setInt( 4, bal );

        statement.executeUpdate();

    } catch ( Exception exception ) {
        exception.printStackTrace();
    }


%>

<%@include file="openaccount.html"

%>