//Henrique Lima Araújo - 32091702
import static javax.swing.JOptionPane.*;

public class Exercicio1 {
    public static void main(String[] args){
    String msg;
    double[] notas = {8.5, 7.5, 9.5};
    String s = showInputDialog("Qual nota deseja consultar? 0, 1 ou 2?");
    int i = Integer.parseInt(s);

    try{
      double n = notas[i];
      msg = "Nota: " +n;
      showMessageDialog(null, msg);
    }catch(ArrayIndexOutOfBoundsException ex){
      showMessageDialog(null, "Nota Inválida");
    }
    showMessageDialog(null, "Fim");

  }   
}
