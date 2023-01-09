/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import models.Stock;

/**
 *
 * @author youss
 */
public class StockController {

    private FileAccess fa;

        public StockController(){
            this.fa= new FileAccess();
        }
    public boolean addStock(Stock stock) {
        ArrayList<Stock> allStocks = fa.readStocks();
        for(int i =0;i<allStocks.size();i++){
            if (stock.getName().equals(allStocks.get(i).getName())) {
            return false;
            }
        }
        
        fa.writeToFile("Stocks.txt", stock.toString());
        return true;
    }

    public boolean removeStock(String stock) {
        ArrayList<Stock> allStocks = fa.readStocks();
        boolean notFound=true;
        for(int i =0;i<allStocks.size();i++){
            if (stock.equals(allStocks.get(i).getName())) {
                Stock s = allStocks.get(i);
                allStocks.remove(s);
                notFound=false;
                break;
            }
        }

        if(notFound){
            return false;
        }
        fa.clearFile("Stocks.txt");

        for (int i = 0; i < allStocks.size(); i++) {
            fa.writeToFile("Stocks.txt", allStocks.get(i).toString());
        }

        return true;
    }

    public boolean modifyStockPrice(String stock, double newPrice) {
        ArrayList<Stock> allStocks = fa.readStocks();

        boolean notFound=true;
        for(int i =0;i<allStocks.size();i++){
            if (stock.equals(allStocks.get(i).getName())) {
                notFound=false;
                Stock s = allStocks.get(i);
                s.setShareprice(newPrice);
                break;
            }
        }

        if(notFound){
            return false;
        }

        fa.clearFile("Stocks.txt");

        for (int i = 0; i < allStocks.size(); i++) {
            fa.writeToFile("Stocks.txt", allStocks.get(i).toString());
        }

        return true;
    }

    public boolean modifyStockQuantity(String stock, int newQuantity) {

         ArrayList<Stock> allStocks = fa.readStocks();

        boolean notFound=true;
        for(int i =0;i<allStocks.size();i++){
            if (stock.equals(allStocks.get(i).getName())) {
                notFound=false;
                Stock s = allStocks.get(i);
                s.setQuantity(newQuantity);
                break;
            }
        }

        if(notFound){
            return false;
        }

        fa.clearFile("Stocks.txt");

        for (int i = 0; i < allStocks.size(); i++) {
            fa.writeToFile("Stocks.txt", allStocks.get(i).toString());
        }

        return true;
    }
}
