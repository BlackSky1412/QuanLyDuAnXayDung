package hutech.trancongmanh.quanlyduanxaydung.controller;


import hutech.trancongmanh.quanlyduanxaydung.entity.*;
import hutech.trancongmanh.quanlyduanxaydung.service.DangGiaoDichService;
import hutech.trancongmanh.quanlyduanxaydung.service.DuAnService;
import hutech.trancongmanh.quanlyduanxaydung.service.GiaoDichDuAnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/quanlygiaodichduan")
public class QuanLyGiaoDichDuAnController {
    @Autowired
    private GiaoDichDuAnService giaodichduanService;
    @Autowired
    private DuAnService duAnService;
    @Autowired
    private DangGiaoDichService dangGiaoDichService;

    @GetMapping
    public String viewAll(Model model) {
        List<QuanLyGiaoDichDuAn> listgiaodich = giaodichduanService.getAllGiaoDich();
        model.addAttribute("listgiaodich", listgiaodich);


        return "giaodichduan/TrangChuGiaoDichDuAn";
    }

    @GetMapping("/new")
    public String showCreateGiaoDichDuAnPage(Model model) {
        model.addAttribute("giaodichduan", new QuanLyGiaoDichDuAn());

        List<DuAn> listduan = duAnService.getAllDuAn();

        model.addAttribute("listduan", listduan);

        List<DangGiaoDich> listdang = dangGiaoDichService.getAllDangGiaoDich();

        model.addAttribute("listdang", listdang);

        return "giaodichduan/TrangThemGiaoDichDuAn";
    }

    @PostMapping("/new")
    public String createDuAn(@ModelAttribute QuanLyGiaoDichDuAn giaodichduan,
                             @RequestParam("duan") Long DuAnId,
                             @RequestParam("danggiaodich") Long DangGiaoDichId,
                             RedirectAttributes redirectAttributes) {

        DuAn duan = duAnService.getDuAnById(DuAnId);
        giaodichduan.setDuan(duan);

        DangGiaoDich danggiaodich = dangGiaoDichService.getDangGiaoDichById(DangGiaoDichId);
        giaodichduan.setDanggiaodich(danggiaodich);

        giaodichduanService.saveGiaoDichDuAn(giaodichduan);
        // Thông báo thành công
        redirectAttributes.addFlashAttribute("successMessage", "Giao dịch đã được thêm thành công.");
        return "redirect:/api/quanlygiaodichduan";
    }
}
