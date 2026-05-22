package com.zeynep.akillitedariklojistik.pattern.adapter;

import com.zeynep.akillitedariklojistik.model.cargo.YurticiCargo;

public class YurticiCargoAdapter implements CargoService {

    private YurticiCargo yurticiCargo = new YurticiCargo();

    @Override
    public String createTrackingCode() {
        return yurticiCargo.createYurticiTrackingNo();
    }

    @Override
    public double calculatePrice(double weight, double distance) {
        return yurticiCargo.calculateYurticiPrice(weight, distance);
    }

    @Override
    public String getCargoCompanyName() {
        return "Yurtiçi Kargo";
    }
}