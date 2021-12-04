package com.crud.repository;

import com.crud.model.JurusanModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JurusanRepository extends JpaRepository <JurusanModel, String>{
  
    @Query("SELECT J FROM JurusanModel J WHERE kodeJurusan =?1")
    public JurusanModel cariKdJu (String kodeJurusan);
}
