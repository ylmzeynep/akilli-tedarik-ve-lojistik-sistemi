package com.zeynep.akillitedariklojistik.pattern.observer;

import com.zeynep.akillitedariklojistik.model.product.Product;

public interface StockObserver {

    void notify(Product product);
}