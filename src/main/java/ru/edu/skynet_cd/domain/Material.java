package ru.edu.skynet_cd.domain;

import java.io.Serializable;

public class Material implements Serializable{
    private String nameMatherial;    
    private Integer issued;    
    private Integer received;
    private Long idTask;

    public Material() {
    }

    public Material(String nameMatherial, Integer issued, Integer received) {
        this.nameMatherial = nameMatherial;
        this.issued = issued;
        this.received = received;
    }

    public Material(String nameMatherial, Integer issued, Integer received, Long idTask) {
        this(nameMatherial, issued, received);
        this.idTask = idTask;
    }

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }

    public String getNameMatherial() {
        return nameMatherial;
    }

    public void setNameMatherial(String nameMatherial) {
        this.nameMatherial = nameMatherial;
    }

    public Integer getIssued() {
        return issued;
    }

    public void setIssued(Integer issued) {
        this.issued = issued;
    }

    public Integer getReceived() {
        return received;
    }

    public void setReceived(Integer received) {
        this.received = received;
    }
    
    
}
