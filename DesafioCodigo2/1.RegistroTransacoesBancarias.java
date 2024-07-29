import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class RegistroTransacoesBancarias {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double saldo = scanner.nextDouble();
        int quantidadeTransacoes = scanner.nextInt();

        List<String> transacoes = new ArrayList<>();

        for (int i = 0; i < quantidadeTransacoes; i++) {
            
            char tipoTransacao = scanner.next().charAt(0);
            double valorTransacao = scanner.nextDouble();
            
            if (tipoTransacao == 'D' || tipoTransacao == 'd') {
                saldo += valorTransacao;
                transacoes.add(String.format("Deposito de %.1f", valorTransacao));
            } else if (tipoTransacao == 'S' || tipoTransacao == 's') {
                saldo -= valorTransacao;
                transacoes.add(String.format("Saque de %.1f", valorTransacao));
            } else {
                System.out.println("Opção inválida. Utilize D para depósito ou S para saque.");
                i--;
            }
        }
        
        System.out.println("Saldo: " + saldo);
        System.out.println("Transacoes: ");
        for (int i = 0; i < transacoes.size(); i++) {
          System.out.println((i+1) + ". " + transacoes.get(i));
        }
        
        //Fecha o scanner para evitar vazamentos de recursos
        scanner.close();
    }
}