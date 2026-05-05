import java.util.ArrayList;
import java.util.List;

abstract class Person {
    protected String id;
    protected String name;

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}

class Student extends Person {
    private double gpa;

    public Student(String id, String name, double gpa) {
        super(id, name);
        this.gpa = gpa;
    }
}

class TeachingAssistant extends Person {
    public TeachingAssistant(String id, String name) {
        super(id, name);
    }
}

class Course {
    private String id;
    private String name;
    private int credits;

    public Course(String id, String name, int credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getCredits() { return credits; }
}

class GradeManager {
    private Student student;
    private Course course;
    private double assignmentScore;
    private double midtermScore;
    private double finalScore;

    public GradeManager(Student student, Course course, double assignment, double midterm, double finalScore) {
        this.student = student;
        this.course = course;
        this.assignmentScore = assignment;
        this.midtermScore = midterm;
        this.finalScore = finalScore;
    }

    public double calculateTotalScore() {
        return (assignmentScore * 0.2) + (midtermScore * 0.3) + (finalScore * 0.5);
    }

    public String getAcademicStatus() {
        double total = calculateTotalScore();
        if (total >= 8.5) return "Giỏi";
        if (total >= 7.0) return "Khá";
        if (total >= 5.5) return "Trung bình";
        return "Yếu";
    }

    public void printTranscript() {
        System.out.println("-------------------------------------------");
        System.out.println("BẢNG ĐIỂM SINH VIÊN");
        System.out.println("Tên: " + student.getName() + " (Mã SV: " + student.getId() + ")");
        System.out.println("Môn: " + course.getName() + " (" + course.getCredits() + " tín chỉ)");
        System.out.println("-------------------------------------------");
        System.out.println("Điểm bài tập: " + assignmentScore);
        System.out.println("Điểm giữa kỳ: " + midtermScore);
        System.out.println("Điểm cuối kỳ: " + finalScore);
        System.out.println("-------------------------------------------");
        System.out.println("TỔNG ĐIỂM: " + calculateTotalScore());
        System.out.println("HỌC LỰC: " + getAcademicStatus());
        System.out.println("-------------------------------------------");
    }
}

public class StudentManagementSystem {
    public static void main(String[] args) {
        Student s = new Student("SV001", "Tiên36", 3.6);
        Course c = new Course("JAVA", "Lập Trình Java", 3);

        GradeManager record = new GradeManager(s, c, 8.0, 7.5, 9.0);

        record.printTranscript();

        TeachingAssistant ta = new TeachingAssistant("TA123", "Nguyễn Hải Nam");
        System.out.println("Đã tạo Trợ giảng: " + ta.getName() + " - ID: " + ta.getId());
    }
}