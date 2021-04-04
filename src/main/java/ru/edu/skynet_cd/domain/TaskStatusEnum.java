package ru.edu.skynet_cd.domain;

public enum TaskStatusEnum {
    GETTING("получение"),
    ISSUED("выдано"),
    PROGRESS("выполняется"),
    COMPLETED("выполнено"),
    CANCELED("отменено");
    
    private final String status;
    
    TaskStatusEnum(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
