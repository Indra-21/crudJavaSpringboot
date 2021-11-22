package com.crud.service;

import java.util.List;

// import com.crud.controller.MahasiswaController;
import com.crud.model.MahasiswaModel;
import com.crud.repository.MahasiswaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MahasiswaService {
  
    
    // @Autowired
    // MahasiswaController mahasiswaController;
    
    @Autowired
    MahasiswaRepository mahasiswaRepository;

    // save adalah fungsi dari repository dan di gunakan untuk insert ke database
    public void save(MahasiswaModel mahasiswaModel) {
        mahasiswaRepository.save(mahasiswaModel);
    }

    // untuk membaca semua data yang ada di database
    public List<MahasiswaModel> bacaData(){
        return this.mahasiswaRepository.findAll();
    }
    // mengambil atau mereturn primary key yag sebelum nya sudah di buat query nya di MahasiswaReposiroty
    public MahasiswaModel cariKey(String kd_mhs){
        return this.mahasiswaRepository.cariKodeMhs(kd_mhs);
    }
    // save adalah fungsi dari repository dan di gunakan untuk insert ke database
    public void update(MahasiswaModel mahasiswaModel) {
        mahasiswaRepository.save(mahasiswaModel);
    }

    public void delete(MahasiswaModel mahasiswaModel) {
        mahasiswaRepository.delete(mahasiswaModel);
    }



    // transaktional adalaha untuk memberi hak akses ke method
    // @Transactional(readOnly=true)
    // public void savePasien(MahasiswaModel pasienModel) {
    //     mahasiswaRepository.save(pasienModel);
    // }
    
    
}
