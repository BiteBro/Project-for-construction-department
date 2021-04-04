package ru.edu.skynet_cd.domain;

import java.io.Serializable;
import java.time.LocalDate;

public class Task implements Serializable{
    private Long idTask;   
    private String address;    
    private Long idExecutor;    
    private Long idCreator;    
    private TaskStatusEnum taskStatus;
    private LocalDate taskDate; 

    public Task() {
    }

    public Task(String address, Long idExecutor, Long idCreator, 
                    TaskStatusEnum taskStatus, LocalDate taskDate) {
        this.address = address;
        this.idExecutor = idExecutor;
        this.idCreator = idCreator;
        this.taskStatus = taskStatus;  
        this.taskDate = taskDate;                      
    }
    
    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getExecutor() {
        return idExecutor;
    }

    public void setExecutor(Long idExecutor) {
        this.idExecutor = idExecutor;
    }

    public Long getCreator() {
        return idCreator;
    }

    public void setCreator(Long idCreator) {
        this.idCreator = idCreator;
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

    @Override
    public String toString() {
        return "Task{" + "idTask=" + idTask + ", address=" + address + ", idExecutor=" + idExecutor + ", idCreator=" + idCreator + ", taskStatus=" + taskStatus + ", taskDate=" + taskDate + '}';
    }
}
