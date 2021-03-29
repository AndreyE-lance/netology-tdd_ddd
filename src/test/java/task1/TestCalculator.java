/*Рассчет месячного платежа
  Рассчет общей суммы к возврату в банк
  Рассчет переплаты за весь период*/
package task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Random;

public class TestCalculator {
    Calculator calculator = new Calculator();
    int fullPrice;
    int creditTermMonth;
    double perCentMonth;
    Random rnd = new Random();

    @Test
    public void testCalcMonthlyPay() {
        fullPrice = 1_000_000 + rnd.nextInt(1_000_000);
        creditTermMonth = 3 + rnd.nextInt(36);
        perCentMonth = (((3.0 + rnd.nextInt(10))/12)/100);
        BigDecimal exp = new BigDecimal();
        BigDecimal ret = calculator.calcMonthlyPay(fullPrice,creditTermMonth,perCentMonth);
        Assertions.assertEquals(exp, ret);
    }

}
