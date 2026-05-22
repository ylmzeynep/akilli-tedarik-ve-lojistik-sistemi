package com.zeynep.akillitedariklojistik.model.cargo;

public class GlobalExpressCargo {

    public String produceGlobalCode() {

        return "GLOBAL-999";
    }

    public double globalPrice(double kilo, double road) {

        return (kilo * 18) + (road * 1.2);
    }
}