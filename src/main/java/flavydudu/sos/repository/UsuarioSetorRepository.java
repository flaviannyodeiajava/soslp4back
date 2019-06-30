package flavydudu.sos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import flavydudu.sos.models.UsuarioSetor;

@Repository
public interface UsuarioSetorRepository extends JpaRepository<UsuarioSetor, Long>{

    @Query("SELECT u FROM UsuarioSetor u WHERE setor = :setor")
    public UsuarioSetor findBySetor(@Param("setor") String setor);
}