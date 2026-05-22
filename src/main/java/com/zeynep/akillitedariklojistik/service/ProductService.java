package com.zeynep.akillitedariklojistik.service;

import com.zeynep.akillitedariklojistik.model.notification.PurchasingObserver;
import com.zeynep.akillitedariklojistik.model.notification.WarehouseObserver;
import com.zeynep.akillitedariklojistik.model.product.CompositeProduct;
import com.zeynep.akillitedariklojistik.model.product.Product;
import com.zeynep.akillitedariklojistik.model.product.SimpleProduct;
import com.zeynep.akillitedariklojistik.pattern.observer.StockManager;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private StockManager stockManager = new StockManager();

    public ProductService() {

        stockManager.addObserver(new PurchasingObserver());
        stockManager.addObserver(new WarehouseObserver());

        SimpleProduct mouse =
                new SimpleProduct(1, "Gaming Mouse", 1500, 20);

        SimpleProduct keyboard =
                new SimpleProduct(2, "Mechanical Keyboard", 3000, 15);

        CompositeProduct pc =
                new CompositeProduct(3, "Gaming PC", 25000, 5);

        pc.addProduct(mouse);
        pc.addProduct(keyboard);

        stockManager.reduceProductStock(mouse, 15);
        stockManager.reduceProductStock(pc, 3);

        products.add(mouse);
        products.add(keyboard);
        products.add(pc);
    }

    public List<Product> getAllProducts() {

        return products;
    }

    public void addSimpleProduct(String name, double price, int stock) {

        int newId = products.size() + 1;

        SimpleProduct product =
                new SimpleProduct(newId, name, price, stock);

        products.add(product);
    }
}