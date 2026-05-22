package com.zeynep.akillitedariklojistik.model.order;

import com.zeynep.akillitedariklojistik.model.product.Product;
import com.zeynep.akillitedariklojistik.pattern.state.OrderState;

import com.zeynep.akillitedariklojistik.pattern.state.PendingState;

public class Order {

    private int id;

    private Product product;

    private int quantity;

    private OrderState state;

    public Order(int id, Product product, int quantity) {

        this.id = id;
        this.product = product;
        this.quantity = quantity;

        this.state = new PendingState();
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public OrderState getState() {
        return state;
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void approve() {

        state.approve(this);
    }

    public void prepare() {

        state.prepare(this);
    }

    public void ship() {

        state.ship(this);
    }

    public void deliver() {

        state.deliver(this);
    }

    public void returnOrder() {

        state.returnOrder(this);
    }
}