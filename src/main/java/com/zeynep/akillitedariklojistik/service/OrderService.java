package com.zeynep.akillitedariklojistik.service;

import com.zeynep.akillitedariklojistik.model.order.Order;
import com.zeynep.akillitedariklojistik.model.product.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private List<Order> orders = new ArrayList<>();

    public OrderService() {

    }

    public void createOrder(Product product, int quantity) {

        int newId = orders.size() + 1;

        Order order = new Order(newId, product, quantity);

        orders.add(order);

        System.out.println(
                "Yeni sipariş oluşturuldu -> "
                        + product.getName()
        );
    }

    public List<Order> getAllOrders() {

        return orders;
    }

    public void approveOrder(int orderId) {

        Order order = orders.get(orderId - 1);

        order.approve();
    }

    public void prepareOrder(int orderId) {

        Order order = orders.get(orderId - 1);

        order.prepare();
    }

    public void shipOrder(int orderId) {

        Order order = orders.get(orderId - 1);

        order.ship();
    }

    public void deliverOrder(int orderId) {

        Order order = orders.get(orderId - 1);

        order.deliver();
    }

    public void returnOrder(int orderId) {

        Order order = orders.get(orderId - 1);

        order.returnOrder();
    }
}