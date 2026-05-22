package com.zeynep.akillitedariklojistik.pattern.state;

import com.zeynep.akillitedariklojistik.model.order.Order;

public class PendingState implements OrderState {

    @Override
    public void approve(Order order) {

        System.out.println("Sipariş onaylandı.");
        order.setState(new ApprovedState());
    }

    @Override
    public void prepare(Order order) {

        System.out.println("Sipariş henüz onaylanmadı.");
    }

    @Override
    public void ship(Order order) {

        System.out.println("Sipariş hazırlanmadı.");
    }

    @Override
    public void deliver(Order order) {

        System.out.println("Sipariş kargolanmadı.");
    }

    @Override
    public void returnOrder(Order order) {

        System.out.println("Teslim edilmeyen sipariş iade edilemez.");
    }

    @Override
    public String getStateName() {

        return "Beklemede";
    }
}