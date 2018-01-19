package kata5p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Kata5P1 {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        Class.forName("org.sqlite.JDBC");
        Connection connection = DriverManager.getConnection("jdbc:sqlite:kata5.db");
        
        Statement statement = connection.createStatement();        
        ResultSet rs = statement.executeQuery("SELECT * FROM PEOPLE;");
                 
        while (rs.next()) {
            System.out.println("ID = " + rs.getInt("Id"));
            System.out.println("NAME = " + rs.getString("Name"));
        }
        
        statement.execute("CREATE TABLE IF NOT EXISTS 'MAIL' (" + "'Id' INTEGER PRIMARY KEY AUTOINCREMENT," + "'Mail' INTEGER NOT NULL);");
        
        String nameFile = "emails.txt";
        BufferedReader reader = new BufferedReader(new FileReader(new File(nameFile)));
        String mail;
        String query;
        
        while ((mail = reader.readLine()) != null) {
            if (!mail.contains("@")) continue;
            query = "INSERT INTO MAIL (Mail) VALUES ('" + mail + "');";
            statement.executeUpdate(query);
        }
    }
    
}