

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.List;
public class AcademicResourceManagementSystem {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/university_system";
    // private static final String DB_USER = "root";
    // private static final String DB_PASSWORD = "1234";
    private static Connection connection;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String username = null;  // Declare the username variable outside the block

        try {
            System.out.println("Enter database username:");
            String dbUser = scanner.nextLine();

            System.out.println("Enter database password:");
            String dbPassword = scanner.nextLine();

            connection = DriverManager.getConnection(JDBC_URL, dbUser, dbPassword);

            System.out.println("Are you a student or a teacher? Enter 'student' or 'teacher':");
            String userType = scanner.nextLine();

            if ("student".equalsIgnoreCase(userType)) {
                // Student Functionality
                System.out.println("1. Register\n2. See Schedule\n3. See Grade\n4. See Material\nEnter your choice:");
                int studentChoice = scanner.nextInt();

            }



            else if ("teacher".equalsIgnoreCase(userType)) {
                // Teacher Functionality
                System.out.println("1. Upload Schedule\n  1. Upload Class Schedule\n  2. Upload Assignment Schedule\n  3. Upload Exam Schedule\n2. Upload Grade\n3. Upload Material\nEnter your choice:");
                int teacherChoice = scanner.nextInt();

            }


            else {
                System.out.println("Invalid user type");
            }






        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection error");
        } finally {
            // Close the scanner in the finally block to ensure it's always closed
            if (scanner != null) {
                scanner.close();
            }
        }




    }



}
