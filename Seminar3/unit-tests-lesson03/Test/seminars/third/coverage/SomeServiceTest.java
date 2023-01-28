package seminars.third.coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SomeServiceTest {
    private SomeService someService;
    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }
    // 3.1
    @Test
    void fizzTest() {
        assertThat(someService.fizzBuzz(9).equals("Fizz"));
    }
    @Test
    void BuzzTest() {
        assertThat(someService.fizzBuzz(10).equals("Buzz"));
    }
    @Test
    void fizzBuzzTest() {
        assertThat(someService.fizzBuzz(15).equals("FizzBuzz"));
    }
    @Test
    void fizzBuzzTestNegative() {
        assertThat(someService.fizzBuzz(2).equals("2"));
    }

    // 3.2
    @Test
    void firstElement6Test() {
        assertTrue(someService.firstLast6(new int[]{6, 3, 5 ,8}));
    }
    @Test
    void lastElement6Test() {
        assertTrue(someService.firstLast6(new int[]{3, 3, 5 ,6}));
    }
    @Test
    void noElement6Test() {
        assertFalse(someService.firstLast6(new int[]{3, 3, 5 ,8}));
    }

    // 3.3
    @Test
    void DiscountTest() {
        assertThat(someService.calculatingDiscount(2000.0, 50))
                .isEqualTo(1000); // обычная скидка
        assertThat(someService.calculatingDiscount(2000.0, 100))
                .isEqualTo(0); // обычная скидка
        assertThat(someService.calculatingDiscount(2000.0, 0))
                .isEqualTo(2000); // обычная скидка
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 110))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки больше 100%

        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Скидка должна быть в диапазоне от 0 до 100%"); // процент скидки меньше 0
        assertThatThrownBy(() ->
                someService.calculatingDiscount(-100, 10))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");
    }

    //3.4
    @Test
    void luckySumAllNot13Test() {
        assertThat(someService.luckySum(1, 2, 3)).isEqualTo(6);
    }
    @Test
    void luckySumAEqual13Test() {
        assertThat(someService.luckySum(13, 2, 3)).isEqualTo(5);
    }
    @Test
    void luckySumBEqual13Test() {
        assertThat(someService.luckySum(1, 13, 3)).isEqualTo(4);
    }
    @Test
    void luckySumCEqual13Test() {
        assertThat(someService.luckySum(1, 2, 13)).isEqualTo(3);
    }
}