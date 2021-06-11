//Henrique Lima Araújo - 32091702
import java.nio.file.*;
import static javax.swing.JOptionPane.*;
import java.io.*;

public class Ex2 {
    public static void main(String[] args) {
        String s = showInputDialog("Consultar filme da linha: ");
      
        try{
            int linha = Integer.parseInt(s);
            String nome = Filmes.consultar(linha-1);
            showMessageDialog(null, nome);   
        }catch(IOException e){
            showMessageDialog(null, "Erro ao acessar os filmes");
        }catch(NumberFormatException e2){
            showMessageDialog(null, "Por favor, entre um número!");
        }catch(ArrayIndexOutOfBoundsException e3){
            showMessageDialog(null, "Valor Inválido!");    
        }
        
        showMessageDialog(null, "Fim");
    }
    
}

class Filmes{
    public static String consultar(int indice) throws IOException{
        Path arquivo = Paths.get("filmes.txt");
        String[] nomesFilmes = Files.readAllLines(arquivo).toArray(new String[0]);
        return nomesFilmes[indice];
    }
}
