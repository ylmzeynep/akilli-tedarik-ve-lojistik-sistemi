package com.zeynep.akillitedariklojistik.model.notification;

import com.zeynep.akillitedariklojistik.model.product.Product;
import com.zeynep.akillitedariklojistik.pattern.observer.StockObserver;

public class PurchasingObserver implements StockObserver {

    @Override
    public void notify(Product product) {

        System.out.println(
                "SATIN ALMA BIRIMI UYARISI -> "
                        + product.getName()
                        + " stok seviyesi azaldi!"
        );
    }
}