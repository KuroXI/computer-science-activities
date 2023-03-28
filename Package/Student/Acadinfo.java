package Package.Student;

import java.text.DecimalFormat;

public class Acadinfo {
    private final int studentNumber;
    private final int attendance;
    private final int quiz1;
    private final int quiz2;
    private final int midterm_grade;
    private final int final_grade;

    public Acadinfo(int studentNumber, int attendance, int quiz1, int quiz2, int midterm_grade, int final_grade) {
        this.studentNumber = studentNumber;
        this.attendance = attendance;
        this.quiz1 = quiz1;
        this.quiz2 = quiz2;
        this.midterm_grade = midterm_grade;
        this.final_grade = final_grade;
    }

    public void displayEducDetails() {
        System.out.println("STUDENT EDUCATIONAL DETAILS");
        System.out.println("Student Number: " + studentNumber);
        System.out.println("Student Average: " + average());
        System.out.println("Student Attendance: " + attendance + "%\n");
    }

    public String average() {
        DecimalFormat df = new DecimalFormat("##.00");
        int total = quiz1 + quiz2 + midterm_grade + final_grade;

        return df.format(total / 4);
    }
}
