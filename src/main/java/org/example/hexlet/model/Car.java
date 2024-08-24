package org.example.hexlet.model;

public class Car {
    private Long id;
    private String make;
    private String model;

    // Конструктор для создания Car без ID
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    // Геттеры и сеттеры
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
