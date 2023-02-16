import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/portfolio";
        String dbUser = "root";
        String dbPassword = "1111";

        try {
            Connection conn = DriverManager.getConnection(url, dbUser, dbPassword);
            System.out.println("Connected");
        } catch (SQLException e) {
            System.out.println("Can't connect to database");
        }
    }
}