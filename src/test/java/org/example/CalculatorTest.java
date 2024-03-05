package org.example;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test for the Calculator class")
class CalculatorTest {

    private static Calculator calc;

    @BeforeAll
    static void setup() {
        calc = new Calculator();
    }

    @Nested
    class CalculatorTestPositive {
        @Tag("Positive")
        @Test
        @DisplayName("Test with both arguments positive, expecting positive result")
        void testMultiply() {
            int expectedResult = 20;
            int actualResult = calc.multiply(4, 5);

            assertEquals(expectedResult, actualResult);
        }
    }


    @Timeout(1)
    @DisplayName("Test with one negative argument, expecting negative result")
    @Test
    void testMultiplyNegative() {
        int expectedResult = -20;
        int actualResult = calc.multiply(-4, 5);

//        assertAll(
//                () -> assertNotEquals(-20, actualResult),
//                () -> assertDoesNotThrow(() -> 0),
//                () -> assertEquals(expectedResult, actualResult, "Actual result should be -20"),
//                () -> assertEquals(0, actualResult)
//        );
//        assertNotEquals(-20, actualResult);
        assertDoesNotThrow(() -> calc.multiply(0,0));
        assertEquals(expectedResult, actualResult, "Actual result should be -20");
//        assertEquals(0, actualResult);
    }

    @Test
    @DisplayName("Not the actual Calculator class test, Jupiter experiment")
    public void assertionsTest() {
        String actualString = "something";
        String expectedString = actualString;
        String expectedString2 = "hello";
        assertLinesMatch(List.of("orange", "banana"), List.of("orange", "banana"));
        assertSame(expectedString, actualString);
        assertNotSame(expectedString2, actualString);
//        fail();
    }

    @Test
    public void testAddPositive() {
        int expectedResult = 20;
        int actualResult = calc.add(15, 5);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddNegative() {
        int expectedResult = -10;
        int actualResult = calc.add(-15, 5);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testAddBothNegativeArguments() {
        int expectedResult = -20;
        int actualResult = calc.add(-15, -5);

        assertThat(actualResult).isNegative();
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("Not the actual Calculator class test, AssertJ experiment")
    public void assertionsTestAssertJ() {
        assertThat(5 > 3).isTrue();
        assertThat(false).isFalse();

        String s = "hello";
        String s1 = s;
        String s2 = "something";
        assertThat(s).isEqualTo(s1);
        assertThat(s).isNotEqualTo(s2);
        assertThat(s).usingDefaultComparator().isEqualTo(s1);

        List<Integer> list = List.of(1, 3, 5, 7, 9);
        assertThat(list).isNotEmpty().contains(9).startsWith(1, 3, 5).doesNotContainNull()
                .doesNotContain(2).containsExactly(1, 3, 5, 7, 9)
                .containsExactlyInAnyOrder(1, 3, 7, 9, 5);

        assertThat('c').isNotEqualTo('a').inUnicode()
                .isGreaterThanOrEqualTo('B').isLowerCase();

        assertThat(Calculator.class).isNotFinal().isNotInterface();

        assertThat(new NullPointerException("this is just some exeption message")).hasMessageEndingWith("message")
                .hasMessageStartingWith("this");

        String expectedString = "hello";
        assertThat(s).as("%s should be equal to %s", s, expectedString).isEqualTo(expectedString);
    }
}









