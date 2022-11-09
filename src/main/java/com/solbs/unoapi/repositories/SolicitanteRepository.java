package com.solbs.unoapi.repositories;

import com.solbs.unoapi.entities.Solicitante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SolicitanteRepository extends JpaRepository<Solicitante, String> {
    boolean existsByCnpj(String cnpj);
}
