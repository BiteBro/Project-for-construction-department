package ru.edu.skynet_cd.domain;

public class Material {
    private Long id;   
    private String nameMatherial;    
    private Integer issued;    
    private Integer received;

    public Material() {
    }

    public Material(String nameMatherial, Integer issued, Integer received) {
        this.nameMatherial = nameMatherial;
        this.issued = issued;
        this.received = received;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
