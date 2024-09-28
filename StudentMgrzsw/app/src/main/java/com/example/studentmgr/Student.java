package com.example.studentmgr;

import java.io.Serializable;

public class Student implements Serializable {
    private String name;
    private String id;
    private String gender;
    private String college;
    private String major;
    private int profileImageResId;
    private String hobbies;

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

    public int getProfileImageResId() {
        return profileImageResId;
    }

    public void setProfileImageResId(int profileImageResId) {
        this.profileImageResId = profileImageResId;
    }

    public Student(String name, String id, String gender, String college, String major, int profileImageResId, String hobbies) {
        this.name = name;
        this.id = id;
        this.gender = gender;
        this.college = college;
        this.major = major;
        this.profileImageResId = profileImageResId;
        this.hobbies = hobbies;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", gender='" + gender + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", profileImageResId=" + profileImageResId +
                ", hobbies='" + hobbies + '\'' +
                '}';
    }
}
