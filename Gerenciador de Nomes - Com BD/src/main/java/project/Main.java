package project;
import java.util.*;

public class Main {
  public static void main(String[] args) {
      
      Scanner entrada = new Scanner(System.in);
      System.out.println("Escolha o tipo de gerenciamento:");
      System.out.println("1 - Gerenciador de nomes na memoria:");
      System.out.println("2 - Gerenciador de nomes no Banco de Dados:");
      int op = entrada.nextInt();
      if(op == 1){       
          GerenciadorNomes gNomes = new GerenciadorNomesMem();
          Ihm ihm = new Ihm(gNomes);
          ihm.dialogar();
      }else if(op == 2){
          GerenciadorNomes gNomes = new GerenciadorNomesDB();
          Ihm ihm = new Ihm(gNomes);
          try{
              ihm.dialogar();
          }catch(Exception e){
              System.out.println("Erro");
          }
      }else{
          System.out.println("Opção Invalida");
      }
      
    
      
  }
}
