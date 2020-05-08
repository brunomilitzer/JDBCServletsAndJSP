package br.com.brunomilitzer.trainings.jdbc.metadata;

import java.sql.*;

public class MetadataDAO {

    public static void main( String[] args ) {
        try( Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3308/jdbcservlets?useSSL=false&serverTimezone=UTC", "bmilitzer", "s8mbt10a" );
             Statement statement = connection.createStatement()
        ) {

            ResultSet resultSet = statement.executeQuery( "SELECT * FROM account" );

            ResultSetMetaData metaData = resultSet.getMetaData();

            int columnCount = metaData.getColumnCount();

            for ( int i = 1; i <= columnCount; i++ ) {
                System.out.println(metaData.getColumnName( i ));
                System.out.println(metaData.getColumnTypeName( i ));
                System.out.println("-------------------------------");
            }

        } catch ( SQLException e ) {

            e.printStackTrace();
        }
    }
}
