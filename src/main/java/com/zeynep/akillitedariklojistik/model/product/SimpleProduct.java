package com.zeynep.akillitedariklojistik.model.product;

public class SimpleProduct extends Product {

    public SimpleProduct(int id, String name, double price, int stock) {

        super(id, name, price, stock);
    }

    @Override
    public void displayProductInfo() {

        System.out.println("Basit Urun");
        System.out.println("ID: " + id);
        System.out.println("Urun Adi: " + name);
        System.out.println("Fiyat: " + price);
        System.out.println("Stok: " + stock);
    }
}