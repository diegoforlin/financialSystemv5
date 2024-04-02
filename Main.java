import account.Login;
import account.Account
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    private BigDecimal balance;
    private BigDecimal limit;
    private static final BigDecimal IOF_RATE = BigDecimal.valueOf(0.018); // Taxa de IOF de 1.8%

    public Main(BigDecimal balance, BigDecimal limit) {
        this.balance = balance;
        this.limit = limit;
    }

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Bem-vindo ao banco. Digite o número da sua conta.");
        int accountNumber = sc.nextInt();
        sc.nextLine();
        String expirationDate = "15/10/2030";
        System.out.println("A sua conta é " + accountNumber + " e seu cartão expira em " + expirationDate + " . Seja bem-vindo/a. Qual o seu nome?");
        String name = sc.nextLine();
        System.out.println("Bem-vindo/a " + name + ". Qual será o valor do depósito inicial na conta " + accountNumber + " ?");
        BigDecimal deposit = sc.nextBigDecimal();
        sc.nextLine();
        BigDecimal originalLimit = BigDecimal.valueOf(5000);
        Main main = new Main(deposit, originalLimit);
        System.out.println("Depósito no valor de " + deposit + ". Seu saldo é de " + main.getBalance() + " . Qual será o valor da compra? Lembrando que as taxa de IoF é de 1.8%.");
        BigDecimal purchaseAmount = sc.nextBigDecimal();
        main.purchase(purchaseAmount);
        System.out.println("A compra foi no valor de " + purchaseAmount + " e seu saldo ficou no valor de " + main.getBalance() + ". Por favor, digite a senha do cartão.");
        Login login = new Login();
        login.auth();
        sc.nextLine();
        System.out.println("Senha aprovada. Compra autorizada no valor de " + purchaseAmount + ".");
        System.out.println();
        System.out.println("Seu limite atual é de " + main.getLimit() + ".");
        sc.close();
    }

    public BigDecimal purchase(BigDecimal purchaseAmount) {
        BigDecimal fees = calculateIOF(purchaseAmount);
        balance = balance.subtract(purchaseAmount).subtract(fees);
        limit = limit.subtract(purchaseAmount).subtract(fees);
        return balance;
    }

    private BigDecimal calculateIOF(BigDecimal purchaseAmount) {
        return purchaseAmount.multiply(0.018);
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal getLimit() {
        r	eturn limit;
    }
	
    public void getAuth() {
    }
}
