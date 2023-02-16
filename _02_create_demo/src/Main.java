import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Database db = new Database();

        try {
            db.createConnection();
            db.saveStudent();
        } catch (SQLException e) {
            System.out.println("SQL error");
        }
    }
}