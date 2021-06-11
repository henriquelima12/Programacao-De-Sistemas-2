package ps2.jpa.repository;

import ps2.jpa.entity.Titular;
import org.springframework.data.repository.CrudRepository;

public interface TitularRepo extends CrudRepository<Titular, Long> {
    
}
