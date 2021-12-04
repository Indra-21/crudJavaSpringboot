package com.crud.controller;

// import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.crud.model.JurusanModel;
import com.crud.model.MahasiswaModel;
import com.crud.service.JurusanService;
import com.crud.service.MahasiswaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MahasiswaController {

    @Autowired
    MahasiswaService mahasiswaService;

    @Autowired
    JurusanService jurusanService;

    // route mahasiswa
    @RequestMapping("/mahasiswa")
    public String home(){
        String html = "/mahasiswa/home";
        return html;
    }
    // route mahasiswa add
    @RequestMapping("/mahasiswa/add")
    public String add(Model model){
        this.readJurusan(model);
        String html = "/mahasiswa/add";
        return html;
        
    }

    // route action setelah submit insert ke db
    @RequestMapping("/mahasiswa/action")
    public String create(HttpServletRequest request) {
        // this.join(request);
        String kJurusan = request.getParameter("jurusan");
        String kodeMahasiswa = request.getParameter("kodeMahasiswa");
        String namaMahasiswa = request.getParameter("namaMahasiswa");
        String alamat = request.getParameter("alamat");
        String jenisKelamin = request.getParameter("jk");
        String status = request.getParameter("status");

        MahasiswaModel mahasiswaModel = new MahasiswaModel();
        
        mahasiswaModel.setKodeJurusan(kJurusan);
        mahasiswaModel.setKd_mhs(kodeMahasiswa);
        mahasiswaModel.setNm_mhs(namaMahasiswa);
        mahasiswaModel.setAlamat(alamat);
        mahasiswaModel.setJk(jenisKelamin);
        mahasiswaModel.setStatus(status);

        this.mahasiswaService.save(mahasiswaModel);
        String html = "/mahasiswa/home";
        return html;

    }
    // route list nampilin
    @RequestMapping("/mahasiswa/list")
    public String bacaData(Model model){
        List<MahasiswaModel> mahasiswaModelList ;
        mahasiswaModelList = this.mahasiswaService.bacaData();

        model.addAttribute("listData", mahasiswaModelList);
        return "/mahasiswa/list";
    }

    // route untuk edit data menerima lemparan dari ajax kd_mhs
    @RequestMapping("/mahasiswa/edit")
    public String edit(HttpServletRequest request, Model model){
        // this.editJurusan(request, model);
        String kodeMahasiswa = request.getParameter("kd_mhs");

        MahasiswaModel mahasiswaModel = new MahasiswaModel();
        mahasiswaModel = this.mahasiswaService.cariKey(kodeMahasiswa);
        // this.readJurusan(model);
        model.addAttribute("editData", mahasiswaModel);
        this.readJurusan(model);
        return "/mahasiswa/edit";

    }

    // @RequestMapping("/mahasiswa/editjurusan")
    // public void editJurusan(HttpServletRequest request, Model model) {
    //     String kodeJurusan = request.getParameter("nmJurusan");

    //     JurusanModel jurusanModel = new JurusanModel();
    //     jurusanModel = this.jurusanService.cariPrimary(kodeJurusan);

    //     model.addAttribute("editJurusan", jurusanModel);
    // }
    // route untuk action setelah submit form edit
    @RequestMapping("/mahasiswa/update")
    public String update(HttpServletRequest request){
        String kodeMahasiswa = request.getParameter("kodeMahasiswa");
        String namaMahasiswa = request.getParameter("namaMahasiswa");
        String alamat = request.getParameter("alamat");
        String jenisKelamin = request.getParameter("jk");
        String status = request.getParameter("status");
        String jurusan = request.getParameter("jurusan");

       
        
        MahasiswaModel mahasiswaModel = new MahasiswaModel();
        // JurusanModel jurusanModel = new JurusanModel();

        mahasiswaModel.setKd_mhs(kodeMahasiswa);
        mahasiswaModel.setNm_mhs(namaMahasiswa);
        mahasiswaModel.setAlamat(alamat);
        mahasiswaModel.setJk(jenisKelamin);
        mahasiswaModel.setStatus(status);
        mahasiswaModel.setKodeJurusan(jurusan);

        this.mahasiswaService.update(mahasiswaModel);
        // this.create(request);
        return "/mahasiswa/home";
    }
    // route untuk button hapus , ambil lemparan dari ajax kdmhs 
    @RequestMapping("/mahasiswa/remove")
    public String remove(HttpServletRequest request, Model model) {
        String kodeMahasiswa = request.getParameter("kd_mhs");

        MahasiswaModel mahasiswaModel = new MahasiswaModel();
        mahasiswaModel = this.mahasiswaService.cariKey(kodeMahasiswa);

        model.addAttribute("lemparHapus", mahasiswaModel);

        return "mahasiswa/remove";
    }
    // action hapus
    @RequestMapping("/mahasiswa/hapus")
    public String hapus(HttpServletRequest request){
        String kodeMahasiswa = request.getParameter("kodeMahasiswa");
        String namaMahasiswa = request.getParameter("namaMahasiswa");
        String alamat = request.getParameter("alamat");
        String jenisKelamin = request.getParameter("jk");
        String status = request.getParameter("status");

        MahasiswaModel mahasiswaModel = new MahasiswaModel();

        mahasiswaModel.setKd_mhs(kodeMahasiswa);
        mahasiswaModel.setNm_mhs(namaMahasiswa);
        mahasiswaModel.setAlamat(alamat);
        mahasiswaModel.setJk(jenisKelamin);
        mahasiswaModel.setStatus(status);

        this.mahasiswaService.delete(mahasiswaModel);
        return "/mahasiswa/home";
    }

    // @RequestMapping("/mahasiswa/jurusan")
    public void readJurusan(Model model) {
        List<JurusanModel> jurusanModelList;
        jurusanModelList = this.jurusanService.bacaJurusan();

        model.addAttribute("lemparBacaJurusan", jurusanModelList);
    }

    // @RequestMapping("/mahasiswa/addJurusan")    
    // public String insertJurusan(HttpServletRequest request){
    //     // String kdJurusan = request.getParameter()
    //     String namaJurusan = request.getParameter("jurusan");

    //     JurusanModel jurusanModel = new JurusanModel();

    //     jurusanModel.setKodeJurusan(namaJurusan);

    //     this.jurusanService.saveJurusan(jurusanModel);

    //     return "mahasiswa/home";
    // }

    // @RequestMapping("/mahasiswa/join")
    // public void join(HttpServletRequest request) {
    //     String kdJurusan = request.getParameter("kodeJurusan");
    //     String nmJurusan = request.getParameter("jurusan");

    //     JurusanModel jurusanModel = new JurusanModel();
    //     jurusanModel.setKodeJurusan(kdJurusan);
    //     jurusanModel.setNmJurusan(nmJurusan);

    //     this.jurusanService.saveJurusan(jurusanModel);
    // }

    
    
}

