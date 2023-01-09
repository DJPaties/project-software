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

    public boolean addStock(Stock stock) {
        ArrayList<Stock> allStocks = fa.readStocks();

        if (allStocks.contains(stock)) {
            return false;
        }
        fa.writeToFile("Stocks.txt", stock.toString());
        return true;
    }

    public boolean removeStock(Stock stock) {
        ArrayList<Stock> allStocks = fa.readStocks();

        if (!allStocks.contains(stock)) {
            return false;
        }

        allStocks.remove(stock);
        fa.clearFile("Stocks.txt");

        for (int i = 0; i < allStocks.size(); i++) {
            fa.writeToFile("Stocks.txt", allStocks.get(i).toString());
        }

        return true;
    }

    public boolean modifyStockPrice(Stock stock, double newPrice) {
        ArrayList<Stock> allStocks = fa.readStocks();

        if (!allStocks.contains(stock)) {
            return false;
        }

        allStocks.remove(stock);
        fa.clearFile("Stocks.txt");

        for (int i = 0; i < allStocks.size(); i++) {
            if (allStocks.get(i).equals(stock)) {
                stock.setShareprice(newPrice);
                fa.writeToFile("Stocks.txt", stock.toString());

            } else {
                fa.writeToFile("Stocks.txt", allStocks.get(i).toString());

            }

        }

        return true;
    }

    public boolean modifyStockQuantity(Stock stock, int newQuantity) {

         ArrayList<Stock> allStocks = fa.readStocks();

        if (!allStocks.contains(stock)) {
            return false;
        }

        allStocks.remove(stock);
        fa.clearFile("Stocks.txt");

        for (int i = 0; i < allStocks.size(); i++) {
            if (allStocks.get(i).equals(stock)) {
                stock.setShareprice(newQuantity);
                fa.writeToFile("Stocks.txt", stock.toString());

            } else {
                fa.writeToFile("Stocks.txt", allStocks.get(i).toString());

            }

        }

        return true;
    }
}
