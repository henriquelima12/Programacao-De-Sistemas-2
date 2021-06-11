package project;
import java.util.List;

public interface GerenciadorNomes {
    List<String> obterNomes() throws Exception;
    void adicionarNome(String nome) throws Exception;
}
