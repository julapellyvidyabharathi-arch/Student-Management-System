
package week_6;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    private static final String FILE_NAME = "students.txt";

    public static void saveStudents(ArrayList<Student> students) {

        try (BufferedWriter writer =
                new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Student s : students) {
                writer.write(
                    s.getStudentId() + "|" +
                    s.getStudentName() + "|" +
                    s.getCourse() + "|" +
                    s.getAge() + "|" +
                    s.getMarks()
                );

                writer.newLine();
            }

            System.out.println("Student records saved.");

        } catch (IOException e) {
            System.out.println("Error saving records: " + e.getMessage());
        }
    }

    public static ArrayList<Student> loadStudents() {

        ArrayList<Student> students = new ArrayList<>();

        File file = new File(FILE_NAME);

        if (!file.exists()) {
            return students;
        }

        try (BufferedReader reader =
                new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|", -1);

                if (data.length == 5) {
                    try {
                        int id = Integer.parseInt(data[0]);
                        String name = data[1];
                        String course = data[2];
                        int age = Integer.parseInt(data[3]);
                        double marks = Double.parseDouble(data[4]);

                        students.add(
                            new Student(id, name, course, age, marks)
                        );

                    } catch (NumberFormatException e) {
                        System.out.println("Skipping an invalid student record.");
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Error loading records: " + e.getMessage());
        }

        return students;
    }
}
