package flavydudu.sos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import flavydudu.sos.models.Ocorrencia;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Long>{

    @Query("SELECT o FROM Ocorrencia o WHERE setor = :setor")
    public List<Ocorrencia> findBySetor(@Param("setor") String setor);

    @Query("SELECT o FROM Ocorrencia o WHERE hash = :hash")
    public Ocorrencia findByHash(@Param("hash") String hash);
}