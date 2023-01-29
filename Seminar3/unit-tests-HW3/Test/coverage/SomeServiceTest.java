// 1. Разбить большой метод под номером 3 и проверить покрытие(должно быть 100%)
package coverage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class SomeServiceTest {
    private SomeService someService;
    @BeforeEach
    void setUp() {
        someService = new SomeService();
    }

    // 3.3
    @Test
    void DiscountCalcNormalPriceNormalDiscountTest() {
        assertThat(someService.calculatingDiscount(2000.0, 50))
                .isEqualTo(1000);
    }
    @Test
    void DiscountCalcNormalPriceAllDiscountTest() {
        assertThat(someService.calculatingDiscount(2000.0, 100))
                .isEqualTo(0);
    }
    @Test
    void DiscountCalcNormalPriceZeroDiscountTest() {
        assertThat(someService.calculatingDiscount(2000.0, 0))
                .isEqualTo(2000);
    }
    @Test
    void DiscountCalcOver100DiscountTest() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, 110))
                .isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }
    @Test
    void DiscountCalcNegativeDiscountTest() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(2000.0, -10))
                .isInstanceOf(ArithmeticException.class).hasMessage("Скидка должна быть в диапазоне от 0 до 100%");
    }
    @Test
    void DiscountCalcNegativePriceTest() {
        assertThatThrownBy(() ->
                someService.calculatingDiscount(-100, 10))
                .isInstanceOf(ArithmeticException.class).hasMessage("Сумма покупки не может быть отрицательной");
    }

}