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
public class Student {
    private int student_number;
    private String student_name;
    private String student_phone;
    private String student_address;
    private Date student_birth;
    private boolean student_gender;
    private boolean student_state;

    public int getStudent_number() {
        return student_number;
    }

    public void setStudent_number(int student_code) {
        this.student_number = student_code;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_phone() {
        return student_phone;
    }

    public void setStudent_phone(String student_phone) {
        this.student_phone = student_phone;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public Date getStudent_birth() {
        return student_birth;
    }

    public void setStudent_birth(Date student_birth) {
        this.student_birth = student_birth;
    }

    public boolean isStudent_gender() {
        return student_gender;
    }

    public void setStudent_gender(boolean student_gender) {
        this.student_gender = student_gender;
    }

    public boolean isStudent_state() {
        return student_state;
    }

    public void setStudent_state(boolean student_state) {
        this.student_state = student_state;
    }

    @Override
    public String toString() {
        return student_number + " - " + student_name;
    }
    
    
    
}
