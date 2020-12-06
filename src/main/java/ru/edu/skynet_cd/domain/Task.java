package ru.edu.skynet_cd.domain;

import java.time.LocalDate;
import java.util.List;

public class Task {
    private Long id;   
    private String address;    
    private User executor;    
    private User creator;    
    private LocalDate taskDate;    
    private TaskStatusEnum taskStatus;    
    private List<Material> arrayMaterial;
    private Report report;

    public Task() {
    }

    public Task(String address, User executor, User creator, LocalDate createDate, 
                TaskStatusEnum taskStatus, List<Material> arrayMaterial, Report report) {
        this.address = address;
        this.executor = executor;
        this.creator = creator;
        this.taskDate = createDate;
        this.taskStatus = taskStatus;
        this.arrayMaterial = arrayMaterial;
        this.report = report;
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

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public LocalDate getTaskDate() {
        return taskDate;
    }

    public void setTaskDate(LocalDate taskDate) {
        this.taskDate = taskDate;
    }

    public TaskStatusEnum getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(TaskStatusEnum taskStatus) {
        this.taskStatus = taskStatus;
    }

    public List<Material> getArrayMaterial() {
        return arrayMaterial;
    }

    public void setArrayMaterial(List<Material> arrayMaterial) {
        this.arrayMaterial = arrayMaterial;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    
}
