package com.zeynep.akillitedariklojistik.model.product;

import java.util.ArrayList;
import java.util.List;

public class CompositeProduct extends Product {

    private List<Product> products;

    public CompositeProduct(int id, String name, double price, int stock) {

        super(id, name, price, stock);

        products = new ArrayList<>();
    }

    public void addProduct(Product product) {

        products.add(product);
    }

    @Override
    public void displayProductInfo() {

        System.out.println("Karmasik Urun");
        System.out.println("ID: " + id);
        System.out.println("Urun Adi: " + name);
        System.out.println("Fiyat: " + price);
        System.out.println("Stok: " + stock);

        System.out.println("Icindeki Parcalar:");

        for (Product product : products) {

            System.out.println("- " + product.getName());
        }
    }
}