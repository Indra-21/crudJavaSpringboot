package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
// // import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TableMahasiswa")
public class MahasiswaModel {
    
    @Id
    @Column(name="KD_MHS")
    private String kd_mhs;
    @Column(name="NM_MHS")
    private String nm_mhs;
    @Column(name="JK")
    private String jk;
    @Column(name="ALAMAT")
    private String alamat;
    @Column(name="STATUS")
    private String status;
    @Column(name="KODE_JURUSAN")
    private String kodeJurusan;

    @ManyToOne
    @JoinColumn(name="KODE_JURUSAN", nullable = true, insertable = false, updatable = false )
    private JurusanModel jurusanModel;

    

    public String getKodeJurusan() {
        return kodeJurusan;
    }
    public void setKodeJurusan(String kodeJurusan) {
        this.kodeJurusan = kodeJurusan;
    }
    public JurusanModel getJurusanModel() {
        return jurusanModel;
    }
    public void setJurusanModel(JurusanModel jurusanModel) {
        this.jurusanModel = jurusanModel;
    }
    public String getKd_mhs() {
        return kd_mhs;
    }
    public void setKd_mhs(String kd_mhs) {
        this.kd_mhs = kd_mhs;
    }
    public String getNm_mhs() {
        return nm_mhs;
    }
    public void setNm_mhs(String nm_mhs) {
        this.nm_mhs = nm_mhs;
    }
    public String getJk() {
        return jk;
    }
    public void setJk(String jk) {
        this.jk = jk;
    }
    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    
    
}
