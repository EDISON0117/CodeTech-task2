package student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Manager {
    Map<String, Student> students = new HashMap<>();
    int count = 1000;

    Student add(String name, int age, String course, String email) {
        String id = "STU" + (++count);
        Student s = new Student(id, name, age, course, email);
        students.put(id, s);
        return s;
    }

    Student get(String id) {
        return students.get(id.toUpperCase());
    }

    void update(String id, String name, int age, String course, String email) {
        Student s = get(id);
        if (s == null) { System.out.println("Student not found."); return; }
        s.name   = name;
        s.age    = age;
        s.course = course;
        s.email  = email;
        System.out.println("Student updated.");
    }

    void delete(String id) {
        if (students.remove(id.toUpperCase()) != null)
            System.out.println("Student removed.");
        else
            System.out.println("Student not found.");
    }

    void addGrade(String id, String subject, String grade) {
        Student s = get(id);
        if (s == null) { System.out.println("Student not found."); return; }
        s.grades.add(subject + ": " + grade);
        System.out.println("Grade added.");
    }

    void showGrades(String id) {
        Student s = get(id);
        if (s == null) { System.out.println("Student not found."); return; }
        if (s.grades.isEmpty()) { System.out.println("No grades found."); return; }
        System.out.println("\n--- Grades: " + s.name + " ---");
        for (String g : s.grades) System.out.println("  " + g);
    }

    void showOne(String id) {
        Student s = get(id);
        if (s == null) { System.out.println("Student not found."); return; }
        System.out.println("\n--- Student Details ---");
        System.out.println("ID     : " + s.id);
        System.out.println("Name   : " + s.name);
        System.out.println("Age    : " + s.age);
        System.out.println("Course : " + s.course);
        System.out.println("Email  : " + s.email);
        System.out.println("Grades : " + (s.grades.isEmpty() ? "None" : s.grades.size() + " entries"));
    }

    void showAll() {
        if (students.isEmpty()) { System.out.println("No students found."); return; }
        System.out.println("\n--- All Students ---");
        for (Student s : students.values()) {
            System.out.println(s.id + " | " + s.name + " | Age: " + s.age + " | " + s.course + " | " + s.email);
        }
    }

    void search(String keyword) {
        List<Student> result = new ArrayList<>();
        for (Student s : students.values()) {
            if (s.name.toLowerCase().contains(keyword.toLowerCase()) ||
                    s.course.toLowerCase().contains(keyword.toLowerCase()) ||
                    s.email.toLowerCase().contains(keyword.toLowerCase())) {
                result.add(s);
            }
        }
        if (result.isEmpty()) { System.out.println("No match found."); return; }
        System.out.println("\n--- Search Results ---");
        for (Student s : result) {
            System.out.println(s.id + " | " + s.name + " | " + s.course + " | " + s.email);
        }
    }

    void showByCourse(String course) {
        boolean found = false;
        System.out.println("\n--- Students in: " + course + " ---");
        for (Student s : students.values()) {
            if (s.course.equalsIgnoreCase(course)) {
                System.out.println(s.id + " | " + s.name + " | " + s.email);
                found = true;
            }
        }
        if (!found) System.out.println("No students in this course.");
    }
}