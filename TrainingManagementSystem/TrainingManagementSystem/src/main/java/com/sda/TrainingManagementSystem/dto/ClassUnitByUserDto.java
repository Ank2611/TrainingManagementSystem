package com.sda.TrainingManagementSystem.dto;

public class ClassUnitByUserDto {
    private Long idClassUnit;
    private String classUnitName;

    public ClassUnitByUserDto( Long idClassUnit, String classUnitName ) {
        this.idClassUnit = idClassUnit;
        this.classUnitName = classUnitName;
    }

    public ClassUnitByUserDto() {
    }

    public Long getIdClassUnit() {
        return idClassUnit;
    }

    public void setIdClassUnit( Long idClassUnit ) {
        this.idClassUnit = idClassUnit;
    }

    public String getClassUnitName() {
        return classUnitName;
    }

    public void setClassUnitName( String classUnitName ) {
        this.classUnitName = classUnitName;
    }
}
