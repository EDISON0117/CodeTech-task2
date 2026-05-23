package student;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String id;
    String name;
    int age;
    String course;
    String email;
    List<String> grades;

    Student(String id, String name, int age, String course, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.email = email;
        this.grades = new ArrayList<>();
    }
}