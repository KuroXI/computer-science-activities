package Package;

import Package.Employee.EmployeeInfo;
import Package.Student.Acadinfo;
import Package.Student.Studentinfo;

public class MainProgram {
    public static void main(String[] args) {
        Studentinfo studentinfo1 = new Studentinfo(
                "Jordi Polla", 25, 'M', "IRAN", 9320756,"Mr. James Bond", "Mrs. Vice Ganda"
        );
        studentinfo1.display_student();

        EmployeeInfo employeeInfo1 = new EmployeeInfo("Audrey Lyle", "Faculty", "Professor");
        employeeInfo1.display_Employee();

        Acadinfo acadinfo1 = new Acadinfo(2468, 100, 90, 90, 100, 95);
        acadinfo1.displayEducDetails();

        System.out.println("NEXT STUDENT\n");

        Studentinfo studentinfo2 = new Studentinfo(
                "Hope Elizabeth", 28, 'F', "Iraq", 9320756,"Mr. Bong Go", "Mrs. Gal Gadot"
        );
        studentinfo2.display_student();

        EmployeeInfo employeeInfo2 = new EmployeeInfo("Bryan Salar", "Faculty", "Professor");
        employeeInfo2.display_Employee();

        Acadinfo acadinfo2 = new Acadinfo(13579, 98, 80, 80, 85, 90);
        acadinfo2.displayEducDetails();
    }
}
