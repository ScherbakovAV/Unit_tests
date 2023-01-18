package Calc;
import static org.assertj.core.api.Assertions.*;
public class CalculatorTest {
    public static void main(String[] args) {
        assertThat(Calculator.calculatingDiscount(200, 50)).isEqualTo(100);
        assertThat(Calculator.calculatingDiscount(200, 0)).isEqualTo(200);
        assertThat(Calculator.calculatingDiscount(200.5, 50)).isEqualTo(100.25);
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-200, -50));
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-200, 50));
        assertThatThrownBy(() -> Calculator.calculatingDiscount(200, -50));
        assertThatThrownBy(() -> Calculator.calculatingDiscount(0, 50));
        assertThatThrownBy(() -> Calculator.calculatingDiscount(200, 200));
        System.out.println("All tests passed");
    }
}
