import java.util.ArrayList;
import java.util.Scanner;

class StudentGradeTracker{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        Student student = new Student();
        System.out.println("Welcome to the Student Grade Tracker\n");

        // Adding students
        while (true) {
            System.out.print("Enter student name (or 'done' to finish): ");
            String studentName = input.nextLine();

            if (studentName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter comma-separated grades for " + studentName + ": ");
            String[] gradesInput = input.nextLine().split(",");
            ArrayList<Double> studentGrades = new ArrayList<>();

            for (String grade : gradesInput) {
                studentGrades.add(Double.parseDouble(grade.trim()));
            }

            Student.addStudent(studentList, studentName, studentGrades);
        }

        // Displaying student information
        System.out.println("\n------------------Student Information:--------------------");

        for (Student s : studentList) {
            System.out.println("\nStudent Name: " + s.name);
            System.out.println("Grades: " + s.grades);
            System.out.println("Average: " + s.Avg(s.grades));
            System.out.println("Lowest Grade: " + s.getLowGrad(s.grades));
            System.out.println("Highest Grade: " + s.getHighGrad(s.grades));
            System.out.println("Grade Letter: " + s.gradeLetter(s.grades));
            System.out.println("-----------------------");
        }

        input.close();
    }
}