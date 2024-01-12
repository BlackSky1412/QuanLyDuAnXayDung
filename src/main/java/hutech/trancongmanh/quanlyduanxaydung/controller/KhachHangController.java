package hutech.trancongmanh.quanlyduanxaydung.controller;

import hutech.trancongmanh.quanlyduanxaydung.entity.*;
import hutech.trancongmanh.quanlyduanxaydung.service.BacKhachHangService;
import hutech.trancongmanh.quanlyduanxaydung.service.KhachHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/khachhang")
public class KhachHangController {

    @Autowired
    private KhachHangService khachhangService;

    @Autowired
    private BacKhachHangService backhachhangService;

    @GetMapping
    public String viewAll(Model model) {
        List<KhachHang> listKhachhang = khachhangService.getAllKhachHang();
        model.addAttribute("listKhachhang", listKhachhang);
        return "khachhang/index";
    }

    @GetMapping("/new")
    public String showCreateDuAnPage(Model model) {
        // You can add any model attributes needed for the form
        // Assuming you have a method to retrieve the list of CachThucThanhToan objects
        model.addAttribute("khachhang", new KhachHang());
        List<BacKhachHang> bacKhachHangList = backhachhangService.getAllBacKhachHang();
        model.addAttribute("bacKhachHangList", bacKhachHangList);

        return "khachhang/create";
    }

    @PostMapping("/new")
    public String createDuAn(@ModelAttribute KhachHang khachhang,
                             @RequestParam("backhachhang") Long BacKhachHangId,
                             RedirectAttributes redirectAttributes) {

        BacKhachHang backhachhang = backhachhangService.getBacKhachHangById(BacKhachHangId);
        khachhang.setBackhachhang(backhachhang);

        khachhangService.createKhachHang(khachhang);
        // Thông báo thành công
        redirectAttributes.addFlashAttribute("successMessage", "Khách hàng đã được thêm thành công.");
        return "redirect:/api/khachhang";
    }

    @GetMapping("/edit/{id}")
    public String editKhachHang(@PathVariable("id") Long id, Model model) {
        KhachHang khachhang = khachhangService.getKhachHangById(id);
        model.addAttribute("khachhang", khachhang);

        // Assuming you have methods to retrieve lists for BacKhachHang
        List<BacKhachHang> bacKhachHangList = backhachhangService.getAllBacKhachHang();
        model.addAttribute("bacKhachHangList", bacKhachHangList);

        return "khachhang/edit"; // Update with the correct Thymeleaf template name
    }
    @PostMapping("/edit")
    public String updateKhachHang(@ModelAttribute KhachHang khachhang,
                                  @RequestParam("backhachhang") Long BacKhachHangId,
                                  RedirectAttributes redirectAttributes) {

        khachhang.setBackhachhang(backhachhangService.getBacKhachHangById(BacKhachHangId));

        khachhangService.updateKhachHang(khachhang);

        // Thông báo thành công
        redirectAttributes.addFlashAttribute("successMessage", "Khách hàng đã được cập nhật thành công.");
        return "redirect:/api/khachhang";
    }

}
