/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quanlyhocvien.model;

import java.util.Date;

/**
 *
 * @author Jake
 */
public class Classes {
    private int class_number;
    private Course course;
    private Student student;
    private Date class_reg_date;
    private boolean class_state;

    public int get_class_number() {
        return class_number;
    }

    public void set_class_number(int _class_number) {
        this.class_number = _class_number;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Date getReg_date() {
        return class_reg_date;
    }

    public void setReg_date(Date reg_date) {
        this.class_reg_date = reg_date;
    }

    public boolean isClass_state() {
        return class_state;
    }

    public void setClass_state(boolean class_state) {
        this.class_state = class_state;
    }
    
}
