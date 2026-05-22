package com.zeynep.akillitedariklojistik.model.payment;

public class BankTransferPayment implements Payment {

    @Override
    public void pay(double amount) {

        System.out.println(
                amount +
                        " TL havale ile ödendi."
        );
    }

    @Override
    public String getPaymentType() {

        return "Havale";
    }
}