// Нужно написать в калькуляторе метод вычисления суммы покупки (метод принимает сумму, процент скидки и возвращает сумму
// со скидкой) и проверить его используя AssertJ (отрицательное числа, 0, дроби, проценты >=100%, обычные скидки).
// Все ошибки должны быть обработаны, при вводе недопустимых аргументов можно выбрасывать (throw new ArithmeticException("Суть ошибки");),
// но нужно проверить, что все ошибки проверяются в тестах. (Заготовки метода уже есть в классе Calc.Calculator - calculatingDiscount)
package Calc;
public class Calculator {
    public static double calculatingDiscount(double purchaseAmount, int discountAmount) {
        if (purchaseAmount < 0 && discountAmount < 0) throw new ArithmeticException("Сумма покупки и сумма скидки не могут быть отрицательными");
        if (purchaseAmount < 0) throw new ArithmeticException("Сумма покупки не может быть отрицательной");
        if (discountAmount < 0) throw new ArithmeticException("Сумма скидки не может быть отрицательной");
        if (purchaseAmount == 0) throw new ArithmeticException("Сумма покупки не может быть равна нулю");
        if (discountAmount >= 100) throw new ArithmeticException("Сумма скидки не может быть больше или равна 100%");
        else return purchaseAmount * (100 - discountAmount) / 100;
    }
}
