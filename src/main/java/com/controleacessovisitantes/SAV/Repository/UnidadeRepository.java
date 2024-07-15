package main.java.com.controleacessovisitantes.SAV.Repository;

import com.controleacessovisitantes.SAV.Model.Unidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Long> {
    @Query("SELECT a FROM Unidade a WHERE " +
            "(:nome IS NULL OR a.nome LIKE %:nome%)")
    List<Unidade> buscarUnidades(String nome);
}
