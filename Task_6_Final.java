
package week_6;

import java.util.Scanner;

public class Task_6_Final {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        int choice = 0;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.println("7. Student Summary");
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        try {
                            System.out.print("Enter Student ID: ");
                            int id = Integer.parseInt(sc.nextLine());

                            System.out.print("Enter Student Name: ");
                            String name = sc.nextLine();

                            System.out.print("Enter Course: ");
                            String course = sc.nextLine();

                            System.out.print("Enter Age: ");
                            int age = Integer.parseInt(sc.nextLine());

                            System.out.print("Enter Marks: ");
                            double marks = Double.parseDouble(sc.nextLine());

                            if (id <= 0 || age <= 0 ||
                                    marks < 0 || marks > 100 ||
                                    name.trim().isEmpty() ||
                                    course.trim().isEmpty()) {
                                System.out.println("Invalid student details.");
                                break;
                            }

                            Student student =
                                    new Student(id, name, course, age, marks);

                            manager.addStudent(student);

                        } catch (NumberFormatException e) {
                            System.out.println("Please enter valid numbers.");
                        }
                        break;

                    case 2:
                        manager.viewStudents();
                        break;

                    case 3:
                        try {
                            System.out.print("Enter Student ID to search: ");
                            int searchId = Integer.parseInt(sc.nextLine());
                            manager.searchStudent(searchId);
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid ID.");
                        }
                        break;

                    case 4:
                        try {
                            System.out.print("Enter Student ID to update: ");
                            int updateId = Integer.parseInt(sc.nextLine());
                            manager.updateStudent(updateId);
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid ID.");
                        }
                        break;

                    case 5:
                        try {
                            System.out.print("Enter Student ID to delete: ");
                            int deleteId = Integer.parseInt(sc.nextLine());
                            manager.deleteStudent(deleteId);
                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a valid ID.");
                        }
                        break;

                    case 6:
                        System.out.println("Thank you for using the system!");
                        break;

                    case 7:
                        manager.showSummary();
                        break;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid menu number.");
                choice = 0;
            }

        } while (choice != 6);

        sc.close();
    }
}
