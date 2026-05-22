package com.zeynep.akillitedariklojistik.pattern.decorator;

public class FragileItemDecorator extends CargoPackageDecorator {

    public FragileItemDecorator(CargoPackage cargoPackage) {
        super(cargoPackage);
    }

    @Override
    public String getDescription() {
        return cargoPackage.getDescription() + " + Kırılacak Eşya Koruması";
    }

    @Override
    public double getCost() {
        return cargoPackage.getCost() + 75;
    }
}