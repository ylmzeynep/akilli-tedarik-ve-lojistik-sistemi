package com.zeynep.akillitedariklojistik.model.notification;

import com.zeynep.akillitedariklojistik.model.product.Product;
import com.zeynep.akillitedariklojistik.pattern.observer.StockObserver;

public class WarehouseObserver implements StockObserver {

    @Override
    public void notify(Product product) {

        System.out.println(
                "DEPO SORUMLUSU UYARISI -> "
                        + product.getName()
                        + " stok seviyesi kritik!"
        );
    }
}