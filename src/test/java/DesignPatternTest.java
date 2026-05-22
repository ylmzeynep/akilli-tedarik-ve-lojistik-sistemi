package com.zeynep.akillitedariklojistik;

import com.zeynep.akillitedariklojistik.model.payment.Payment;
import com.zeynep.akillitedariklojistik.model.product.Product;
import com.zeynep.akillitedariklojistik.model.product.SimpleProduct;
import com.zeynep.akillitedariklojistik.pattern.adapter.ArasCargoAdapter;
import com.zeynep.akillitedariklojistik.pattern.decorator.BasicCargoPackage;
import com.zeynep.akillitedariklojistik.pattern.decorator.CargoPackage;
import com.zeynep.akillitedariklojistik.pattern.decorator.FragileItemDecorator;
import com.zeynep.akillitedariklojistik.pattern.decorator.InsuranceDecorator;
import com.zeynep.akillitedariklojistik.pattern.factory.PaymentFactory;
import com.zeynep.akillitedariklojistik.model.order.Order;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DesignPatternTest {

    @Test
    void factoryPatternTest() {

        PaymentFactory factory =
                new PaymentFactory();

        Payment payment =
                factory.createPayment("creditcard");

        assertNotNull(payment);
    }

    @Test
    void adapterPatternTest() {

        ArasCargoAdapter aras =
                new ArasCargoAdapter();

        String trackingCode =
                aras.createTrackingCode();

        assertNotNull(trackingCode);

        assertTrue(
                aras.calculatePrice(2, 100) > 0
        );
    }

    @Test
    void decoratorPatternTest() {

        CargoPackage cargoPackage =
                new BasicCargoPackage();

        cargoPackage =
                new InsuranceDecorator(cargoPackage);

        cargoPackage =
                new FragileItemDecorator(cargoPackage);

        assertEquals(
                225,
                cargoPackage.getCost()
        );
    }

    @Test
    void statePatternTest() {

        Product product =
                new SimpleProduct(
                        1,
                        "Gaming Mouse",
                        1500,
                        10
                );

        Order order =
                new Order(
                        1,
                        product,
                        2
                );

        order.approve();

        assertEquals(
                "Onaylandı",
                order.getState().getStateName()
        );
    }
}