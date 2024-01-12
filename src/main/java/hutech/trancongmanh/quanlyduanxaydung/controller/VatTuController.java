package hutech.trancongmanh.quanlyduanxaydung.controller;

import hutech.trancongmanh.quanlyduanxaydung.entity.NhaCungCapVatTu;
import hutech.trancongmanh.quanlyduanxaydung.entity.NhaThau;
import hutech.trancongmanh.quanlyduanxaydung.entity.VatTu;
import hutech.trancongmanh.quanlyduanxaydung.service.NhaCungCapService;
import hutech.trancongmanh.quanlyduanxaydung.service.VatTuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/vattu")
public class VatTuController {

    @Autowired
    private VatTuService vatTuService;

    @Autowired
    private NhaCungCapService nhaCungCapService;

    @GetMapping
    public String viewAll(Model model) {
        List<VatTu> listVatTu = vatTuService.getAllVatTu();
        model.addAttribute("listVatTu", listVatTu);

        List<NhaCungCapVatTu> listNhaCungCap = nhaCungCapService.getAllNhaCungCapVatTu();
        model.addAttribute("listNhaCungCap", listNhaCungCap);
        return "vattu/index";
    }

    @GetMapping("/new")
    public String showCreateVatTuPage(Model model) {
        // You can add any model attributes needed for the form
        model.addAttribute("vattu", new VatTu());

        return "vattu/create";
    }

    @PostMapping("/new")
    public String createVatTu(@ModelAttribute VatTu vattu,
                              RedirectAttributes redirectAttributes) {

        vatTuService.createVatTu(vattu);
        // Thông báo thành công
        redirectAttributes.addFlashAttribute("successMessage", "Vật tư đã được thêm thành công.");
        return "redirect:/api/vattu";
    }


    @GetMapping("/edit/{id}")
    public String editVatTu(@PathVariable("id") Long id, Model model) {
        VatTu vattu = vatTuService.getVatTuById(id);
        model.addAttribute("vattu", vattu);
        return "vattu/edit";
    }

    @PostMapping("/edit")
    public String updateVatTu(@ModelAttribute VatTu vattu,
                              RedirectAttributes redirectAttributes) {

        vatTuService.updateVatTu(vattu);

        redirectAttributes.addFlashAttribute("successMessage", "Vật tư đã được cập nhật thành công.");
        return "redirect:/api/vattu";
    }


}
