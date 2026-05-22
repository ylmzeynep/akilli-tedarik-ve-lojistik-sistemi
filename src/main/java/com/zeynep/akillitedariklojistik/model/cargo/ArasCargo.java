package com.zeynep.akillitedariklojistik.model.cargo;

public class ArasCargo {

    public String generateArasCode() {

        return "ARAS-2026";
    }

    public double arasPriceCalculator(double kg, double km) {

        return (kg * 12) + (km * 0.5);
    }
}