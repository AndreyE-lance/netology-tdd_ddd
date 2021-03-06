package task1;

import java.math.BigDecimal;

public interface Calculable {
    BigDecimal calcMonthlyPay(int sumCredit, int creditTermMonth, int perCent);
    BigDecimal calcSumCredit(int sumCredit, int creditTermMonth, int perCent);
    BigDecimal calcOverPay(int sumCredit, int creditTermMonth, int perCent);

}
