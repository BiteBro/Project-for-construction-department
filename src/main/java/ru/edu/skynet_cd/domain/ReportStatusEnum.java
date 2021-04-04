package ru.edu.skynet_cd.domain;

public enum ReportStatusEnum {
    FILLED("ЗАПОЛНЕН"),
    UNFILLED("НЕЗАПОЛНЕН");
    
    private final String status;

    ReportStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
