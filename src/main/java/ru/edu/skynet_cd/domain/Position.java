package ru.edu.skynet_cd.domain;
 
import java.io.Serializable;

public class Position implements Serializable{
    private Long id;
    private String name;

    public Position() {
    }

    public Position(String name) {
        this.name = name;       
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return "Position{ " + "name= " + name + " }";
    }
    
    
}
