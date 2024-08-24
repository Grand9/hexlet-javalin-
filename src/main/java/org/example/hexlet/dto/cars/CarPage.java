package org.example.hexlet.dto.cars;

import org.example.hexlet.model.Car;

public class CarPage {
    private Car car;

    public CarPage(Car car) {
        this.car = car;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
