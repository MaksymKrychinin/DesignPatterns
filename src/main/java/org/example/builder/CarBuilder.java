package org.example.builder;

public class CarBuilder {
    int id;
    String model;
    String code;

    public CarBuilder id(int id) {
        this.id = id;
        return this;
    }

    public CarBuilder model(String model) {
        this.model = model;
        return this;
    }

    public CarBuilder code(String code) {
        this.code = code;
        return this;
    }

    public Car build() {
        return new Car(this.id, this.model, this.code);
    }
}
