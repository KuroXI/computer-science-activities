package Package.Employee;

public class EmployeeInfo {
    private final String name;
    private final String designation;
    private final String position;

    public EmployeeInfo(String name, String designation, String position) {
        this.name = name;
        this.designation = designation;
        this.position = position;
    }

    public void display_Employee() {
        System.out.println("EMPLOYEE'S DETAILS");
        System.out.println("Employee Name: " + name);
        System.out.println("Designation: " + designation);
        System.out.println("Academic Position: " + position);
        System.out.println();
    }
}
