package ru.edu.skynet_cd.domain;

public class User {   
    private Long id;   
    private String firstName;    
    private String secondName;    
    private String patronymic;    
    private Position position;    
    private String login;    
    private String pwd;

    public User() {
    }

    public User(String firstName, String secondName, String patronymic, Position position, String login, String pwd) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.position = position;
        this.login = login;
        this.pwd = pwd;
    }
    
    public String getFullName(){
        return new StringBuilder().append(firstName).append(" ")
                                        .append(secondName).append(" ")
                                        .append(patronymic).toString();    
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    
    
}
