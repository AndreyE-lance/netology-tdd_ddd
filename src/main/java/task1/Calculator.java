package task1;

import java.math.BigDecimal;

public class Calculator implements Calculable{
    @Override
    public BigDecimal calcMonthlyPay(int sumCredit, int creditTermMonth, int perCent) {

        return monthlyPay(sumCredit, creditTermMonth, perCent);
    }

    @Override
    public BigDecimal calcSumCredit(int sumCredit, int creditTermMonth, int perCent) {
        return monthlyPay(sumCredit, creditTermMonth, perCent).multiply(BigDecimal.valueOf(creditTermMonth));
    }

    @Override
    public BigDecimal calcOverPay(int sumCredit, int creditTermMonth, int perCent) {
        return monthlyPay(sumCredit, creditTermMonth, perCent).multiply(BigDecimal.valueOf(creditTermMonth)).subtract(BigDecimal.valueOf(sumCredit));
    }

    public BigDecimal monthlyPay(int sumCredit, int creditTermMonth, int perCent){
        double perCentMonth = ((perCent/12.00)/100.00);
        BigDecimal exp = BigDecimal.valueOf(sumCredit*((Math.pow((1+perCentMonth),creditTermMonth)*perCentMonth)/((Math.pow((1+perCentMonth),creditTermMonth)-1))));
        return exp;
    }
}
