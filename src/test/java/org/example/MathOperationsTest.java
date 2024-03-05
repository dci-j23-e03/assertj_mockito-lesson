package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
import org.mockito.verification.VerificationMode;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MathOperationsTest {

    private MathOperations mathOperations;
    private Calculator calculatorMock;
    private Main mainMock;

    @BeforeEach
    public void setup() {
        calculatorMock = mock(Calculator.class); // creating a mock of Calculator class, and not a real object
        mainMock = mock(Main.class);
        mathOperations = new MathOperations(calculatorMock);
//        when(calculatorMock.multiply(0, 0)).thenReturn(0);
    }

    @Test
    public void testMultiply() {
        when(calculatorMock.multiply(4, 5)).thenReturn(20); // defining a behaviour of mocked call
        int expected = 20;
        int actual = mathOperations.multiply(4, 5);

        assertThat(actual).isEqualTo(expected);
        verify(calculatorMock).multiply(4, 5);
        verify(calculatorMock, never()).add(4,5);
        verify(calculatorMock, only()).multiply(4, 5);
        verify(calculatorMock, times(1)).multiply(4, 5);
        verifyNoInteractions(mainMock);
    }

    @Test
    public void testAdd() {
        when(calculatorMock.add(4, 5)).thenReturn(9);

        int expected = 9;
        int actual = mathOperations.add(4, 5);

        assertThat(actual).isEqualTo(expected);
        verify(calculatorMock).add(4, 5);
        verifyNoMoreInteractions(calculatorMock);
        verifyNoInteractions(mainMock);
    }

    @Test
    public void testAddThenMultiply() {
        when(calculatorMock.add(3, 2)).thenReturn(5);
        when(calculatorMock.multiply(3, 2)).thenReturn(6);

        int expected = 11;
        int actual = mathOperations.addThenMultiply(3, 2);

        InOrder inOrder = inOrder(calculatorMock);

        assertThat(actual).isEqualTo(expected);
        inOrder.verify(calculatorMock).add(3,  2);
        inOrder.verify(calculatorMock).multiply(3, 2);
        ignoreStubs(calculatorMock);
    }
}