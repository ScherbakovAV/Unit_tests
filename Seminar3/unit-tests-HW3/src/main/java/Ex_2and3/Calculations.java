package Ex_2and3;

public class Calculations {
// 2. Метод проверяет, является ли целое число, записанное в переменную n, чётным (true) либо нечётным (false)
    public static boolean evenOddNumber(int n) {
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // 3. Нужно написать метод, который проверяет, попадает ли переданное число в интервал (25;100):
    //    возвращает true,если попадает, и false, если нет.
    public static boolean numberInInterval(int n) {
        if (n > 25 && n < 100) return true;
        return false;
    }
}
