package ru.edu.skynet_cd.domain;
 
public class Position {
    private Long id;
    private String name;
    private String department;

    public Position() {
    }

    public Position(String name, String department) {
        this.name = name;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Position{ " + "name= " + name + ", "
                            + "department= " + department + " }";
    }
    
    
}
