package ru.edu.skynet_cd.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Report implements Serializable{ 
    private Long id;
    private String reportAddress;
    private LocalDate reportDate;
    private Integer totalApartments;    
    private String boxPosition;    
    private String pointEnergy;    
    private String note;    
    private Long idTask;
    
    public Report() {
    }

    public Report(String reportAddress, LocalDate reportDate, Integer totalApartments, String boxPosition, 
                    String pointEnergy, String note) {
        this.reportAddress = reportAddress;
        this.reportDate = reportDate;
        this.totalApartments = totalApartments;
        this.boxPosition = boxPosition;
        this.pointEnergy = pointEnergy;
        this.note = note;        
    }
    
    public Report(String reportAddress, LocalDate reportDate, Integer totalApartments, String boxPosition, 
                    String pointEnergy, String note, Long idTask) {
        this(reportAddress, reportDate, totalApartments, boxPosition, pointEnergy, note);
        this.idTask = idTask;
    }

    @Override
    public String toString() {
        return "Report{" + "id=" + id + ", reportAddress=" + reportAddress + 
                ", reportDate=" + reportDate + ", totalApartments=" + totalApartments + 
                ", boxPosition=" + boxPosition + ", pointEnergy=" + pointEnergy + 
                ", note=" + note + ", idTask=" + idTask + '}';
    }
    
    public String getReportAddress() {
        return reportAddress;
    }

    public void setReportAddress(String reportAddress) {
        this.reportAddress = reportAddress;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public LocalDate getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDate reportDate) {
        this.reportDate = reportDate;
    }

    public Integer getTotalApartments() {
        return totalApartments;
    }

    public void setTotalApartments(Integer totalApartments) {
        this.totalApartments = totalApartments;
    }

    public String getBoxPosition() {
        return boxPosition;
    }

    public void setBoxPosition(String boxPosition) {
        this.boxPosition = boxPosition;
    }

    public String getPointEnergy() {
        return pointEnergy;
    }

    public void setPointEnergy(String pointEnergy) {
        this.pointEnergy = pointEnergy;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
