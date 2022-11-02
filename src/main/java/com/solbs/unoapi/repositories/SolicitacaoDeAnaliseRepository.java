package com.solbs.unoapi.repositories;

import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitacaoDeAnaliseRepository extends JpaRepository<SolicitacaoDeAnalise, Long> {
}
