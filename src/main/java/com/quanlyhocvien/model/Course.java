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
public class Course {
    private int course_number;
    private String course_name;
    private String course_desc;
    private Date course_start_date;
    private Date course_end_date;
    private boolean course_state;

    public int getCourse_number() {
        return course_number;
    }

    public void setCourse_number(int course_number) {
        this.course_number = course_number;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_desc() {
        return course_desc;
    }

    public void setCourse_desc(String course_desc) {
        this.course_desc = course_desc;
    }

    public Date getCourse_start_date() {
        return course_start_date;
    }

    public void setCourse_start_date(Date course_start_date) {
        this.course_start_date = course_start_date;
    }

    public Date getCourse_end_date() {
        return course_end_date;
    }

    public void setCourse_end_date(Date course_end_date) {
        this.course_end_date = course_end_date;
    }

    public boolean isCourse_state() {
        return course_state;
    }

    public void setCourse_state(boolean course_state) {
        this.course_state = course_state;
    }
    
}
