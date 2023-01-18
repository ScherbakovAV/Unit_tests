public class Calculator {
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        // purchaseAmount - сумма покупки
        // discountAmount - размер скидки
        if (purchaseAmount < 0 && discountAmount < 0) throw new ArithmeticException("Сумма покупки и сумма скидки не могут быть отрицательными");
        if (purchaseAmount < 0) throw new ArithmeticException("Сумма покупки не может быть отрицательной");
        if (discountAmount < 0) throw new ArithmeticException("Сумма скидки не может быть отрицательной");
        if (purchaseAmount == 0) throw new ArithmeticException("Сумма покупки не может быть равна нулю");
        if (discountAmount >= 100) throw new ArithmeticException("Сумма скидки не может быть больше 100%");
        else return purchaseAmount * (100 - discountAmount) / 100; // Метод должен возвращать сумму покупки со скидкой
    }
}
