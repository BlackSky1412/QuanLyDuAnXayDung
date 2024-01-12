package hutech.trancongmanh.quanlyduanxaydung.controller;

import hutech.trancongmanh.quanlyduanxaydung.entity.*;
import hutech.trancongmanh.quanlyduanxaydung.service.ChucVuService;
import hutech.trancongmanh.quanlyduanxaydung.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/nhanvien")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @Autowired
    private ChucVuService chucvuService;

    @GetMapping
    public String viewAll(Model model) {
        List<NhanVien> listNhanVien = nhanVienService.getAllNhanVien();
        model.addAttribute("listNhanVien", listNhanVien);
        return "nhanvien/TrangChuNhanVien";
    }

    @GetMapping("/new")
    public String showCreateNhanVienPage(Model model) {
        // You can add any model attributes needed for the form
        model.addAttribute("nhanvien", new NhanVien());
        List<ChucVu> chucvulist = chucvuService.getAllChucVu();

        // Add the list to the model
        model.addAttribute("chucvulist", chucvulist);

        return "nhanvien/TrangThemNhanVien";
    }

    @PostMapping("/new")
    public String createNhanVien(@ModelAttribute NhanVien nhanVien,
                                 RedirectAttributes redirectAttributes) {

        nhanVienService.createNhanVien(nhanVien);
        // Thông báo thành công
        redirectAttributes.addFlashAttribute("successMessage", "Nhân viên đã được thêm thành công.");
        return "redirect:/api/nhanvien";
    }

    @GetMapping("/edit/{id}")
    public String editNhanVien(@PathVariable("id") Long id, Model model) {
        NhanVien nhanVien = nhanVienService.getNhanVienById(id);
        model.addAttribute("nhanVien", nhanVien);
        List<ChucVu> chucvulist = chucvuService.getAllChucVu();
        model.addAttribute("chucvulist", chucvulist);
        return "nhanvien/TrangSuaNhanVien";
    }

    @PostMapping("/edit")
    public String updateNhanVien(@ModelAttribute NhanVien nhanVien,
                                 @RequestParam("chucvu") Long chucVuId, // Make sure 'chucvu' parameter is provided
                                 RedirectAttributes redirectAttributes) {

        nhanVien.setChucvu(chucvuService.getChucVuById(chucVuId));
        nhanVienService.updateNhanVien(nhanVien);

        redirectAttributes.addFlashAttribute("successMessage", "Nhân viên đã được cập nhật thành công.");
        return "redirect:/api/nhanvien";
    }

}

