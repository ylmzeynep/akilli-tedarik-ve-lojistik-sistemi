package com.zeynep.akillitedariklojistik.model.cargo;

public class YurticiCargo {

    public String createYurticiTrackingNo() {

        return "YURTICI-145";
    }

    public double calculateYurticiPrice(double weight, double distance) {

        return (weight * 10) + (distance * 0.7);
    }
}