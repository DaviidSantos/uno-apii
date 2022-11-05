package com.solbs.unoapi.repositories;

import com.solbs.unoapi.entities.Amostra;
import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmostraRepository extends JpaRepository<Amostra, Long> {

    /**
     * Seleciona todas as amostras com status EM_ANALISE
     * @return lista de amostras em análise
     */
    @Query(value = "SELECT * from TB_AMOSTRA WHERE STATUS_AMOSTRA = 1 ", nativeQuery = true)
    List<Amostra> findAmostraEmAnalise();

}
