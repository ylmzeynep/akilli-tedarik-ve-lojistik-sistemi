package com.zeynep.akillitedariklojistik.pattern.state;

import com.zeynep.akillitedariklojistik.model.order.Order;

public class PreparingState implements OrderState {

    @Override
    public void approve(Order order) {

        System.out.println("Sipariş zaten onaylandı.");
    }

    @Override
    public void prepare(Order order) {

        System.out.println("Sipariş zaten hazırlanıyor.");
    }

    @Override
    public void ship(Order order) {

        System.out.println("Sipariş kargoya verildi.");

        order.setState(new ShippedState());
    }

    @Override
    public void deliver(Order order) {

        System.out.println("Sipariş henüz kargoda değil!");
    }

    @Override
    public void returnOrder(Order order) {

        System.out.println("Teslim edilmeyen sipariş iade edilemez!");
    }

    @Override
    public String getStateName() {

        return "Hazırlanıyor";
    }
}