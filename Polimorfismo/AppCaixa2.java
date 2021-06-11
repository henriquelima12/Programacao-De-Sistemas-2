import static utils.ES.*;
import banco.ContaEspecial;

public class AppCaixa2 {
    private static ContaEspecial conta2 = new ContaEspecial("Bob", 250.00, 150.00);
    
    public static void main(String[] args) {
        print("## CAIXA ELETRÔNICA v1");
        boolean sair = false;
        while (!sair) {
            print("\n## MENU PRINCIPAL");
            print("(1) Consultar Saldo");
            print("(2) Depositar");
            print("(3) Sacar");
            print("(4) Consultar Limite");
            print("(5) Alterar Limite");
            print("(6) Mostrar informações da conta");
            print("(7) Sair");
            int opcao = inputInt("\n## Escolha uma opção do menu:");
            if (opcao == 1) {
                opcaoConsultar();
            } 
            else if (opcao == 2) {
                opcaoDepositar();
            } 
            else if (opcao == 3) {
                opcaoSacar();
            } 
            else if (opcao == 4) {
                opcaoConsultarLimite();
            }
            else if (opcao == 5) {
                opcaoAlterarLimite();
            }
            else if (opcao == 6) {
                opcaoMostrarInfo();
            }
            else if (opcao == 7) {
                sair = true;
            } 
            else {
                print("\n## OPÇÃO INVÁLIDA!");
            }
        }
        print("\n## Obrigado por usar nossos serviços!");
    }
    
    private static void opcaoConsultar() {
        print("\n## Saldo da conta: R$ " + conta2.consultar());        
    }
    
    private static void opcaoDepositar() {
        double v = inputDouble("\n## Valor para depósito:");
        conta2.depositar(v);
        print("\n## Depósito efetuado!");        
    }

    private static void opcaoSacar() {
        double v = inputDouble("\n## Valor para saque:");
        if (conta2.sacar(v)) {
            print("\n## Saque efetuado!");        
        }
        else {
            print("\n## Saldo insuficiente para efetuar o saque!");
        }
    }

    private static void opcaoConsultarLimite() {
        print("\n## Limite da conta: R$ " + conta2.consultarLimite());        
    }

    private static void opcaoAlterarLimite() {
        double v = inputDouble("\n## Valor para Limite: R$ ");
        conta2.alterarLimite(v); 
    }
        
    private static void opcaoMostrarInfo() {
        print("\n## Informações da conta:");
        print(conta2.toString());
    }
}