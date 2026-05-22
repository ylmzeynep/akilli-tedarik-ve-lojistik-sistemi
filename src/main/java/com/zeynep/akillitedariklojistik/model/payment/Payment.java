package com.zeynep.akillitedariklojistik.model.payment;

public interface Payment {

    void pay(double amount);

    String getPaymentType();
}