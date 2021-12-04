package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="T_JURUSAN")
public class JurusanModel {
    @Id
    @Column(name="KODE_JURUSAN")
    private String kodeJurusan;
    @Column(name="NAMA_JURUSAN")
    private String nmJurusan;


    public String getKodeJurusan() {
        return kodeJurusan;
    }
    public void setKodeJurusan(String kodeJurusan) {
        this.kodeJurusan = kodeJurusan;
    }
    public String getNmJurusan() {
        return nmJurusan;
    }
    public void setNmJurusan(String nmJurusan) {
        this.nmJurusan = nmJurusan;
    }

    
}
