package Ex_2and3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculationsTest {
    // 2. Нужно покрыть тестами метод evenOddNumber() на 100%
    @Test
    void evenPositiveNumberTest() {
        assertTrue(Calculations.evenOddNumber(8));
    }
    @Test
    void oddPositiveNumberTest() {
        assertFalse(Calculations.evenOddNumber(7));
    }
    @Test
    void evenNegativeNumberTest() {
        assertTrue(Calculations.evenOddNumber(-8));
    }
    @Test
    void oddNegativeNumberTest() {
        assertFalse(Calculations.evenOddNumber(-7));
    }
    @Test
    void ZeroNumberTest() { // 0 является и чётным, и нечётным, исхожу из того, как написан метод
        assertTrue(Calculations.evenOddNumber(0));
    }

    // 3. Нужно покрыть тестами метод numberInInterval() на 100%
    @Test
    void numberIsInInterval() {
        assertTrue(Calculations.numberInInterval(26));
    }
    @Test
    void numberBelowInterval() { // круглые скобки в интервале (25;100) указывают, что граничные значения не входят в него, верно?
        assertFalse(Calculations.numberInInterval(25));
    }
    @Test
    void numberOverInterval() {
        assertFalse(Calculations.numberInInterval(120));
    }
}