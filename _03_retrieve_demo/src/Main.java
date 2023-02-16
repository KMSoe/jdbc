import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Database db = new Database();

//        try {
//            db.createConnection();
//            db.saveStudent();
//        } catch (SQLException e) {
//            System.out.println("SQL error");
//        }

        try {
            db.createConnection();
		    List<Student> students = db.getStudents();

            for(Student tmp:students)
            {
                System.out.println(tmp);
            }

            Student stu = db.getStudent(1);
            System.out.println(stu);

        } catch (SQLException e) {
            System.out.println("SQL Syntex Error");
        }


    }
}