package com.crud.service;

import java.util.List;

import javax.transaction.Transactional;

import com.crud.model.JurusanModel;
import com.crud.repository.JurusanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class JurusanService {
    
    @Autowired
    JurusanRepository jurusanRepository;

    public List<JurusanModel> bacaJurusan (){
        return this.jurusanRepository.findAll();
    }

    public void saveJurusan(JurusanModel jurusanModel) {
        this.jurusanRepository.save(jurusanModel);
    }

    public void updateJurusan(JurusanModel jurusanModel) {
        this.jurusanRepository.save(jurusanModel);
    }

    public JurusanModel cariPrimary(String kodeJurusan){
        return this.jurusanRepository.cariKdJu(kodeJurusan);
    }
}
