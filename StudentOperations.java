package week_6;

public interface StudentOperations {

    void addStudent(Student student);

    void viewStudents();

    void searchStudent(int studentId);

    void updateStudent(int studentId);

    void deleteStudent(int studentId);
}