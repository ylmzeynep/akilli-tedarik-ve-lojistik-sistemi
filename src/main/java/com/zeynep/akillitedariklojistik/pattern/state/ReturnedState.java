package com.zeynep.akillitedariklojistik.pattern.state;

import com.zeynep.akillitedariklojistik.model.order.Order;

public class ReturnedState implements OrderState {

    @Override
    public void approve(Order order) {

        System.out.println("İade edilen sipariş tekrar onaylanamaz.");
    }

    @Override
    public void prepare(Order order) {

        System.out.println("İade edilen sipariş hazırlanamaz.");
    }

    @Override
    public void ship(Order order) {

        System.out.println("İade edilen sipariş kargolanamaz.");
    }

    @Override
    public void deliver(Order order) {

        System.out.println("İade edilen sipariş teslim edilemez.");
    }

    @Override
    public void returnOrder(Order order) {

        System.out.println("Sipariş zaten iade sürecinde.");
    }

    @Override
    public String getStateName() {

        return "İade Sürecinde";
    }
}