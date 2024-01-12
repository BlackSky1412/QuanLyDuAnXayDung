package hutech.trancongmanh.quanlyduanxaydung.controller;


import hutech.trancongmanh.quanlyduanxaydung.entity.ChucVu;
import hutech.trancongmanh.quanlyduanxaydung.entity.NhaCungCapVatTu;
import hutech.trancongmanh.quanlyduanxaydung.entity.NhaThau;
import hutech.trancongmanh.quanlyduanxaydung.entity.NhanVien;
import hutech.trancongmanh.quanlyduanxaydung.service.ChucVuService;
import hutech.trancongmanh.quanlyduanxaydung.service.NhaCungCapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


@Controller
@RequestMapping("/api/nhacungcap")
public class NhaCungCapController {
    @Autowired
    private NhaCungCapService nhaCungCapService;

    @GetMapping
    public String viewAll(Model model) {
        List<NhaCungCapVatTu> listnhacungcap = nhaCungCapService.getAllNhaCungCapVatTu();
        model.addAttribute("listnhacungcap", listnhacungcap);
        return "nhacungcapvattu/TrangChuNhaCungCap";
    }



    @GetMapping("/new")
    public String showCreateNhaCungCapPage(Model model) {
        // You can add any model attributes needed for the form
        model.addAttribute("nhacungcap", new NhaCungCapVatTu());

        return "nhacungcapvattu/TrangThemNhaCungCap";
    }

    @PostMapping("/new")
    public String createNhaCungCap(@ModelAttribute NhaCungCapVatTu nhacungcapvattu,
                                 RedirectAttributes redirectAttributes) {

        nhaCungCapService.createNhaCungCapVatTu(nhacungcapvattu);
        // Thông báo thành công
        redirectAttributes.addFlashAttribute("successMessage", "Nhà cung cấp vật tư đã được thêm thành công.");
        return "redirect:/api/nhacungcap";
    }

    @GetMapping("/edit/{id}")
    public String editNhaCungCap(@PathVariable("id") Long id, Model model) {
        NhaCungCapVatTu nhacungcap = nhaCungCapService.getNhaCungCapVatTuById(id);
        model.addAttribute("nhacungcap", nhacungcap);
        return "nhacungcapvattu/TrangSuaNhaCungCap";
    }

    @PostMapping("/edit")
    public String updateNhaCungCap(@ModelAttribute NhaCungCapVatTu nhacungcap,
                                RedirectAttributes redirectAttributes) {

        nhaCungCapService.updateNhaCungCapVatTu(nhacungcap);

        redirectAttributes.addFlashAttribute("successMessage", "Nhà cung cấp vật tư đã được cập nhật thành công.");
        return "redirect:/api/nhacungcap";
    }
}

