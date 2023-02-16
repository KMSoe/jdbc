import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Database {
    private Connection conn;
    private String dbUser = "root";
    private String dbPassword = "1111";

    public void createConnection()
    {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portfolio", this.dbUser, this.dbPassword);
        } catch (SQLException e) {
            System.out.println("Can't connect to the database");
            System.exit(1);
        }
    }

    public Connection getConnection()
    {
        return this.conn;
    }

    public void saveStudent() throws SQLException
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter email: ");
        String email=sc.nextLine();

        System.out.println("Enter Mobile No.");
        String phone = sc.nextLine();

        System.out.println("Current City");
        String curCity = sc.nextLine();

        String sql = "insert into students (name,email,mobile,current_city) values ('" + name + "','" + email + "','" + phone + "','" + curCity + "')";
        Statement stmt = conn.createStatement();

        stmt.executeUpdate(sql);
    }
}
