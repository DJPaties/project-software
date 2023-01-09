/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;
import models.Stock;
import models.User;

/**
 *
 * @author youss
 */
public class FileAccess {

    public void writeToFile(String fileName, String data) {
        try {
            FileWriter fw = new FileWriter(fileName, true);
            fw.write(data + "\n");
            fw.write("------------------------------\n");
            fw.close();
        } catch (Exception exception) {

        }
    }

    public void clearFile(String fileName) {
        try {
            FileWriter fw = new FileWriter(fileName, false);
            fw.write("");
            fw.close();
        } catch (Exception exception) {

        }
    }

    public ArrayList<User> readUsers() {
        ArrayList<User> users = new ArrayList();
        try {
            FileInputStream fs = new FileInputStream("Users.txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader bf = new BufferedReader(ir);

            String line = "";
            String[] data = null;
            int counter = 0;

            while (bf.ready()) {
                line = bf.readLine();
                if (counter % 2 == 0) {
                    data = line.split("\t");
                    User user = new User(data[0], Integer.parseInt(data[1]), data[2]);
                    System.out.println("Hakuna: "+user);
                    users.add(user);
                }
                counter++;
            }
        }catch (Exception exception){
            
        }
        return users;
    }
    
    public ArrayList<Stock> readStocks() {
        ArrayList<Stock> stocks = new ArrayList();
        try {
            FileInputStream fs = new FileInputStream("Stocks.txt");
            InputStreamReader ir = new InputStreamReader(fs);
            BufferedReader bf = new BufferedReader(ir);
            
            String line = "";
            String[] data = null;
            int counter = 0;
            
            while (bf.ready()) {
                    line = bf.readLine();
                if (counter % 2 == 0){
                    data = line.split("\t");
                    Stock stock = new Stock(data[0], Double.parseDouble(data[1]), Integer.parseInt(data[2]));
                    stocks.add(stock);
                }
                counter++;
            }
        } catch (Exception e) {
        }
        
        return stocks;
    }

}
