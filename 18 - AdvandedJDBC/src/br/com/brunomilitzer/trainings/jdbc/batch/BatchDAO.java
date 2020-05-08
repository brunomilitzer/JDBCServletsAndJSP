package br.com.brunomilitzer.trainings.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDAO {

    public static void main( String[] args ) {

        try( Connection connection = DriverManager.getConnection( "jdbc:mysql://localhost:3308/jdbcservlets?useSSL=false&serverTimezone=UTC", "bmilitzer", "s8mbt10a" );
            Statement statement = connection.createStatement()
        ) {

            statement.addBatch( "INSERT INTO account VALUE (1, 'de Garcez', 'Vanessa', 3000)"  );
            statement.addBatch( "INSERT INTO account VALUE (2, 'Coelho', 'Tales', 4000)"  );
            statement.addBatch( "INSERT INTO account VALUE (3, 'Militzer', 'Bruno', 5000)"  );

            int[] results = statement.executeBatch();

            for ( int i = 0; i < results.length; i++ ) {
                System.out.println(results[i]);
            }

        } catch ( SQLException e ) {

            e.printStackTrace();
        }
    }
}
