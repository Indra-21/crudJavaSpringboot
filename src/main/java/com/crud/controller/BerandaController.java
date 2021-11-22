package com.crud.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BerandaController {
    
    @RequestMapping("/beranda")
    public String beranda() {
        String html = "beranda";
        return html;
    }

    @RequestMapping("login/action")
    // HttpServerletRequest untuk meminta data 
    // terutama dari backend ke fronend

    // Model attribut semacam interface yang sudah ada di Spring boot
    // di gunakan untuk membuat suatu attribut di backend yang di akses
    // oleh frontend melalui object attribut
    // return ke halaman yang menerima kiriman dari model nya
    public String tujuan(HttpServletRequest request, Model model){

        String mintaUser = request.getParameter("username");

        model.addAttribute("userLempar", mintaUser);
        String home = "beranda";
        return home;
    }
    
}

