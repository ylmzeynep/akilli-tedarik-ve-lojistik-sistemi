package com.zeynep.akillitedariklojistik.pattern.state;

import com.zeynep.akillitedariklojistik.model.order.Order;

public class DeliveredState implements OrderState {

    @Override
    public void approve(Order order) {

        System.out.println("Sipariş zaten tamamlandı.");
    }

    @Override
    public void prepare(Order order) {

        System.out.println("Sipariş teslim edildi.");
    }

    @Override
    public void ship(Order order) {

        System.out.println("Sipariş teslim edildi.");
    }

    @Override
    public void deliver(Order order) {

        System.out.println("Sipariş zaten teslim edildi.");
    }

    @Override
    public void returnOrder(Order order) {

        System.out.println("İade süreci başlatıldı.");

        order.setState(new ReturnedState());
    }

    @Override
    public String getStateName() {

        return "Teslim Edildi";
    }
}