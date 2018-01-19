package kata5p1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

     public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:kata5.db");
        
        Statement statement = connection.createStatement();        
        ResultSet rs = statement.executeQuery("SELECT * FROM PEOPLE;");
                 
        while (rs.next()) {
            System.out.println("ID = " + rs.getInt("Id"));
            System.out.println("NAME = " + rs.getString("Name"));
            System.out.println("APELLIDOS = " + rs.getString("Apellidos"));
            System.out.println("ORGANIZACION = " + rs.getString("Departamento"));
        }
    }
     
}