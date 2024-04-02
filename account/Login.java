package account;

import javax.swing.*;

public class Login { // código reaproveitado de uma plataforma de estudos, com alterações pessoais

    String pass;
    private static String password = "123456";
    private static final int chances = 3;
    private static int attempts = 0;

    public void auth() {
        String password = "123456";
        String pass = password;
        if (pass.equals(password)) {
            System.out.println("Senha correta.");
        } else {
            JOptionPane.showMessageDialog(null, "Senha inválida");
            attempts++;
            if (attempts >= chances) {
                JOptionPane.showMessageDialog(null, "Desculpe, " + chances + " tentativas inválidas, você foi bloqueado!");
                System.exit(0);
            }
        }
    }
}
