package com.solbs.unoapi.repositories;

import com.solbs.unoapi.entities.Amostra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AmostraRepository extends JpaRepository<Amostra, String> {

    @Query(value = "SELECT * FROM TB_AMOSTRA WHERE STATUS_AMOSTRA = 0", nativeQuery = true)
    List<Amostra> findAmostrasAnaliseFinalizada();

    @Query(value = "SELECT * from TB_AMOSTRA WHERE STATUS_AMOSTRA = 1 ", nativeQuery = true)
    List<Amostra> findAmostraEmAnalise();

    @Query(value = "SELECT * FROM TB_AMOSTRA WHERE STATUS_AMOSTRA = 2", nativeQuery = true)
    List<Amostra> findAmostraAguardandoAnalise();

    @Query(value = "SELECT * FROM TB_AMOSTRA WHERE STATUS_AMOSTRA = 3", nativeQuery = true)
    List<Amostra> findAmostraEmFalta();

    //

    @Query(value = "SELECT count(*) FROM TB_AMOSTRA WHERE STATUS_AMOSTRA = 0", nativeQuery = true)
    int quantidadeFinalizada();

    @Query(value = "SELECT count(*) from TB_AMOSTRA WHERE STATUS_AMOSTRA = 1 ", nativeQuery = true)
    int quantidadeEmAnalise();

    @Query(value = "SELECT count(*) FROM TB_AMOSTRA WHERE STATUS_AMOSTRA = 2", nativeQuery = true)
    int quantidadeAguardandoAnalise();


}
