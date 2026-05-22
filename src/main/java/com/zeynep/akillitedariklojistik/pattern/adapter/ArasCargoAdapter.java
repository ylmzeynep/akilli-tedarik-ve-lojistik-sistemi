package com.zeynep.akillitedariklojistik.pattern.adapter;

import com.zeynep.akillitedariklojistik.model.cargo.ArasCargo;

public class ArasCargoAdapter implements CargoService {

    private ArasCargo arasCargo = new ArasCargo();

    @Override
    public String createTrackingCode() {
        return arasCargo.generateArasCode();
    }

    @Override
    public double calculatePrice(double weight, double distance) {
        return arasCargo.arasPriceCalculator(weight, distance);
    }

    @Override
    public String getCargoCompanyName() {
        return "Aras Kargo";
    }
}