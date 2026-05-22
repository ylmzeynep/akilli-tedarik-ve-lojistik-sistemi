package com.zeynep.akillitedariklojistik.pattern.state;

import com.zeynep.akillitedariklojistik.model.order.Order;

public class ApprovedState implements OrderState {

    @Override
    public void approve(Order order) {

        System.out.println("Sipariş zaten onaylandı.");
    }

    @Override
    public void prepare(Order order) {

        System.out.println("Sipariş hazırlanmaya başladı.");

        order.setState(new PreparingState());
    }

    @Override
    public void ship(Order order) {

        System.out.println("Sipariş önce hazırlanmalı!");
    }

    @Override
    public void deliver(Order order) {

        System.out.println("Sipariş henüz kargoya verilmedi!");
    }

    @Override
    public void returnOrder(Order order) {

        System.out.println("Teslim edilmeyen sipariş iade edilemez!");
    }

    @Override
    public String getStateName() {

        return "Onaylandı";
    }
}