package hutech.trancongmanh.quanlyduanxaydung.controller;

import hutech.trancongmanh.quanlyduanxaydung.entity.ChucVu;
import hutech.trancongmanh.quanlyduanxaydung.entity.NhanVien;
import hutech.trancongmanh.quanlyduanxaydung.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/chucvu")
public class ChucVuController {

    @Autowired
    private ChucVuService chucVuService;

    @GetMapping()
    public String listChucVu(Model model) {
        List<ChucVu> listChucVu = chucVuService.getAllChucVu();


        model.addAttribute("listChucVu", listChucVu);
        return "chucvu/TrangChuChucVu";
    }

    @GetMapping("/new")
    public String showChucVuForm(Model model) {
        // Add any necessary data to the model
        model.addAttribute("chucvu", new ChucVu());
        return "chucvu/TrangThemChucVu";
    }

    @PostMapping("/new")
    public String createChucVu(@ModelAttribute ChucVu chucvu) {
        chucVuService.saveChucVu(chucvu);
        // Redirect to the list page after creating a new ChucVu
        return "redirect:/api/chucvu";
    }

    @GetMapping("/edit/{id}")
    public String showEditChucVuForm(@PathVariable Long id, Model model) {
        ChucVu chucvu = chucVuService.getChucVuById(id);
        model.addAttribute("chucvu", chucvu);
        return "/chucvu/TrangSuaChucVu";
    }

    @PostMapping("/edit")
    public String updateChucVu( @ModelAttribute ChucVu chucvu, RedirectAttributes redirectAttributes) {

        chucVuService.updateChucVu(chucvu);
        // Redirect to the list page after updating ChucVu

        redirectAttributes.addFlashAttribute("successMessage", "Chức vụ đã được cập nhật thành công.");
        return "redirect:/api/chucvu";
    }

}
