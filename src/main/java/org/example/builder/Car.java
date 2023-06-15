package org.example.builder;


import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Car {
    int id;
    String model;
    String code;

    public static CarBuilder builder(){
        return new CarBuilder();
    }
}
