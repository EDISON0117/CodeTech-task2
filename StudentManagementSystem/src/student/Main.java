package student;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static Manager mgr = new Manager();

    public static void main(String[] args) {
        System.out.println("==============================");
        System.out.println("   STUDENT MANAGEMENT SYSTEM  ");
        System.out.println("==============================");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1.  Add Student");
            System.out.println("2.  View Student");
            System.out.println("3.  Update Student");
            System.out.println("4.  Delete Student");
            System.out.println("5.  View All Students");
            System.out.println("6.  Search Student");
            System.out.println("7.  Filter by Course");
            System.out.println("8.  Add Grade");
            System.out.println("9.  View Grades");
            System.out.println("10. Exit");
            System.out.print("Choose: ");
            String ch = sc.nextLine();

            if (ch.equals("1")) {
                System.out.println("\n--- ADD STUDENT ---");
                System.out.print("Name   : ");
                String name = sc.nextLine();
                System.out.print("Age    : ");
                int age = Integer.parseInt(sc.nextLine());
                System.out.print("Course : ");
                String course = sc.nextLine();
                System.out.print("Email  : ");
                String email = sc.nextLine();
                Student s = mgr.add(name, age, course, email);
                System.out.println("Student added! ID: " + s.id);

            } else if (ch.equals("2")) {
                System.out.print("Student ID: ");
                mgr.showOne(sc.nextLine());

            } else if (ch.equals("3")) {
                System.out.print("Student ID: ");
                String id = sc.nextLine();
                System.out.print("New Name   : ");
                String name = sc.nextLine();
                System.out.print("New Age    : ");
                int age = Integer.parseInt(sc.nextLine());
                System.out.print("New Course : ");
                String course = sc.nextLine();
                System.out.print("New Email  : ");
                String email = sc.nextLine();
                mgr.update(id, name, age, course, email);

            } else if (ch.equals("4")) {
                System.out.print("Student ID: ");
                mgr.delete(sc.nextLine());

            } else if (ch.equals("5")) {
                mgr.showAll();

            } else if (ch.equals("6")) {
                System.out.print("Search (name/course/email): ");
                mgr.search(sc.nextLine());

            } else if (ch.equals("7")) {
                System.out.print("Course name: ");
                mgr.showByCourse(sc.nextLine());

            } else if (ch.equals("8")) {
                System.out.print("Student ID: ");
                String id = sc.nextLine();
                System.out.print("Subject   : ");
                String subject = sc.nextLine();
                System.out.print("Grade     : ");
                String grade = sc.nextLine();
                mgr.addGrade(id, subject, grade);

            } else if (ch.equals("9")) {
                System.out.print("Student ID: ");
                mgr.showGrades(sc.nextLine());

            } else if (ch.equals("10")) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
}