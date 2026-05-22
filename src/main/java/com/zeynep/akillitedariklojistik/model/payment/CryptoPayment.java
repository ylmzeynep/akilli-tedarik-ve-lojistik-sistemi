package com.zeynep.akillitedariklojistik.model.payment;

public class CryptoPayment implements Payment {

    @Override
    public void pay(double amount) {

        System.out.println(
                amount +
                        " TL kripto ile ödendi."
        );
    }

    @Override
    public String getPaymentType() {

        return "Kripto";
    }
}