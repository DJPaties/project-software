/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author dghai
 */
public class User {
    
    private String name;
    
    private int id;
    
    private String password;
    
    private static int totalUsers=0;

    public User(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
        totalUsers+=1;
    }

    public static int getTotalUsers() {
        return totalUsers;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "\t" + id + "\t" + password;
    }

}
