package com.daliciojunior.javatdd.junit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup() {
        this.calculator = new Calculator();
    }

    @AfterEach
    public void teardown() {
        this.calculator = null;
    }

    @Test
    @DisplayName("""
            GIVEN: int a = 10, int b = 20;
            WHEN: adding a and b together;
            THEN: return 30;
            """)
    public void testCalculatorAdd() {
        // Arrange
        double expected = 30;
        // Act
        double actual = calculator.add(10, 20);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("""
            GIVEN: int a = 10, int b = 20;
            WHEN: subtracting them together;
            THEN: return -10;
            """)
    public void testCalculatorSub() {
        // Arrange
        double expected = -10;
        // Act
        double actual = calculator.sub(10, 20);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("""
            GIVEN: int a = 10, int b = 20;
            WHEN: multiplying them together;
            THEN: return 200;
            """)
    public void testCalculatorMul() {
        // Arrange
        double expected = 200;
        // Act
        double actual = calculator.mul(10, 20);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("""
            GIVEN: int a = 10, int b = 20;
            WHEN: dividing them together;
            THEN: return 0.5;
            """)
    public void testCalculatorDiv() {
        // Arrange
        double expected = 0.5;
        // Act
        double actual = calculator.div(10, 20);
        // Assert
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("""
            GIVEN: int a = 10, int b = 0;
            WHEN: dividing them together;
            THEN: throw IllegalArgumentException;
            """)
    public void testCalculatorDivByZero() {
        // Arrange
        IllegalArgumentException exception = new IllegalArgumentException("CAN'T DIVIDE BY ZERO");
        // Act & Asset
        assertThrows(exception.getClass(), () -> calculator.div(10, 0));
    }
    
}