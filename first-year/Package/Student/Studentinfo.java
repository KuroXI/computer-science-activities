package Package.Student;

public class Studentinfo {
    private final String name;
    private final int age;
    private final char gender;
    private final String address;
    private final int number;
    private final String father;
    private final String mother;

    public Studentinfo(String name, int age, char gender, String address, int number, String father, String mother) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.number = number;
        this.father = father;
        this.mother = mother;
    }

    public void display_student() {
        System.out.println("STUDENT DETAILS");
        System.out.println("Student Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Student Gender: " + gender);
        System.out.println("Student Address: " + address);
        System.out.println("Contact Number: " + number);
        System.out.println("Father's name: " + father);
        System.out.println("Mother's name: " + mother);
        System.out.println();
    }
}
