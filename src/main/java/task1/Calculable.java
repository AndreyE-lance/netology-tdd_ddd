package task1;

import java.math.BigDecimal;

public interface Calculable {
    BigDecimal calcMonthlyPay(int fullPrice, int creditTermMonth, double perCentMonth);
    BigDecimal calcFullPrice(int fullPrice, int creditTermMonth, double perCentMonth);
    BigDecimal calcOverPay(int fullPrice, int creditTermMonth, double perCentMonth);

}
