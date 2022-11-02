package com.solbs.unoapi.repositories;

import com.solbs.unoapi.entities.Ensaio;
import com.solbs.unoapi.entities.SolicitacaoDeAnalise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnsaioRepository extends JpaRepository<Ensaio, Long> {
}
