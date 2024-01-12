package hutech.trancongmanh.quanlyduanxaydung.controller.khachhangcontroller;

import hutech.trancongmanh.quanlyduanxaydung.entity.DangGiaoDich;
import hutech.trancongmanh.quanlyduanxaydung.entity.DuAn;
import hutech.trancongmanh.quanlyduanxaydung.entity.QuanLyGiaoDichDuAn;
import hutech.trancongmanh.quanlyduanxaydung.service.DangGiaoDichService;
import hutech.trancongmanh.quanlyduanxaydung.service.DuAnService;
import hutech.trancongmanh.quanlyduanxaydung.service.GiaoDichDuAnService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/khachhang")
public class DuAn_KhachHang {

    @Autowired
    private DuAnService duAnService;
    @Autowired
    private GiaoDichDuAnService giaoDichDuAnService;
    @Autowired
    private GiaoDichDuAnService giaodichduanService;

    @Autowired
    private DangGiaoDichService dangGiaoDichService;

    private long ID = 0;

    @GetMapping("duan/{KhachHangId}")
    public String viewAll(@PathVariable Long KhachHangId, Model model) {
        List<DuAn> listDuan = duAnService.getDuAnByKhachHangId(KhachHangId);
        model.addAttribute("duanList", listDuan);
        return "ViewKhachHang/TrangChu";
    }

    @GetMapping("giaodich/{KhachHangId}")
    public String viewAllGiaoDich(@PathVariable Long KhachHangId, Model model) {
        ID = KhachHangId;

        List<QuanLyGiaoDichDuAn> giaoDichDuAnList = giaoDichDuAnService.getGiaoDichByKhachHangId(KhachHangId);
        model.addAttribute("giaoDichDuAnList", giaoDichDuAnList);
        return "ViewKhachHang/TrangQuanLyGiaoDich";
    }

    @GetMapping("giaodich/new")
    public String showCreateGiaoDichDuAnPage(Model model) {
        model.addAttribute("giaodichduan", new QuanLyGiaoDichDuAn());

        List<DuAn> listduan = duAnService.getDuAnByKhachHangId(ID);

        System.out.println(ID);

        model.addAttribute("listduan", listduan);

        List<DangGiaoDich> listdang = dangGiaoDichService.getAllDangGiaoDich();

        model.addAttribute("listdang", listdang);

        return "ViewKhachHang/TrangThemGiaoDich";
    }

    @PostMapping("giaodich/new")
    public String createDuAn(@ModelAttribute QuanLyGiaoDichDuAn giaodichduan,
                             @RequestParam("duan") Long DuAnId,
                             @RequestParam("danggiaodich") Long DangGiaoDichId,
                             HttpServletRequest request,
                             RedirectAttributes redirectAttributes) {


        DuAn duan = duAnService.getDuAnById(DuAnId);
        giaodichduan.setDuan(duan);

        DangGiaoDich danggiaodich = dangGiaoDichService.getDangGiaoDichById(DangGiaoDichId);
        giaodichduan.setDanggiaodich(danggiaodich);

        giaodichduanService.saveGiaoDichDuAn(giaodichduan);

        // Thông báo thành công
        redirectAttributes.addFlashAttribute("successMessage", "Giao dịch đã được thêm thành công.");

        // Redirect to the appropriate URL with KhachHangId
        return "redirect:/khachhang/giaodich/" + ID;
    }


}
