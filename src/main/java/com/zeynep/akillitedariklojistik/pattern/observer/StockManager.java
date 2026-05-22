package com.zeynep.akillitedariklojistik.pattern.observer;

import com.zeynep.akillitedariklojistik.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class StockManager {

    private List<StockObserver> observers = new ArrayList<>();

    public void addObserver(StockObserver observer) {

        observers.add(observer);
    }

    public void notifyObservers(Product product) {

        for (StockObserver observer : observers) {

            observer.notify(product);
        }
    }

    public void reduceProductStock(Product product, int amount) {

        product.reduceStock(amount);

        if (product.getStock() < 10) {

            notifyObservers(product);
        }
    }
}