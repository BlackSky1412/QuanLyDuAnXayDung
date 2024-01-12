package hutech.trancongmanh.quanlyduanxaydung.controller;

import hutech.trancongmanh.quanlyduanxaydung.entity.ChiTietVanDePhatSinh;
import hutech.trancongmanh.quanlyduanxaydung.entity.VanDePhatSinh;
import hutech.trancongmanh.quanlyduanxaydung.service.VanDePhatSinhService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/vandephatsinh")
public class VanDePhatSinhController {

    @Autowired
    private VanDePhatSinhService vanDePhatSinhService;

    @GetMapping
    public String viewAll(Model model) {
        List<VanDePhatSinh> listVanDePhatSinh = vanDePhatSinhService.getAllVanDePhatSinh();
        model.addAttribute("listVanDePhatSinh", listVanDePhatSinh);
        return "vandephatsinh/TrangChuVanDePhatSinh";
    }

//    @GetMapping("/DanhSachVanDeCanGiaiQuyet")
//    public String viewAllVanDeCanGiaiQuyet(Model model) {
//        // Retrieve a list of issues that need to be resolved (CachGiaiQuyet is null)
//        List<VanDePhatSinh> vanDeCanGiaiQuyetList = vanDePhatSinhService.getVanDeCanGiaiQuyetList();
//
//        model.addAttribute("vanDeCanGiaiQuyetList", vanDeCanGiaiQuyetList);
//
//        return "vandephatsinh/TrangGiaiQuyetVanDePhatSinh";
//    }
//
//    @GetMapping("giaiquyet")
//    public String giaiQuyetVanDe() {
//        return "vandephatsinh/TrangGiaiQuyetVanDePhatSinh";
//    }
}
