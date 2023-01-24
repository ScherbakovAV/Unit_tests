import Ex1.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

class ShopTest {

    // Создаем набор продуктов для магазина:
    public static List<Product> getStoreItems() {
        List<Product> products = new ArrayList<>();

        // Три массива Названия, Цены, Кол-во
        String[] productNames = {"bacon", "beef", "ham", "salmon", "carrot", "potato", "onion", "apple", "melon", "rice", "eggs", "yogurt"};
        Double[] productPrice = {170.00d, 250.00d, 200.00d, 150.00d, 15.00d, 30.00d, 20.00d, 59.00d, 88.00d, 100.00d, 80.00d, 55.00d};
        Integer[] stock = {10, 10, 10, 10, 10, 10, 10, 70, 13, 30, 40, 60};

        // Последовательно наполняем список продуктами
        for (int i = 0; i < productNames.length; i++) {
            products.add(new Product(i + 1, productNames[i], productPrice[i], stock[i]));
        }
        return products;
    }

    private ByteArrayOutputStream output = new ByteArrayOutputStream();

    private Shop shop;
    private Cart cart;

    @BeforeEach
    void setup() {
        shop = new Shop(getStoreItems());
        cart = new Cart(shop);
    }

    /**
     * <b>Юнит-тест для проверки следующей ситуации:</b>
     * Пользователь вводит неверный номер продукта
     * <br><b>Ожидаемый результат:
     * <br></b> Исключение типа RuntimeException и сообщение "Не найден продукт с id: "
     */
    @DisplayName("Test for enter incorrect product ID")
    @RepeatedTest(10)
    @Timeout(value = 50, unit = TimeUnit.MILLISECONDS)
    void incorrectProductSelectionCausesException() {
        int id = 14;
        String expectedMessage = "Не найден продукт с id: " + id;
        // Act
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            cart.getProductByProductID(id);
        });
        String actualMessage = exception.getMessage();
        // Assert
        assertEquals(expectedMessage, actualMessage);
    }
}