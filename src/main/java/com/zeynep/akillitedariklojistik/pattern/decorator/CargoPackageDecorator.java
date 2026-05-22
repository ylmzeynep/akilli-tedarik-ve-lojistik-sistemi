package com.zeynep.akillitedariklojistik.pattern.decorator;

public abstract class CargoPackageDecorator implements CargoPackage {

    protected CargoPackage cargoPackage;

    public CargoPackageDecorator(CargoPackage cargoPackage) {
        this.cargoPackage = cargoPackage;
    }
}