package com.zeynep.akillitedariklojistik.pattern.factory;

import com.zeynep.akillitedariklojistik.model.payment.BankTransferPayment;
import com.zeynep.akillitedariklojistik.model.payment.CreditCardPayment;
import com.zeynep.akillitedariklojistik.model.payment.CryptoPayment;
import com.zeynep.akillitedariklojistik.model.payment.Payment;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PaymentFactory {

    private final Map<String, Supplier<Payment>> paymentMap =
            new HashMap<>();

    public PaymentFactory() {

        paymentMap.put("creditcard", CreditCardPayment::new);
        paymentMap.put("banktransfer", BankTransferPayment::new);
        paymentMap.put("crypto", CryptoPayment::new);
    }

    public Payment createPayment(String paymentType) {

        Supplier<Payment> paymentSupplier =
                paymentMap.get(paymentType.toLowerCase());

        if (paymentSupplier == null) {
            throw new IllegalArgumentException("Geçersiz ödeme tipi: " + paymentType);
        }

        return paymentSupplier.get();
    }
}