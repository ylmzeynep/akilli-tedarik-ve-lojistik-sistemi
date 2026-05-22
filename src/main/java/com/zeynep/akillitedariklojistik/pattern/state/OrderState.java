package com.zeynep.akillitedariklojistik.pattern.state;

import com.zeynep.akillitedariklojistik.model.order.Order;

public interface OrderState {

    void approve(Order order);

    void prepare(Order order);

    void ship(Order order);

    void deliver(Order order);

    void returnOrder(Order order);

    String getStateName();
}