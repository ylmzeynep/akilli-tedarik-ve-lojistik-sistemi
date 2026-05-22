package com.zeynep.akillitedariklojistik.pattern.state;

import com.zeynep.akillitedariklojistik.model.order.Order;

public class ShippedState implements OrderState {

    @Override
    public void approve(Order order) {

        System.out.println("Sipariş zaten onaylandı.");
    }

    @Override
    public void prepare(Order order) {

        System.out.println("Sipariş zaten hazırlandı.");
    }

    @Override
    public void ship(Order order) {

        System.out.println("Sipariş zaten kargoda.");
    }

    @Override
    public void deliver(Order order) {

        System.out.println("Sipariş teslim edildi.");

        order.setState(new DeliveredState());
    }

    @Override
    public void returnOrder(Order order) {

        System.out.println("Kargodaki sipariş için iade süreci başlatıldı.");

        order.setState(new ReturnedState());
    }

    @Override
    public String getStateName() {

        return "Kargoda";
    }
}