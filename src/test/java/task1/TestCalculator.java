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
    int sumCredit;
    int creditTermMonth;
    int perCent;
    Random rnd = new Random();

    @Test
    public void testCalcMonthlyPay() {
        sumCredit = 1_000_000 + rnd.nextInt(1_000_000);
        creditTermMonth = 3 + rnd.nextInt(36);
        perCent = 10 + rnd.nextInt(10);
        BigDecimal expected = monthlyPay(sumCredit,creditTermMonth,perCent);
        BigDecimal ret = calculator.calcMonthlyPay(sumCredit,creditTermMonth,perCent);
        Assertions.assertEquals(expected, ret);
    }
    
    @Test
    public void testCalcsumCredit(){
        sumCredit = 1_000_000 + rnd.nextInt(1_000_000);
        creditTermMonth = 3 + rnd.nextInt(36);
        perCent = 10 + rnd.nextInt(10);
        BigDecimal expected = monthlyPay(sumCredit, creditTermMonth, perCent).multiply(BigDecimal.valueOf(creditTermMonth));
        BigDecimal ret = calculator.calcSumCredit(sumCredit,creditTermMonth,perCent);
        Assertions.assertEquals(expected, ret);
    }
    
    @Test
    public void testCalcOverPay(){
        sumCredit = 1_000_000 + rnd.nextInt(1_000_000);
        creditTermMonth = 3 + rnd.nextInt(36);
        perCent = 10 + rnd.nextInt(10);
        BigDecimal expected = monthlyPay(sumCredit, creditTermMonth, perCent).multiply(BigDecimal.valueOf(creditTermMonth)).subtract(BigDecimal.valueOf(sumCredit));
        BigDecimal ret = calculator.calcOverPay(sumCredit,creditTermMonth,perCent);
        Assertions.assertEquals(expected, ret);
    }

    public BigDecimal monthlyPay(int sumCredit, int creditTermMonth, int perCent){
        double perCentMonth = ((perCent/12.00)/100.00);
        BigDecimal exp = BigDecimal.valueOf(sumCredit*((Math.pow((1+perCentMonth),creditTermMonth)*perCentMonth)/((Math.pow((1+perCentMonth),creditTermMonth)-1))));
        return exp;
    }

}
