package com.zeynep.akillitedariklojistik.pattern.decorator;

public class InsuranceDecorator extends CargoPackageDecorator {

    public InsuranceDecorator(CargoPackage cargoPackage) {
        super(cargoPackage);
    }

    @Override
    public String getDescription() {
        return cargoPackage.getDescription() + " + Sigortalı Gönderim";
    }

    @Override
    public double getCost() {
        return cargoPackage.getCost() + 50;
    }
}