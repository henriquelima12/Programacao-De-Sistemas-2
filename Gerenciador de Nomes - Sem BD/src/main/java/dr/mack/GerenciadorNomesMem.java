package dr.mack;
import java.util.*;

public class GerenciadorNomesMem implements GerenciadorNomes{
    private List<String> nomes = new ArrayList<String>();
    
   
    public List<String> obterNomes(){
        return nomes;
    }
    
    public void adicionarNome(String nome){
        nomes.add(nome);
    }
}
