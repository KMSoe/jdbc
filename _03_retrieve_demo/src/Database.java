import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private String url =  "jdbc:mysql://localhost:3306/portfolio";
    private String user = "root";
    private String password = "1111";
    private Connection conn;

    public void createConnection()
    {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/portfolio", this.user, this.password);
        } catch (SQLException e) {
            System.out.println("Can't connect to the database");
        }
    }

    public Connection getConnection()
    {
        return this.conn;
    }

    public List<Student> getStudents() throws SQLException{
        String sql = "select * from students";

        Statement stmt = conn.createStatement();
        ResultSet result = stmt.executeQuery(sql);

        List<Student> studentlist = new ArrayList<>();

        while (result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            String email = result.getString("email");
            String phone = result.getString("mobile");
            String currentCity = result.getString("current_city");
            Student student = new Student(id, name, email, phone, currentCity);

            studentlist.add(student);
        }

        return studentlist;
    }

    public Student getStudent(int id) throws SQLException
    {
        String sql = "select * from students where id=" + id;

        Statement stm  = conn.createStatement();
        ResultSet result = stm.executeQuery(sql);

        result.next();
        String name = result.getString("name");
        String email = result.getString("email");
        String phone = result.getString("mobile");
        String currentCity = result.getString("current_city");
        Student student = new Student(id, name, email, phone, currentCity);

        return student;

    }
}
