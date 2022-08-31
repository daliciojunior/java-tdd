package com.daliciojunior.javatdd.junit;

public class Calculator {

    public Calculator() {}

    public double add(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mul(double a, double b) {
        return a * b;
    }

    public double div(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("CAN'T DIVIDE BY ZERO");
        } else {
            return a / b;
        }
    }

}