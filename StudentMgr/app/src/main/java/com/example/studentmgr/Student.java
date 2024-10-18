package com.example.studentmgr;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Student implements Serializable {
    private String name;
    private String id;
    private String gender;
    private String college;
    private String major;
    private Date birthDate;
    private String hobbies;
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


    public Student(String name, String id, String gender, String college, String major, Date birthDate, String hobbies) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.college = college;
        this.major = major;
        this.birthDate = birthDate;
        this.hobbies = hobbies;
    }

    public Student() {
    }

    @Override
    public String toString() {

        String msg = "name=" + name + '\n' +
                "id=" + id + '\n' +
                "gender=" + gender + '\n' +
                "college=" + college + '\n' +
                "major=" + major + '\n';
        if (birthDate != null) {
            msg += "birthDate=" + dateFormat.format(birthDate) + '\n';
        } else {
            msg += "birthDate=null\n";
        }
        msg += "hobbies=" + hobbies;
        return msg;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }
}
