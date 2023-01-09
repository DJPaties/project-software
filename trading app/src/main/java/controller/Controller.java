/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import models.User;

/**
 *
 * @author youss
 */
public class Controller {

    private FileAccess fa;
    
    public Controller() {
        this.fa = new FileAccess();
    }

    public boolean addUser(User user) {
        ArrayList<User> allUsers = fa.readUsers();

        if (allUsers.contains(user)) {
            return false;
        }
        fa.writeToFile("Users.txt", user.toString());
        return true;
    }

    public boolean removeUser(User user) {
        ArrayList<User> allUsers = fa.readUsers();

        if (!allUsers.contains(user)) {
            return false;
        }

        allUsers.remove(user);
        fa.clearFile("Users.txt");

        for (int i = 0; i < allUsers.size(); i++) {
            fa.writeToFile("Users.txt", allUsers.get(i).toString());
        }
        return true;
    }

    public boolean modifyUserName(User user, String newName) {
       ArrayList<User> allUsers = fa.readUsers();
        if (!allUsers.contains(user)) {
            return false;
        }

        allUsers.remove(user);
        fa.clearFile("Users.txt");

        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).equals(user)) {
                user.setName(newName);
                fa.writeToFile("Users.txt", user.toString());

            } else {
                fa.writeToFile("Users.txt", allUsers.get(i).toString());

            }

        }

        return true;
    }

    public boolean modifyUserPassword(User user, String newPassword) {
        ArrayList<User> allUsers = fa.readUsers();

        if (!allUsers.contains(user)) {
            return false;
        }

        allUsers.remove(user);
        fa.clearFile("Stocks.txt");

        for (int i = 0; i < allUsers.size(); i++) {
            if (allUsers.get(i).equals(user)) {
                user.setPassword(newPassword);
                fa.writeToFile("Stocks.txt", user.toString());

            } else {
                fa.writeToFile("Stocks.txt", allUsers.get(i).toString());

            }

        }

        return true;
    }

}
