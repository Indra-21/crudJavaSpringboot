package com.crud.repository;

import com.crud.model.MahasiswaModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MahasiswaRepository extends JpaRepository<MahasiswaModel, String>{
// custom repository tambahkan anotasi qeuri sebagai fungsi nya

    @Query("SELECT P FROM MahasiswaModel P WHERE kd_mhs = ?1")
    MahasiswaModel cariKodeMhs(String kd_mhs);
    
 }
