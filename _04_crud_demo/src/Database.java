import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Database {
    private String url =  "jdbc:mysql://localhost:3306/jdbc";
    private String user = "root";
    private String password = "1111";
    private Connection conn;

    public void createConnection()
    {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", this.user, this.password);
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
            String phone = result.getString("phone");
            String currentCity = result.getString("current_city");
            Student student = new Student(id, name, email, phone, currentCity);

            studentlist.add(student);
        }

        return studentlist;
    }

    public Student getStudent(int id) throws SQLException
    {
        String sql = "select * from students where id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        ResultSet result = stmt.executeQuery();

        result.next();
        String name = result.getString("name");
        String email = result.getString("email");
        String phone = result.getString("phone");
        String currentCity = result.getString("current_city");
        Student student = new Student(id, name, email, phone, currentCity);

        return student;

    }

    public void updateStudent(Student student) throws SQLException
    {
        int id = student.getId();
        String name = student.getName();
        String email = student.getEmail();
        String phone = student.getPhone();
        String currentCity = student.getCurrentCity();

        String sql = "update students set name=?, email=?, phone=?, current_city=? where id=?";
        PreparedStatement stmt  = conn.prepareStatement(sql);
        stmt.setString(1, name);
        stmt.setString(2, email);
        stmt.setString(3, phone);
        stmt.setString(4, currentCity);
        stmt.setInt(5, id);

        stmt.executeUpdate();
    }

    public void deleteStudent(int id) throws SQLException
    {
        String sql = "delete from students where id=?";
        PreparedStatement stmt= conn.prepareStatement(sql);
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }
}
