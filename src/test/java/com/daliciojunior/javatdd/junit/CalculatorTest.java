package com.daliciojunior.javatdd.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @AfterEach
    public void teardown() {
        calculator = null;
    }

    @Test
    public void testCalculatorAdd() {
        // Arrange
        double a = 10;
        double b = 20;
        double expected = a + b;
        // Act
        double actual = calculator.add(a, b);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculatorSub() {
        // Arrange
        double a = 10;
        double b = 20;
        double expected = a - b;
        // Act
        double actual = calculator.sub(a, b);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculatorMul() {
        // Arrange
        double a = 10;
        double b = 20;
        double expected = a * b;
        // Act
        double actual = calculator.mul(a, b);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculatorDiv() {
        // Arrange
        double a = 10;
        double b = 20;
        double expected = a / b;
        // Act
        double actual = calculator.div(a, b);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void testCalculatorDivByZero() {
        // Arrange
        double a = 10;
        double b = 0;
        IllegalArgumentException expected = new IllegalArgumentException("CAN'T DIVIDE BY ZERO");
        // Act & Assert
        assertThrows(expected.getClass(), () -> calculator.div(a, b));
    }

}