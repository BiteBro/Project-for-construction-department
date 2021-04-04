package ru.edu.skynet_cd.domain;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{   
    private Long idUser;   
    private String firstName;    
    private String secondName;    
    private String patronymic;    
    private Position position;    
    private String login;    
    private String pwd;

    public User() {
    }
    public User(String firstName, String secondName, String patronymic, String login){        
        this.firstName = firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;        
        this.login = login;       
    }

    public User(String firstName, String secondName, String patronymic, Position position, 
                    String login, String pwd) {
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
    
    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
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

    @Override
    public String toString() {
        return "User{ " + "idUser= " + idUser + ", firstName= " + 
                firstName + ", secondName= " + secondName + ", patronymic= " + 
                    patronymic + ", " + position.toString() + 
                        ", login= " + login + ", pwd= " + pwd + " }";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.firstName);
        hash = 83 * hash + Objects.hashCode(this.secondName);
        hash = 83 * hash + Objects.hashCode(this.patronymic);
        hash = 83 * hash + Objects.hashCode(this.position);
        hash = 83 * hash + Objects.hashCode(this.login);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.secondName, other.secondName)) {
            return false;
        }
        if (!Objects.equals(this.patronymic, other.patronymic)) {
            return false;
        }
        if (!Objects.equals(this.login, other.login)) {
            return false;
        }
        if (!Objects.equals(this.position, other.position)) {
            return false;
        }
        return true;
    }
}
