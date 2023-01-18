import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
// < ---------- Не забудьте добавить библиотеку libs/assertj-core-3.23.1.jar - add as Library...

public class CalculatorTest {
    @Test
    void evaluatesExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 6, '+')).isEqualTo(8);
    }
    @Test
    void subtractionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 2, '-')).isEqualTo(0);
    }
    @Test
    void multiplicationExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(2, 7, '*')).isEqualTo(14);
    }
    @Test
    void divisionExpression() {
        Calculator calculator = new Calculator();
        assertThat(calculator.calculation(100, 50, '/')).isEqualTo(2);
    }
    @Test
    void expectedIllegalStateExpression() {
        Calculator calculator = new Calculator();
        assertThatThrownBy(() -> Calculator.calculation(8, 4, '_')).isInstanceOf(IllegalStateException.class);
    }
    @Test
    void getOperandCompletesCorrectlyWithNumbers() {
        String testedValue = "9"; // Значение для тестов
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        InputStream inputStream = System.in; // Сохраняем ссылку на ввод с клавиатуры
        System.setIn(in); // Подменяем ввод
        Calculator.getOperand(); // Вызываем метод
        System.out.println(testedValue); // Для наглядности
        System.setIn(inputStream); // Подменяем обратно
    }
    @Test
    void getOperandCompletesCorrectlyWithNotNumbers() {
        String testedValue = "k";
        ByteArrayInputStream in = new ByteArrayInputStream(testedValue.getBytes());
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        InputStream inputStream = System.in;
        System.setIn(in);
        System.setOut(new PrintStream(out));
        assertThatThrownBy(() -> Calculator.getOperand()) .isInstanceOf(IllegalStateException.class).describedAs("Ошибка в вводимых данных");
        System.setIn(inputStream);
        System.setOut(null);}
}