package com.example.demo.student;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.data.annotation.Transient;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table
public class Student {
    @Id
    @SequenceGenerator(
        name= "student-sequence",
        sequenceName = "student_sequence",
        allocationSize=1
    )
    
@GeneratedValue(
    strategy = GenerationType.SEQUENCE,
    generator = "student-sequence"
)
    private Long id;
    private String name;    
    private String email;   
    private LocalDate dob;
    @Transient
    private Integer age;

    public Student() {

    }
    
    public Student(Long id, String name, String email, LocalDate dob){
        this.id = id;
        this.name =name; 
        this.email = email; 
        this.dob = dob;

    }
    public Student( String name, String email, LocalDate dob){
        this.name =name; 
        this.email = email; 
        this.dob = dob;
    }
    
    
    public void setId(Long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    
public long getId(){
    return id;
}
public String getName(){
return name;
}   
public String getEmail(){  
return email; 
} 
public LocalDate getDob(){ 
return dob;
}

public Integer getAge() {
    return Period.between(this.dob, LocalDate.now()).getYears();
}


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", dob='" + getDob() + "'" +
            ", age='" + getAge() + "'" +
            "}";
    }




}
