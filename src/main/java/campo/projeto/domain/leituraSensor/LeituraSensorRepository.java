package campo.projeto.domain.leituraSensor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeituraSensorRepository 
            extends JpaRepository<LeituraSensor, Long>{
 
}
