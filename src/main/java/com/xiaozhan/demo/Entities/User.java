package com.xiaozhan.demo.Entities;
import java.io.Serializable;

public class User implements Serializable {
    public Integer id;
    public String username;
    public String password;
    public boolean isbanned=false;

    public boolean getIsbanned() {
        return isbanned;
    }

    public void setIsbanned(boolean isbanned) {
        this.isbanned = isbanned;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
