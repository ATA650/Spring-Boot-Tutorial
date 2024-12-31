package com.example.demo.student;

import jakarta.persistence.*;


import java.time.LocalDate;
import java.time.Period;

/**
 * This is the student class
 * @author Ahmed Tariq
 */
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )

    private Long id;
    /** The name of student */
    private String name;
    /** student email */
    private String email;
    /** students date of birth */
    private LocalDate dob;
    /** student age */
    @Transient
    private Integer age;

    /**
     * This is the general constructor
     */
    public Student() {
    }

    /**
     * This constructor uses all the private variables
     * @param id the id
     * @param name the name
     * @param email the email
     * @param dob the date of birth
     */
    public Student
    (Long id, String name, String email, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    /**
     * This constructor does not use the id
     * @param name the name
     * @param email the email
     * @param dob the date of birth

     */
    public Student(String name, String email, LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;

    }

    /**
     * returns the id
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * sets the id
     * @param id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * gets the name
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * sets the name
     * @param name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * gets the email
     * @return the email to set
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets the email
     * @param email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * gets the date of birth
     * @return the date of birth of student
     */
    public LocalDate getDob() {
        return dob;
    }

    /**
     * setter for date of birth
     * @param dob of the student
     */
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    /**
     * gets the age by calculating it
     * @return age of student
     */
    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    /**
     * sets the age
     * @param age of the student
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                ", age=" + age +
                '}';
    }
}

