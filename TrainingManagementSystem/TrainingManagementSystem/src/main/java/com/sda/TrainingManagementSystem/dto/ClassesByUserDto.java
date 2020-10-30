package com.sda.TrainingManagementSystem.dto;

import java.util.Date;

public class ClassesByUserDto {
    private String classUnit_name;
    private String classes_subject;
    private Date classes_date;

    public ClassesByUserDto( String classUnit_name, String classes_subject, Date classes_date ) {
        this.classUnit_name = classUnit_name;
        this.classes_subject = classes_subject;
        this.classes_date = classes_date;
    }

    public ClassesByUserDto() {
    }

    public String getClassUnit_name() {
        return classUnit_name;
    }

    public void setClassUnit_name( String classUnit_name ) {
        this.classUnit_name = classUnit_name;
    }

    public String getClasses_subject() {
        return classes_subject;
    }

    public void setClasses_subject( String classes_subject ) {
        this.classes_subject = classes_subject;
    }

    public Date getClasses_date() {
        return classes_date;
    }

    public void setClasses_date( Date classes_date ) {
        this.classes_date = classes_date;
    }
}
