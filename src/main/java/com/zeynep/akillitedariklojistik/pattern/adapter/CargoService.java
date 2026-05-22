package com.zeynep.akillitedariklojistik.pattern.adapter;

public interface CargoService {

    String createTrackingCode();

    double calculatePrice(double weight, double distance);

    String getCargoCompanyName();
}