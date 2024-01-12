package hutech.trancongmanh.quanlyduanxaydung.controller;


import hutech.trancongmanh.quanlyduanxaydung.entity.*;
import hutech.trancongmanh.quanlyduanxaydung.service.AnhService;
import hutech.trancongmanh.quanlyduanxaydung.service.BangTheoDoiTienDoService;
import hutech.trancongmanh.quanlyduanxaydung.service.ChiTietTienDoService;
import hutech.trancongmanh.quanlyduanxaydung.service.TrangThaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@RequestMapping("/api/chitiettiendo")
public class ChiTietTienDoController {

    @Autowired
    private ChiTietTienDoService chiTietTienDoService;

    @Autowired
    private TrangThaiService trangthaiService;

    @Autowired
    private BangTheoDoiTienDoService bangTheoDoiTienDoService;

    @Autowired
    private AnhService anhService;

    private Long ID = 0L;

    @GetMapping("/{BangTheoDoiTienDoId}")
    public String viewAll(@PathVariable Long BangTheoDoiTienDoId, Model model) {
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
        return "chitiettiendo/index";
    }

    @GetMapping("/new")
    public String ShowViewCreate(Model model) {

        model.addAttribute("chitiettiendo", new ChiTietTienDo());

        // Retrieve list of TrangThai objects
        List<TrangThai> trangthaiList = trangthaiService.getAllTrangThai();
        model.addAttribute("trangthaiList", trangthaiList);


        // Return the Thymeleaf template name
        return "chitiettiendo/TrangThemChiTietTienDo";
    }

    @PostMapping("/new")
    public String createNewChiTietTienDo(@ModelAttribute ChiTietTienDo chitiettiendo,
                                         @RequestParam("trangthai") Long trangthaiId,
                                         RedirectAttributes redirectAttributes) {

        // Retrieve TrangThai by ID
        TrangThai trangthai = trangthaiService.getTrangThaiById(trangthaiId);

        // Retrieve BangTheoDoiTienDo by ID
        Optional<BangTheoDoiTienDo> bangTheoDoiTienDo = bangTheoDoiTienDoService.getBangTheoDoiTienDoById(ID);

        if (bangTheoDoiTienDo.isPresent()) {
            // Set TrangThai and BangTheoDoiTienDo for the ChiTietTienDo entity
            chitiettiendo.setTrangthai(trangthai);
            chitiettiendo.setBangtheodoitiendo(bangTheoDoiTienDo.get());

            // Save the new ChiTietTienDo
            chiTietTienDoService.save(chitiettiendo);

            // Redirect to the list page or any other page you want
            redirectAttributes.addFlashAttribute("successMessage", "Giao dịch đã được thêm thành công.");
            return "redirect:/api/chitiettiendo/" + ID; // Assuming getId() returns the ID of the saved entity
        } else {
            // Handle the case where BangTheoDoiTienDo is not found
            redirectAttributes.addFlashAttribute("errorMessage", "Không tìm thấy BangTheoDoiTienDo với ID: ");
            return "redirect:/error"; // You should define an error page
        }
    }




    @GetMapping("/edit/{id}")
    public String showUpdateStatusForm(@PathVariable Long id, Model model) {
        // Retrieve the existing entity by ID
        ChiTietTienDo existingEntity = chiTietTienDoService.getChiTietTienDoById(id)
                .orElseThrow(() -> new RuntimeException("ChiTietTienDo not found with ID: " + id));

        // Retrieve list of TrangThai objects
        List<TrangThai> trangthaiList = trangthaiService.getAllTrangThai();
        List<Anh> listimages = anhService.getAllImages();

        model.addAttribute("listimages", listimages);

        model.addAttribute("existingEntity", existingEntity);
        model.addAttribute("trangthaiList", trangthaiList);


        return "chitiettiendo/TrangHinhAnhCongViec";
    }

    @PostMapping("/edit")
    public String updateStatus(@ModelAttribute("existingEntity") ChiTietTienDo existingEntity,
                               RedirectAttributes redirectAttributes) {

        // Retrieve the existing entity from the database
        ChiTietTienDo entityToUpdate = chiTietTienDoService.getChiTietTienDoById(existingEntity.getId())
                .orElseThrow(() -> new RuntimeException("ChiTietTienDo not found with ID: " + existingEntity.getId()));

        // Update the status
        entityToUpdate.setTrangthai(existingEntity.getTrangthai());

        // Save the updated entity
        chiTietTienDoService.updateChiTietTienDo(entityToUpdate);

        // Redirect with success message
        redirectAttributes.addFlashAttribute("successMessage", "Status updated successfully.");
        return "redirect:/api/chitiettiendo/" + ID;
    }
}
