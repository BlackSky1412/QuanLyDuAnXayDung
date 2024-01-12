package hutech.trancongmanh.quanlyduanxaydung.controller.nhathaucontroller;


import hutech.trancongmanh.quanlyduanxaydung.entity.*;
import hutech.trancongmanh.quanlyduanxaydung.service.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/nhathau")
public class DuAn_NhaThau {

    @Autowired
    private DuAnService duAnService;
    @Autowired
    private BangTheoDoiTienDoService bangTheoDoiTienDoService;

    @Autowired
    private AnhService anhservice;

    @Autowired
    private ChiTietTienDoService chiTietTienDoService;

    @Autowired
    private TrangThaiService trangthaiService;
    private long ID = 0;
    private long IDnhathau = 0;

    @GetMapping("duan/{NhaThauId}")
    public String viewAll(@PathVariable Long NhaThauId, Model model) {
        IDnhathau = NhaThauId;
        List<DuAn> listDuan = duAnService.getDuAnByNhaThauId(NhaThauId);
        model.addAttribute("duanList", listDuan);
        return "ViewNhaThau/TrangChu";
    }

    @GetMapping("tiendo/{NhaThauId}")
    public String viewAllTienDo(@PathVariable Long NhaThauId, Model model) {

        List<BangTheoDoiTienDo> listtiendo = bangTheoDoiTienDoService.getAllTienDoForNhaThau(NhaThauId);
        model.addAttribute("listtiendo", listtiendo);
        for (BangTheoDoiTienDo tiendo : listtiendo) {
            System.out.println("ID: " + tiendo.getId());
            // Include other properties as needed
        }
        return "ViewNhaThau/TrangTienDo";
    }

    @GetMapping("chitiettiendo/{BangTheoDoiTienDoId}")
    public String viewAllChiTietTienDo(@PathVariable Long BangTheoDoiTienDoId, Model model) {
        ID = BangTheoDoiTienDoId;
        model.addAttribute("chitiettiendo", new ChiTietTienDo());
        // Retrieve list of ChiTietTienDo objects
        List<ChiTietTienDo> listChitiettiendo = chiTietTienDoService.getAllChiTietTienDoForBangTheoDoiTienDo(BangTheoDoiTienDoId);
        model.addAttribute("listChitiettiendo", listChitiettiendo);

        // Retrieve list of TrangThai objects
        List<TrangThai> trangthaiList = trangthaiService.getAllTrangThai();
        model.addAttribute("trangthaiList", trangthaiList);

        // Add a new ChiTietTienDo object to the model
        model.addAttribute("chitiettiendo", new ChiTietTienDo());

        // Return the Thymeleaf template name
        return "ViewNhaThau/TrangChiTietTienDo";
    }


    @GetMapping("upanh/{chitiettienDoId}")
    public String viewUpanh(@PathVariable Long chitiettienDoId, Model model) {
        ID = chitiettienDoId;
        return "ViewNhaThau/TrangUpHinh";
    }

    @PostMapping("/upanh")
    public String saveAnh(@RequestParam("file") MultipartFile anh,
                          RedirectAttributes redirectAttributes) {
        // Check if the file is not empty
        if (!anh.isEmpty()) {
            // Xử lý tệp tin và lấy đường dẫn
            String anhPath = saveFileAndGetPath(anh);

            // Assuming ID is defined somewhere in your code
            Optional<ChiTietTienDo> chiTietTienDo = chiTietTienDoService.getChiTietTienDoById(ID);

            // Check if ChiTietTienDo is present in the Optional
            if (chiTietTienDo.isPresent()) {
                Anh img = new Anh();
                img.setPath(anhPath);
                img.setChitiettiendo(chiTietTienDo.get()); // Extract the ChiTietTienDo object from Optional

                anhservice.saveImage(img);
                // Thông báo thành công
                redirectAttributes.addFlashAttribute("successMessage", "Dự án đã được tạo thành công.");
            } else {
                // Handle the case where ChiTietTienDo is not present
                redirectAttributes.addFlashAttribute("errorMessage", "ChiTietTienDo not found.");
            }
        } else {
            // Handle the case where the file is empty
            redirectAttributes.addFlashAttribute("errorMessage", "Please choose an image to upload.");
        }

        return "redirect:/nhathau/duan/" + IDnhathau;
    }



    private String saveFileAndGetPath(MultipartFile file) {
        // Logic để lưu file và trả về đường dẫn
        String uploadDir = "/uploads/";
        String fileName = file.getOriginalFilename();
        String filePath = Paths.get(uploadDir, fileName).toString();

        try {
            Files.write(Paths.get(filePath), file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return filePath;  // Trả về đường dẫn đầy đủ thay vì chỉ là tên file
    }

}

