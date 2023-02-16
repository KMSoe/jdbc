import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Database db = new Database();
        db.createConnection();

//        try {
//            db.createConnection();
//            db.saveStudent();
//        } catch (SQLException e) {
//            System.out.println("SQL error");
//        }

//        try {
//            db.createConnection();
//		    List<Student> students = db.getStudents();
//
//            for(Student tmp:students)
//            {
//                System.out.println(tmp);
//            }
//
//            Student stu = db.getStudent(1);
//            System.out.println(stu);
//
//        } catch (SQLException e) {
//            System.out.println("SQL Syntex Error");
//        }

        // Update
//        try {
//            Student student = db.getStudent(1);
//            student.setEmail("kaungmyat@gmail.com");
//            db.updateStudent(student);
//            System.out.println(student);
//        } catch (SQLException e) {
//            System.out.println("SQL error");
//
//        }

        // Delete
        try {
            db.deleteStudent(1);
            System.out.println("Deleted");
        } catch (SQLException e) {
            System.out.println("SQL error");

        }

    }
}