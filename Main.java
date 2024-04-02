import account.Account;
import account.Login;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main extends Account {
    public static BigDecimal balance;

    public Main(BigDecimal balance, BigDecimal limit, BigDecimal deposit) {
        super(balance, limit, deposit);
        Main.balance = balance;
    }
    static Login login = new Login();

    @Override
    public BigDecimal purchase() {
        return purchase();
    }

    public static void main (String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem-vindo ao banco. Digite o número da sua conta.");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        String expirationDate = "15/10/2030";
        Date expirationDateParsed = new SimpleDateFormat("dd/MM/yyyy").parse(expirationDate);
        System.out.println("A sua conta é " + accountNumber + " e seu cartão expira em " + expirationDate + " . Seja bem-vindo/a. Qual o seu nome?");
        String name = sc.nextLine();
        System.out.println("Bem-vindo/a " + name + ". Qual será o valor do depósito inicial na conta " + accountNumber + " ?");
        BigDecimal deposit = sc.nextBigDecimal();
        sc.nextLine();
        Main main = new Main(deposit, BigDecimal.ZERO, deposit);
        System.out.println("Depósito no valor de " + deposit + ". Seu saldo é de " + balance + " . Qual será o valor da compra? Lembrando que as taxa de IoF é de 1.8%.");
        BigDecimal purchaseAmount = sc.nextBigDecimal();
        main.purchase(purchaseAmount);
        System.out.println("A compra foi no valor de " + purchaseAmount + " e seu saldo ficou no valor de " + balance + ". Por favor, digite a senha do cartão.");
        login.auth();
        sc.nextLine();
        System.out.println("Senha aprovada. Compra autorizada no valor de " + purchaseAmount + ".");
        System.out.println();
        System.out.println("Seu limite atual é de " + limit + ".");
        sc.close();
    }
    @Override
    public BigDecimal purchase(BigDecimal purchaseAmount) {
        BigDecimal fees = setFees(purchaseAmount);
        balance = balance.subtract(purchaseAmount).subtract(fees);
        return balance;
    }

    @Override
    public BigDecimal limit() {
        BigDecimal newLimit = BigDecimal.valueOf(5000).subtract(purchase());
        return newLimit;
    }

    @Override
    public BigDecimal limit(BigDecimal limit) {
        return limit;
    }

    @Override
    public BigDecimal getBalance() {
        return getBalance();
    }

    @Override
    public BigDecimal getLimit() {
        return getLimit();
    }

    @Override
    public void getAuth() {
        getAuth();
    }
}
