import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private String url =  "jdbc:mysql://localhost:3306/jdbc";
    private String user = "root";
    private String password = "1111";
    private Connection conn;
    private static Database db;

    private Database() {
        createConnection();
    }

    public static Database getInstance() {
        if(db == null) {
            db = new Database();
        }

        return db;
    }

    public void createConnection()
    {
        try {
            conn = DriverManager.getConnection(this.url, this.user, this.password);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("Can't connect to the database");
        }
    }

    public Connection getConnection()
    {
        return this.conn;
    }


}