package org.example.hexlet.dto.cars;

import org.example.hexlet.model.Car;
import java.util.List;

public class CarsPage {
    private List<Car> cars;

    public CarsPage(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }
}
