package account;

import java.math.BigDecimal;

public abstract class Account {
    public String name;
    public static int accountNumber;
    public String password; // vulgo cvc
    public BigDecimal deposit;
    public static String expirationDate;
    public BigDecimal balance;
    public static BigDecimal limit = BigDecimal.valueOf(5000);
    public static BigDecimal fees;

    public Account(BigDecimal balance, BigDecimal limit, BigDecimal deposit) {
        this.setBalance(balance);
        this.setLimit(limit);
        this.deposit(deposit);
    }

    private void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    private BigDecimal deposit(BigDecimal depositAmount) {
        balance = balance.add(depositAmount);
        return balance;
    }

    protected BigDecimal setLimit(BigDecimal limit) {
        return limit;
    }

    public BigDecimal purchase(BigDecimal purchaseAmount) {
        BigDecimal fees = setFees(purchaseAmount);
        balance = balance.subtract(purchaseAmount).subtract(fees);
        return balance;
    }

    protected BigDecimal setFees(BigDecimal purchase) {
        BigDecimal fees = purchase.multiply(BigDecimal.valueOf(0.018)); // Calculando 1.8% de IOF
        return fees;
    }

    public void getFees(BigDecimal fees) {
        Account.fees = fees;
    }

    public abstract BigDecimal purchase();

    public BigDecimal limit() {
        return null;
    }

    public abstract BigDecimal limit(BigDecimal limit);

    public abstract BigDecimal getBalance();

    public abstract BigDecimal getLimit();

    public abstract void getAuth();

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(String password) {
        this.password = password;
    }
}
