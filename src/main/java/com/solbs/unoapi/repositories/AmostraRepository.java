package com.solbs.unoapi.repositories;

import com.solbs.unoapi.entities.Amostra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmostraRepository extends JpaRepository<Amostra, Long> {

    @Query(value = "SELECT * FROM TB_AMOSTRA WHERE STATUS_AMOSTRA = 0", nativeQuery = true)
    List<Amostra> findAmostrasAnaliseFinalizada();

    @Query(value = "SELECT * from TB_AMOSTRA WHERE STATUS_AMOSTRA = 1 ", nativeQuery = true)
    List<Amostra> findAmostraEmAnalise();

    @Query(value = "SELECT * FROM TB_AMOSTRA WHERE STATUS_AMOSTRA = 2", nativeQuery = true)
    List<Amostra> findAmostraAguardandoAnalise();

    @Query(value = "SELECT * FROM TB_AMOSTRA WHERE STATUS_AMOSTRA = 3", nativeQuery = true)
    List<Amostra> findAmostraEmFalta();
}
