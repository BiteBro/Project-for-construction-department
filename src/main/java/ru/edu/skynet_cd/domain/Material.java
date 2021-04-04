package ru.edu.skynet_cd.domain;

import java.io.Serializable;

public class Material implements Serializable{
    private Long id;
    private String nameMaterial;    
    private Integer issued;    
    private Integer received;
    private Long idTask;

    public Material() {
    }

    public Material(String nameMaterial, Integer issued, Integer received) {
        this.nameMaterial = nameMaterial;
        this.issued = issued;
        this.received = received;
    }

    public Material(String nameMaterial, Integer issued, Integer received, Long idTask) {
        this(nameMaterial, issued, received);
        this.idTask = idTask;
    }

    @Override
    public String toString() {
        return "Material{" + "id=" + id + ", nameMaterial=" + nameMaterial + 
                ", issued=" + issued + ", received=" + received + ", idTask=" + idTask + '}';
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameMaterial() {
        return nameMaterial;
    }

    public void setNameMaterial(String nameMaterial) {
        this.nameMaterial = nameMaterial;
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

    public Long getIdTask() {
        return idTask;
    }

    public void setIdTask(Long idTask) {
        this.idTask = idTask;
    }    
}
