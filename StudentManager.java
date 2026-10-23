
package week_6;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager implements StudentOperations {

    ArrayList<Student> studentList = new ArrayList<>();

    Scanner sc = new Scanner(System.in);

    // Load saved student records
    public StudentManager() {
        studentList = FileHandler.loadStudents();
    }

    // Add student
    @Override
    public void addStudent(Student student) {

        for (Student s : studentList) {
            if (s.getStudentId() == student.getStudentId()) {
                System.out.println("Student ID already exists!");
                return;
            }
        }

        studentList.add(student);
        FileHandler.saveStudents(studentList);

        System.out.println("Student added successfully!");
    }

    // View all students
    @Override
    public void viewStudents() {

        if (studentList.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        for (Student s : studentList) {
            System.out.println("----------------------");
            System.out.println("ID: " + s.getStudentId());
            System.out.println("Name: " + s.getStudentName());
            System.out.println("Course: " + s.getCourse());
            System.out.println("Age: " + s.getAge());
            System.out.println("Marks: " + s.getMarks());
        }

        System.out.println("----------------------");
    }

    // Search student
    @Override
    public void searchStudent(int studentId) {

        for (Student s : studentList) {
            if (s.getStudentId() == studentId) {
                System.out.println("Student found!");
                System.out.println("ID: " + s.getStudentId());
                System.out.println("Name: " + s.getStudentName());
                System.out.println("Course: " + s.getCourse());
                System.out.println("Age: " + s.getAge());
                System.out.println("Marks: " + s.getMarks());
                return;
            }
        }

        System.out.println("Student ID not found.");
    }

    // Update student
    @Override
    public void updateStudent(int studentId) {

        for (Student s : studentList) {

            if (s.getStudentId() == studentId) {

                try {
                    System.out.print("Enter new name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter new course: ");
                    String course = sc.nextLine();

                    System.out.print("Enter new age: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter new marks: ");
                    double marks = Double.parseDouble(sc.nextLine());

                    if (name.trim().isEmpty() ||
                            course.trim().isEmpty() ||
                            age <= 0 || marks < 0 || marks > 100) {
                        System.out.println("Invalid student details.");
                        return;
                    }

                    s.setStudentName(name);
                    s.setCourse(course);
                    s.setAge(age);
                    s.setMarks(marks);

                    FileHandler.saveStudents(studentList);

                    System.out.println("Student updated successfully!");

                } catch (NumberFormatException e) {
                    System.out.println("Please enter valid numbers.");
                }

                return;
            }
        }

        System.out.println("Student ID not found.");
    }

    // Delete student
    @Override
    public void deleteStudent(int studentId) {

        for (Student s : studentList) {

            if (s.getStudentId() == studentId) {
                studentList.remove(s);

                FileHandler.saveStudents(studentList);

                System.out.println("Student deleted successfully!");
                return;
            }
        }

        System.out.println("Student ID not found.");
    }

    // Display summary using multithreading
    public void showSummary() {

        StudentSummaryThread thread =
                new StudentSummaryThread(studentList);

        thread.start();
    }
}
