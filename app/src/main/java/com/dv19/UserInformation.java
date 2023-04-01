package com.dv19;

public class UserInformation {
    String email,password,imglink,coursename,courselink;

    public UserInformation(String email, String password, String imglink, String coursename, String courselink) {
        this.email = email;
        this.password = password;
        this.imglink = imglink;
        this.coursename = coursename;
        this.courselink = courselink;
    }

    @Override
    public String toString() {
        return "UserInformation{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", imglink='" + imglink + '\'' +
                ", coursename='" + coursename + '\'' +
                ", courselink='" + courselink + '\'' +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImglink() {
        return imglink;
    }

    public void setImglink(String imglink) {
        this.imglink = imglink;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getCourselink() {
        return courselink;
    }

    public void setCourselink(String courselink) {
        this.courselink = courselink;
    }
}
