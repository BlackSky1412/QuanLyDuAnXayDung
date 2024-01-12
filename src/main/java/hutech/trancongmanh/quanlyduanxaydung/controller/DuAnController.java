package hutech.trancongmanh.quanlyduanxaydung.controller;

import hutech.trancongmanh.quanlyduanxaydung.entity.CachThucThanhToan;
import hutech.trancongmanh.quanlyduanxaydung.entity.DuAn;
import hutech.trancongmanh.quanlyduanxaydung.entity.KhachHang;
import hutech.trancongmanh.quanlyduanxaydung.entity.TrangThai;
import hutech.trancongmanh.quanlyduanxaydung.service.CachThucThanhToanService;
import hutech.trancongmanh.quanlyduanxaydung.service.DuAnService;
import hutech.trancongmanh.quanlyduanxaydung.service.KhachHangService;
import hutech.trancongmanh.quanlyduanxaydung.service.TrangThaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@Controller
@RequestMapping("/api/duan")
public class DuAnController {

    @Autowired
    private DuAnService duAnService;

    @Autowired
    private CachThucThanhToanService cachthucthanhtoanService;

    @Autowired
    private KhachHangService khachhangService;

    @Autowired
    private TrangThaiService trangthaiService;

    @GetMapping
    public String viewAll(Model model) {
        List<DuAn> listDuan = duAnService.getAllDuAn();
        model.addAttribute("duanList", listDuan);
        return "duan/index";
    }

    @GetMapping("/new")
    public String showCreateDuAnPage(Model model) {
        // You can add any model attributes needed for the form
        model.addAttribute("duan", new DuAn());

        // Assuming you have a method to retrieve the list of CachThucThanhToan objects
        List<CachThucThanhToan> cachThucThanhToanList = cachthucthanhtoanService.getAllCachThucThanhToan();
        List<KhachHang> khachhangList = khachhangService.getAllKhachHang();
        List<TrangThai> trangthaiList = trangthaiService.getAllTrangThai();

        // Add the list to the model
        model.addAttribute("cachThucThanhToanList", cachThucThanhToanList);
        model.addAttribute("khachhangList", khachhangList);
        model.addAttribute("trangthaiList", trangthaiList);

        return "duan/CreateDuAn";
    }


    // Handle form submission
    @PostMapping("/new")
    public String createDuAn(@ModelAttribute DuAn duan,
                             @RequestParam("giayPhepXayDung") MultipartFile giayPhepXayDung,
                             @RequestParam("banThietKe") MultipartFile banThietKe,
                             @RequestParam("khachhang") Long khachhangId,
                             @RequestParam("cachthucthanhtoan") Long cachThucThanhToanId,
                             @RequestParam("trangthai") Long trangThaiId, RedirectAttributes redirectAttributes) {

        // Xử lý tệp tin và lấy đường dẫn
        String giayPhepXayDungPath = saveFileAndGetPath(giayPhepXayDung);
        String banThietKePath = saveFileAndGetPath(banThietKe);

        // Set đường dẫn vào thuộc tính của đối tượng DuAn
        duan.setGiayPhepXayDungPath(giayPhepXayDungPath);
        duan.setBanThietKePath(banThietKePath);

        // Lấy thông tin khách hàng từ cơ sở dữ liệu dựa trên khachhangId
        KhachHang khachhang = khachhangService.getKhachHangById(khachhangId);
        // Lấy thông tin cách thức thanh toán từ cơ sở dữ liệu dựa trên cachThucThanhToanId
        CachThucThanhToan cachThucThanhToan = cachthucthanhtoanService.getCachThucThanhToanById(cachThucThanhToanId);
        // Lấy thông tin trạng thái từ cơ sở dữ liệu dựa trên trangThaiId
        TrangThai trangThai = trangthaiService.getTrangThaiById(trangThaiId);

        // Thiết lập khách hàng, cách thức thanh toán và trạng thái trong DuAnDTO
        duan.setkhachhang(khachhang);
        duan.setCachThucThanhToan(cachThucThanhToan);
        duan.settrangthai(trangThai);

        // Logic để lưu DTO vào cơ sở dữ liệu
        duAnService.save(duan);
        // Thông báo thành công
        redirectAttributes.addFlashAttribute("successMessage", "Dự án đã được tạo thành công.");
        return "redirect:/api/duan";
    }


    private String saveFileAndGetPath(MultipartFile file) {
        // Logic để lưu file và trả về đường dẫn
        String uploadDir = "src/main/resources/static/uploads/";
        String fileName = file.getOriginalFilename();
        String filePath = Paths.get(uploadDir, fileName).toString();

        try {
            Files.write(Paths.get(filePath), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;  // Trả về đường dẫn đầy đủ thay vì chỉ là tên file
    }


    @GetMapping("/edit/{id}")
    public String editDuan(@PathVariable("id") Long id, Model model) {
        DuAn duan = duAnService.getDuAnById(id);
        model.addAttribute("duan", duan);

        // Assuming you have methods to retrieve lists for cachThucThanhToanList, khachhangList, and trangthaiList
        List<CachThucThanhToan> cachThucThanhToanList = cachthucthanhtoanService.getAllCachThucThanhToan();
        List<KhachHang> khachhangList = khachhangService.getAllKhachHang();
        List<TrangThai> trangthaiList = trangthaiService.getAllTrangThai();

        model.addAttribute("cachThucThanhToanList", cachThucThanhToanList);
        model.addAttribute("khachhangList", khachhangList);
        model.addAttribute("trangthaiList", trangthaiList);

        return "duan/EditDuAn";
    }

    // Handle form submission for updating DuAn
    @PostMapping("/edit")
    public String updateDuAn(
                             @ModelAttribute DuAn duan,
                             @RequestParam("giayPhepXayDung") MultipartFile giayPhepXayDung,
                             @RequestParam("banThietKe") MultipartFile banThietKe,
                             @ModelAttribute("khachhang") Long khachhangId,
                             @ModelAttribute("cachthucthanhtoan") Long cachThucThanhToanId,
                             @ModelAttribute("trangthai") Long trangThaiId, RedirectAttributes redirectAttributes) {

        // Xử lý và lưu trữ file giayPhepXayDung và banThietKe nếu cần
        // Xử lý tệp tin và lấy đường dẫn
        String giayPhepXayDungPath = saveFileAndGetPath(giayPhepXayDung);
        String banThietKePath = saveFileAndGetPath(banThietKe);

        // Set đường dẫn vào thuộc tính của đối tượng DuAn
        duan.setGiayPhepXayDungPath(giayPhepXayDungPath);
        duan.setBanThietKePath(banThietKePath);

        // Ánh xạ các giá trị từ form vào đối tượng DuAn
        duan.setkhachhang(khachhangService.getKhachHangById(khachhangId));
        duan.setCachThucThanhToan(cachthucthanhtoanService.getCachThucThanhToanById(cachThucThanhToanId));
        duan.settrangthai(trangthaiService.getTrangThaiById(trangThaiId));

        // Lưu đối tượng DuAn đã cập nhật


        duAnService.updateDuAn(duan);


        // Thông báo thành công
        redirectAttributes.addFlashAttribute("successMessage", "Thông tin dự án đã được cập nhật thành công.");
        // Chuyển hướng về trang hiển thị danh sách DuAn
        return "redirect:/api/duan";
    }

}
