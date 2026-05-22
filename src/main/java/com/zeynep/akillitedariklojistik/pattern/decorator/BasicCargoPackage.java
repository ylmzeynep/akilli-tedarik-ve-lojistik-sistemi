package com.zeynep.akillitedariklojistik.pattern.decorator;

public class BasicCargoPackage implements CargoPackage {

    @Override
    public String getDescription() {
        return "Standart Kargo";
    }

    @Override
    public double getCost() {
        return 100;
    }
}