import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Main{
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/javaproject";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "@Makida1";
    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            Scanner scanner = new Scanner(System.in);

            System.out.println("Are you a student or a teacher? Enter 'student' or 'teacher':");
            String userType = scanner.nextLine();

            if ("student".equalsIgnoreCase(userType)) {
                // Student Functionality
                System.out.println("Student Registration - Enter your username:");
                String username = scanner.nextLine();
                System.out.println("Enter your password:");
                String password = scanner.nextLine();

                // Store user information in the database
                registerStudent(connection, username, password);

                // Continue with the rest of the student functionality
                System.out.println("1. See Schedule\n2. See Grade\n3. See Material\nEnter your choice:");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // See Schedule
                        System.out.println("1. Class Schedule\n2. Exam Schedule\n3. Assignment Schedule\nEnter your choice:");
                        int scheduleChoice = scanner.nextInt();
                        switch (scheduleChoice) {
                            case 1:
                                // Implement logic for Class Schedule
                                viewClassSchedule(connection);
                                break;
                            case 2:
                                // Implement logic for Exam Schedule
                                viewExamSchedule(connection);
                                break;
                            case 3:
                                // Implement logic for Assignment Schedule
                                viewAssignmentSchedule(connection);
                                break;
                            default:
                                System.out.println("Invalid schedule choice");
                        }
                        break;

                    case 2:
                        // See Grade
                        // Implement logic for retrieving and displaying grades, calculating GPA
                        viewGrades(connection);
                        break;

                    case 3:
                        // See Material
                        // Implement logic for retrieving and displaying materials
                        viewMaterials(connection);
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } else if ("teacher".equalsIgnoreCase(userType)) {
                // Teacher Functionality
                System.out.println("1. Upload Schedule\n2. Upload Grade\n3. Upload Material\nEnter your choice:");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Upload Schedule
                        System.out.println("1. Upload Class Schedule\n2. Upload Exam Schedule\n3. Upload Assignment Schedule\nEnter your choice:");
                        int uploadScheduleChoice = scanner.nextInt();
                        switch (uploadScheduleChoice) {
                            case 1:
                                // Upload Class Schedule
                                uploadClassSchedule(connection);
                                break;
                            case 2:
                                // Upload Exam Schedule (unchanged)
                                break;
                            case 3:
                                // Upload Assignment Schedule (unchanged)
                                break;
                            default:
                                System.out.println("Invalid upload schedule choice");
                        }
                        break;

                    case 2:
                        // Upload Grade (unchanged)
                        break;

                    case 3:
                        // Upload Material (unchanged)
                        break;

                    default:
                        System.out.println("Invalid choice");
                }
            } else {
                System.out.println("Invalid user type");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Database connection error");
        }
    }

    // Common methods for both student and teacher
    private static void registerStudent(Connection connection, String username, String password) throws SQLException {
        String insertUserQuery = "INSERT INTO users (username, password, role) VALUES (?, ?, 'student')";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertUserQuery)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            System.out.println("Student registration successful!");
        }
    }

    private static void viewClassSchedule(Connection connection) throws SQLException {
        // Implement logic to retrieve and display class schedule from the database
        // Use PreparedStatement to execute queries
    }

    private static void viewExamSchedule(Connection connection) throws SQLException {
        // Implement logic to retrieve and display exam schedule from the database
    }

    private static void viewAssignmentSchedule(Connection connection) throws SQLException {
        // Implement logic to retrieve and display assignment schedule from the database
    }

    private static void viewGrades(Connection connection) throws SQLException {
        // Implement logic to retrieve and display grades from the database
    }

    private static void viewMaterials(Connection connection) throws SQLException {
        // Implement logic to retrieve and display materials from the database
    }

    private static void uploadClassSchedule(Connection connection) throws SQLException {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the subject:");
            String subject = scanner.nextLine();

            System.out.println("Enter the class date (YYYY-MM-DD):");
            String classDate = scanner.next();

            System.out.println("Enter the class time (HH:mm:ss):");
            String classTime = scanner.next();

            // Store class schedule in the database
            String insertClassScheduleQuery = "INSERT INTO class_schedule (subject, class_date, class_time, user_id) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(insertClassScheduleQuery)) {
                preparedStatement.setString(1, subject);
                preparedStatement.setString(2, classDate);
                preparedStatement.setString(3, classTime);
                // Assuming you have a user_id for the teacher, replace 1 with the actual user_id
                preparedStatement.setInt(4, 1);
                preparedStatement.executeUpdate();
                System.out.println("Class schedule uploaded successfully!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("Error uploading class schedule to the database");
            }
        }
    }

    // ... (unchanged methods for uploadExamSchedule, uploadAssignmentSchedule, etc.)
}
