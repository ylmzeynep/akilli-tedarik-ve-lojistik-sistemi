package com.zeynep.akillitedariklojistik.pattern.adapter;

import com.zeynep.akillitedariklojistik.model.cargo.GlobalExpressCargo;

public class GlobalExpressCargoAdapter implements CargoService {

    private GlobalExpressCargo globalExpressCargo = new GlobalExpressCargo();

    @Override
    public String createTrackingCode() {
        return globalExpressCargo.produceGlobalCode();
    }

    @Override
    public double calculatePrice(double weight, double distance) {
        return globalExpressCargo.globalPrice(weight, distance);
    }

    @Override
    public String getCargoCompanyName() {
        return "Global Express";
    }
}