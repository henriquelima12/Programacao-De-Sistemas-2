import static utils.ES.*;
import banco.ContaEspecial;

public class AppBanco2 {
    private static ContaEspecial[] contas = 
        { new ContaEspecial("João", 800.00, 200.00),
          new ContaEspecial("Maria", 700.00, 150.00),
          new ContaEspecial("Alfredo", 500.00, 250.00) };
    
    public static void main(String[] args) {
        print("## BANCO v1");
        boolean sair = false;
        while (!sair) {
            print("\n## MENU PRINCIPAL");
            print("(1) Mostrar informações das contas");
            print("(2) Depositar em todas");
            print("(3) Sacar em todas");
            print("(4) Aumentar limite em todas");
            print("(5) Sair");
            int opcao = inputInt("\n## Escolha uma opção do menu:");
            if (opcao == 1) {
                opcaoMostrarInfo();
            } 
            else if (opcao == 2) {
                opcaoDepositar();
            } 
            else if (opcao == 3) {
                opcaoSacar();
            } 
            else if (opcao == 4) {
                opcaoAlterarLimite();
            } 
            else if (opcao == 5) {
                sair = true;
            }
            else {
                print("\n## OPÇÃO INVÁLIDA!");
            }
        }
        print("\n## Obrigado por usar nossos serviços!");
    }

    private static void opcaoMostrarInfo() {
        print("\n## Informações das contas:");
        for (int i=0; i<contas.length; i++) {
            print(contas[i].toString());
        }
    }
    
    private static void opcaoDepositar() {
        double v = inputDouble("\n## Valor para depósito:");
        for (int i=0; i<contas.length; i++) {
            contas[i].depositar(v);
            print("\n## Depósito efetuado na conta de " 
                + contas[i].getNomeCorrentista() + "!");        
        }
    }

    private static void opcaoSacar() {
        double v = inputDouble("\n## Valor para saque:");
        for (int i=0; i<contas.length; i++) {
            if (contas[i].sacar(v)) {
                print("\n## Saque efetuado na conta de "
                    + contas[i].getNomeCorrentista() + "!");        
            }
            else {
                print("\n## Saldo insuficiente para efetuar o saque na conta de "
                    + contas[i].getNomeCorrentista() + "!");
            }
        }
    }

    private static void opcaoAlterarLimite() {
      double v = inputDouble("\n## Valor a ser adicionado ao limite de todos :");
      for (int i=0; i<contas.length; i++) {
        contas[i].alterarLimite(v + contas[i].consultarLimite());
      }
    }       
}