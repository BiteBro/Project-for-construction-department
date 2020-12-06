package ru.edu.skynet_cd.domain;

import java.time.LocalDate;

public class Report {
    private Long id;
    private String address;    
    private LocalDate reportDate;
    private Integer totalApartments;    
    private String boxPosition;    
    private String pointEnergy;    
    private String note;    

    public Report() {
    }

    public Report(String address, LocalDate reportDate, Integer totalApartments, 
                    String boxPosition, String pointEnergy, String note) {
        this.address = address;
        this.reportDate = reportDate;
        this.totalApartments = totalApartments;
        this.boxPosition = boxPosition;
        this.pointEnergy = pointEnergy;
        this.note = note;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
