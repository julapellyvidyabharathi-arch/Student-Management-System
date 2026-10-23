package week_6;

public class Student {

    // Student details
    private int studentId;
    private String studentName;
    private String course;
    private int age;
    private double marks;

    // Constructor
    public Student(int studentId, String studentName,
                   String course, int age, double marks) {

        this.studentId = studentId;
        this.studentName = studentName;
        this.course = course;
        this.age = age;
        this.marks = marks;
    }

    // Returning student details
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getCourse() {
        return course;
    }

    public int getAge() {
        return age;
    }

    public double getMarks() {
        return marks;
    }

    // Updating student details
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
}