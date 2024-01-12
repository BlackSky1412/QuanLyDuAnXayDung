package hutech.trancongmanh.quanlyduanxaydung.controller;

import hutech.trancongmanh.quanlyduanxaydung.entity.BacKhachHang;
import hutech.trancongmanh.quanlyduanxaydung.entity.NhaThau;
import hutech.trancongmanh.quanlyduanxaydung.service.NhaThauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/nhathau")
public class NhaThauController {

    @Autowired
    private NhaThauService nhathauService;

    @GetMapping
    public String viewAll(Model model) {
        List<NhaThau> listNhaThau = nhathauService.getAllNhaThau();
        model.addAttribute("listNhaThau", listNhaThau);
        return "nhathau/index";
    }

    @GetMapping("/new")
    public String showCreateNhaThauPage(Model model) {
        // You can add any model attributes needed for the form
        model.addAttribute("nhathau", new NhaThau());

        return "nhathau/create";
    }

    @PostMapping("/new")
    public String createNhaThau(@ModelAttribute NhaThau nhathau,
                                RedirectAttributes redirectAttributes) {

        nhathauService.createNhaThau(nhathau);
        // Thông báo thành công
        redirectAttributes.addFlashAttribute("successMessage", "Nhà thầu đã được thêm thành công.");
        return "redirect:/api/nhathau";
    }

    @GetMapping("/edit/{id}")
    public String editNhaThau(@PathVariable("id") Long id, Model model) {
        NhaThau nhaThau = nhathauService.getNhaThauById(id);
        model.addAttribute("nhaThau", nhaThau);
        return "nhathau/edit";
    }

    @PostMapping("/edit")
    public String updateNhaThau(@ModelAttribute NhaThau nhaThau,
                                RedirectAttributes redirectAttributes) {

        nhathauService.updateNhaThau(nhaThau);

        redirectAttributes.addFlashAttribute("successMessage", "Nhà thầu đã được cập nhật thành công.");
        return "redirect:/api/nhathau";
    }
}


