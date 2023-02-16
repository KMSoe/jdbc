import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        StudentDAO stuDAO = new StudentDAO();

//        try {
//            Student stu1 = new Student("Lin Lin","lla@gmail.com","094347293","Sitthway");
//            stuDAO.saveStudent(stu1);
//            System.out.println("Success!");
//        } catch (SQLException e) {
//            System.out.println("SQL error.");
//        }

//        try {
//            Student st1 = stuDAO.getStudent(3);
//            st1.setEmail("coder@outlook.com");
//            stuDAO.updateStudent(st1);
//            System.out.println(st1);
//        } catch (SQLException e) {
//            System.out.println("SQL error.");
//        }

		try {
            stuDAO.deleteStudent(3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	    }
    }
}