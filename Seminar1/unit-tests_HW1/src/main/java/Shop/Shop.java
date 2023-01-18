package Shop;
import java.util.Collections;
import java.util.List;

public class Shop {
    private List<Product> products;

    // Геттеры, сеттеры:
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // Метод должен вернуть отсортированный по возрастанию по цене список продуктов
    public List<Product> getSortedListProducts(List<Product> lst) {
        //Collections.sort(lst);
        return lst;
    }

    // Метод должен вернуть самый дорогой продукт
    public Product getMostExpensiveProduct(List<Product> lst) {
        //return Collections.max(lst);
        return null;
    }
}