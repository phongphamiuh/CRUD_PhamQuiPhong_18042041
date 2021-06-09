package com.example.emotion;

import java.io.Serializable;

public class Product implements Serializable {

    private String id;
    private String name;
    private String brand;

    public Product(String id, String name, String brand) {
        this.id = id;
        this.name = name;
        this.brand = brand;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
