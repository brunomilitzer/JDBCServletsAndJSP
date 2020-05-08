package br.com.brunomilitzer.trainings.jdbc.tm;

import java.sql.*;

public class TransactionDAO {

    public static void main( String[] args ) {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3308/jdbcservlets?useSSL=false&serverTimezone=UTC", "bmilitzer", "s8mbt10a" );
            Statement statement = connection.createStatement();
            connection.setAutoCommit( false );

            statement.executeUpdate( "UPDATE account SET bal = bal - 500 WHERE accno = 2" );
            statement.executeUpdate( "UPDATE account SET bal = bal + 500 WHERE accno = 1" );

            connection.commit();

        } catch ( SQLException e ) {

            e.printStackTrace();

            try {
                connection.close();
                connection.rollback();
            } catch ( SQLException throwables ) {
                throwables.printStackTrace();
            }
        }
    }
}
