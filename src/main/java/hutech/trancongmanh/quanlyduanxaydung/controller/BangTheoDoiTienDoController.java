package hutech.trancongmanh.quanlyduanxaydung.controller;

import hutech.trancongmanh.quanlyduanxaydung.entity.*;
import hutech.trancongmanh.quanlyduanxaydung.service.BangTheoDoiTienDoService;
import hutech.trancongmanh.quanlyduanxaydung.service.ChiTietDuAnService;
import hutech.trancongmanh.quanlyduanxaydung.service.DuAnService;
import hutech.trancongmanh.quanlyduanxaydung.service.NhaThauService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/api/tiendo")
public class BangTheoDoiTienDoController {

    @Autowired
    private BangTheoDoiTienDoService bangTheoDoiTienDoService;

    @Autowired
    private DuAnService duAnService;

    @Autowired
    private NhaThauService nhaThauService;

    @Autowired
    private ChiTietDuAnService chiTietDuAnService;

    private Long ID = 0L;

    @GetMapping("/{duAnId}")
    public String viewAll(@PathVariable Long duAnId, Model model) {
        ID = duAnId;
        List<BangTheoDoiTienDo> listTienDo = bangTheoDoiTienDoService.getAllTienDoForDuAn(duAnId);
        model.addAttribute("listTienDo", listTienDo);
        return "theodoitiendo/index";
    }

    @GetMapping("/new")
    public String ShowCreateView(Model model) {

        model.addAttribute("bangtheodoitiendo", new BangTheoDoiTienDo());

        List<DuAn> listduan = duAnService.getAllDuAn();
        model.addAttribute("listduan", listduan);

        List<NhaThau> listnhathau = nhaThauService.getAllNhaThau();
        model.addAttribute("listnhathau", listnhathau);

        List<BangTheoDoiTienDo> listTienDo = bangTheoDoiTienDoService.getAllTienDoForDuAn(ID);
        model.addAttribute("listTienDo", listTienDo);

        System.out.println(ID);
        return "theodoitiendo/TrangThemTienDo";
    }

    @PostMapping("/new")
    public String createTienDo(@ModelAttribute BangTheoDoiTienDo bangtheodoitiendo,
                               @RequestParam("duan") Long duanId,
                               @RequestParam("nhathau") Long nhathauId,
                               RedirectAttributes redirectAttributes) {

        ChiTietDuAn chitietDuan = new ChiTietDuAn();
        ChiTietDuAn_Key chitietDuan_key = new ChiTietDuAn_Key();
        chitietDuan_key.setDuAnId(duanId);
        chitietDuan_key.setNhaThauId(nhathauId);

        chitietDuan.setId(chitietDuan_key);

        chitietDuan.setNhathau(nhaThauService.getNhaThauById(nhathauId));
        chitietDuan.setDuan(duAnService.getDuAnById(duanId));

        // lưu xuống csdl
        chiTietDuAnService.saveChiTietDuAn(chitietDuan);

        bangTheoDoiTienDoService.Update(bangtheodoitiendo);

        redirectAttributes.addFlashAttribute("successMessage", "Tiến độ đã được tạo thành công.");
        return "redirect:/api/tiendo" + "/" + ID;
    }
}
