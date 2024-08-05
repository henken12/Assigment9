package edu.miu.cs.cs425;

import edu.miu.cs.cs425.model.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StudentMgmtApp {
    public static void main(String[] args) {
        var students = new Student[]{
                new Student(1001, "Dave", LocalDate.of(1951, 11, 11)),
                new Student(1002, "Anna", LocalDate.of(1990, 7, 12)),
                new Student(1003, "Erica", LocalDate.of(1974, 1, 31)),
                new Student(1004, "Carlos", LocalDate.of(2009, 8, 22)),
                new Student(1005, "Bob", LocalDate.of(1994, 5, 8)),

        };
        printListOfStudents(students);


        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        List<Student> platinumAlumni = getListOfPlatinumAlumniStudents(students);
        for (Student student : platinumAlumni) {
            System.out.println("Student ID: " + student.getStudentId() +
                    ", Name: " + student.getStudentName() +
                    ", Date of Admission: " + student.getDateOfBirth());
        }
    }

    public static void printListOfStudents(Student[] students) {
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getStudentName().compareTo(s2.getStudentName());
            }
        });


        for (Student student : students) {
            System.out.println("Student ID: " + student.getStudentId() +
                    ", Name: " + student.getStudentName() +
                    ", Date of birth: " + student.getDateOfBirth());
        }
    }

    public static List<Student> getListOfPlatinumAlumniStudents(Student[] students) {
        List<Student> platinumAlumni = new ArrayList<>();
        LocalDate thirtyYearsAgo = LocalDate.now().minusYears(30);

        for (Student student : students) {
            if (student.getDateOfBirth().isBefore(thirtyYearsAgo)) {
                platinumAlumni.add(student);
            }
        }

        platinumAlumni.sort(new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.getDateOfBirth().compareTo(s1.getDateOfBirth());
            }
        });

        return platinumAlumni;
    }
}