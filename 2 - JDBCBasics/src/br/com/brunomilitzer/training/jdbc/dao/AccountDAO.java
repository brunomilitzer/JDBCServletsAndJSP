package br.com.brunomilitzer.training.jdbc.dao;

import java.sql.*;

public class AccountDAO {

    public static void main( String[] args ) {

        try(Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost/jdbcservlets", "bmilitzer", "s8mbt10a" );

            Statement statement = connection.createStatement( );
            ResultSet rs = statement.executeQuery( "SELECT * FROM account" );
        ) {

            System.out.println(connection );

            //int result = statement.executeUpdate( "INSERT INTO account VALUES (1, 'Militzer', 'Bruno', 10000)" );

            //int result = statement.executeUpdate( "UPDATE account SET bal = 50000 WHERE accno = 1" );

            //int result = statement.executeUpdate( "DELETE FROM account WHERE accno = 1" );

            //System.out.println(result + " rows got inserted/updated/deleted" );

            while ( rs.next() ) {

                System.out.println(rs.getString( 2 ) );
                System.out.println(rs.getString( 3 ) );
                System.out.println(rs.getInt( 4 ) );
            }

        } catch ( SQLException e ) {

            e.printStackTrace( );
        }
    }

}
