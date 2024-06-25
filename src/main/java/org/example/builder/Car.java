package org.example.builder;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Car {
    int id;
    String model;
    String code;

    public static CarBuilder builder(){
        return new CarBuilder();
    }
}
