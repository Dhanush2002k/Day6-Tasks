import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
        "5, 3, 8",
        "10, -2, 8",
        "-4, -6, -10",
        "0, 0, 0"
    })
    void testAddition(int a, int b, int expected) {
        assertEquals(expected, calculator.add(a, b), "Addition test failed");
    }

    @ParameterizedTest
    @CsvSource({
        "5, 3, 2",
        "10, -2, 12",
        "-4, -6, 2",
        "0, 0, 0"
    })
    void testSubtraction(int a, int b, int expected) {
        assertEquals(expected, calculator.subtract(a, b), "Subtraction test failed");
    }

    @ParameterizedTest
    @CsvSource({
        "5, 3, 15",
        "10, -2, -20",
        "-4, -6, 24",
        "0, 5, 0"
    })
    void testMultiplication(int a, int b, int expected) {
        assertEquals(expected, calculator.multiply(a, b), "Multiplication test failed");
    }

    @ParameterizedTest
    @CsvSource({
        "10, 2, 5.0",
        "9, 3, 3.0",
        "-6, -2, 3.0",
        "-10, 5, -2.0"
    })
    void testDivision(int a, int b, double expected) {
        assertEquals(expected, calculator.divide(a, b), 0.0001, "Division test failed");
    }

    @ParameterizedTest
    @CsvSource({
        "10, 0",
        "-5, 0"
    })
    void testDivisionByZero(int a, int b) {
        assertThrows(ArithmeticException.class, () -> calculator.divide(a, b), "Expected ArithmeticException");
    }
}
