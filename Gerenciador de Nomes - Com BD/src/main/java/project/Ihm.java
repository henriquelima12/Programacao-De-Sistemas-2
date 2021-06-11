package project;
import java.util.*;
import static java.lang.System.out;


public class Ihm {
    private GerenciadorNomes gerenciador;
    private Scanner entrada = new Scanner(System.in);
    
    public Ihm(GerenciadorNomes g){
        gerenciador = g;
    }
    
    public void dialogar(){
        boolean sair = false;
        while(!sair){
            out.println("MENU PRINCIPAL");
            out.println("(1)Listar Nomes");
            out.println("(2)Adicionar Nomes");
            out.println("(3)Sair");
            out.println("Escolha uma opcao:");
            int op = entrada.nextInt();
            switch(op){
              case 1: try{listar(); break;}catch(Exception e){System.out.println("Erro");}
              case 2: try{adicionar(); break;}catch(Exception e){System.out.println("Erro");}
              case 3: sair = true; break;
              default: out.println("Opção invalida");
            }
        }           
    }
    
    public void listar() throws Exception{
        List<String> nomes = gerenciador.obterNomes();
        out.println("Lista dos nomes");
        for(String nome: nomes){
            out.println(nome);
        }
    }
    
    public void adicionar() throws Exception{
        out.print("Digite o novo nome: ");
        String novoNome = entrada.next();
        gerenciador.adicionarNome(novoNome);
    }
    
}

