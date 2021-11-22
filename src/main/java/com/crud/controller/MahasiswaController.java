package com.crud.controller;

// import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.crud.model.MahasiswaModel;
import com.crud.service.MahasiswaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MahasiswaController {

    @Autowired
    MahasiswaService mahasiswaService;
    // MahasiswaService mahasiswaService = new MahasiswaService();

    // route mahasiswa
    @RequestMapping("/mahasiswa")
    public String home(){
        String html = "/mahasiswa/home";
        return html;
    }
    // route mahasiswa add
    @RequestMapping("/mahasiswa/add")
    public String add() {
        String html = "/mahasiswa/add";
        return html;
        
    }

    // route acton setelah submit insert ke db
    @RequestMapping("/mahasiswa/action")
    public String create(HttpServletRequest request) {
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
        String kodeMahasiswa = request.getParameter("kd_mhs");

        MahasiswaModel mahasiswaModel = new MahasiswaModel();
        mahasiswaModel = this.mahasiswaService.cariKey(kodeMahasiswa);

        model.addAttribute("editData", mahasiswaModel);      
        return "/mahasiswa/edit";

    }
    // route untuk action setelah submit form edit
    @RequestMapping("/mahasiswa/update")
    public String update(HttpServletRequest request){
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

        this.mahasiswaService.update(mahasiswaModel);
        return "/mahasiswa/home";
    }

    @RequestMapping("/mahasiswa/remove")
    public String remove(HttpServletRequest request, Model model) {
        String kodeMahasiswa = request.getParameter("kd_mhs");

        MahasiswaModel mahasiswaModel = new MahasiswaModel();
        mahasiswaModel = this.mahasiswaService.cariKey(kodeMahasiswa);

        model.addAttribute("lemparHapus", mahasiswaModel);

        return "mahasiswa/remove";
    }

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

    
    
}

