package campo.projeto.domain.leituraSensor;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeituraSensorRepository 
            extends JpaRepository<LeituraSensor, Long>{
 
//     // Select * from leitura where id = id
//     public LeituraSensor findById(int id);

//    // Select * from leitura where irigacaoLigada= ligada
//     public List<LeituraSensor> findByIrrigacaoLigada(boolean ligada);

//     //select * from leitura where umidade > valor
//     public List<LeituraSensor> findByUmidadeGreaterThan(double valor);

//     public List<LeituraSensor> findByUmidadeLessThan(double valor);

    public  List<LeituraSensor> findByDataHoraBetween(LocalDateTime inicio, LocalDateTime fim);


    public LeituraSensor findTopByOrderByDataHoraDesc();

    public List<LeituraSensor> findAll();
}
