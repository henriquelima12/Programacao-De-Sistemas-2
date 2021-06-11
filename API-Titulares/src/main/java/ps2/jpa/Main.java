package ps2.jpa;

import java.util.Optional;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.beans.factory.annotation.Autowired;

import ps2.jpa.entity.Titular;
import ps2.jpa.repository.TitularRepo;
import static ps2.utils.ES.*;

@SpringBootApplication
public class Main 
  implements CommandLineRunner {

    @Autowired
    private TitularRepo TitularRepo;
    
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Override
    public void run(String... args) {
        print("\n## GERENCIADOR DE TITULARES ##");
        
        this.criar();
        this.lerTodos();
        this.lerUm();
        
        print("\n## FIM DO PROGRAMA! ##");
    }
    
    private void criar() {
        long nro = inputLong("\n## Número do titular: ");
        String nome = inputString("\n## Nome do titular: ");
        String rg = inputString("\n## RG do titular: ");
        String cpf = inputString("\n## CPF do titular: ");
        Titular t = new Titular(nro, nome, rg, cpf);
        TitularRepo.save(t);
        print("\n## Titular cadastrado!");
    }
    
    private void lerTodos() {
        Iterable<Titular> titulares = TitularRepo.findAll();
        print("\n## Lista dos titulares: ");
        for(Titular t: titulares) {
            print(String.format("- Número: %d, Nome: %s, RG: %s, CPF: %s", t.getNroTitular(), t.getNome(), t.getRg(), t.getCpf()));
        }
    }
    
    private void lerUm() {
        long nro = inputLong("\n## Número do titular: ");
        Optional<Titular> opt = TitularRepo.findById(nro);
        if(opt.isPresent()) {
            Titular t = opt.get();
            print(String.format("- Número: %d, Nome: %s, RG: %s, CPF: %s", t.getNroTitular(), t.getNome(), t.getRg(), t.getCpf()));
        }
        
    }
}
