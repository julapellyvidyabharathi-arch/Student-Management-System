
package week_6;

import java.util.ArrayList;

public class StudentSummaryThread extends Thread {

    private ArrayList<Student> students;

    public StudentSummaryThread(ArrayList<Student> students) {
        this.students = students;
    }

    @Override
    public void run() {

        int totalStudents = students.size();
        double totalMarks = 0;

        for (Student s : students) {
            totalMarks += s.getMarks();
        }

        System.out.println("\n===== STUDENT SUMMARY =====");
        System.out.println("Total Students: " + totalStudents);

        if (totalStudents > 0) {
            double average = totalMarks / totalStudents;
            System.out.println("Average Marks: " + average);
        } else {
            System.out.println("No student records available.");
        }

        System.out.println("Summary completed in a separate thread.");
    }
}
