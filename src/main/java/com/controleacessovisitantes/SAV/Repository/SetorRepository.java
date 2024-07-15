package com.controleacessovisitantes.SAV.Repository;

import com.controleacessovisitantes.SAV.Model.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {
    @Query("SELECT a FROM Setor a WHERE " +
            "(:nome IS NULL OR a.nome LIKE %:nome%) AND " +
            "(:sigla IS NULL OR a.sigla LIKE %:sigla%)")
    List<Setor> buscarSetores(String nome, String sigla);
}
