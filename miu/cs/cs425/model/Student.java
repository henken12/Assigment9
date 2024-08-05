package edu.miu.cs.cs425.model;

import lombok.*;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Setter
@Getter

public class Student {
    private Integer studentId;
    private String studentName;
    private LocalDate dateOfBirth;

    Student(Integer customerId, String customerName) {
        this.studentId = studentId;
        this.studentName = studentName;
    }


}
