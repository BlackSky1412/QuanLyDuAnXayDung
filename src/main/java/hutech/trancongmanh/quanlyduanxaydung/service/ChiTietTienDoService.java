package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.ChiTietTienDo;
import hutech.trancongmanh.quanlyduanxaydung.repository.ChiTietTienDoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ChiTietTienDoService {
    @Autowired
    private ChiTietTienDoRepository chiTietTienDoRepository;


    public List<ChiTietTienDo> getAllChiTietTienDoForBangTheoDoiTienDo(Long bangTheoDoiTienDoId) {

        List<ChiTietTienDo> allTienDo = chiTietTienDoRepository.findAll();

        // Filter the progress updates based on the given project ID
        List<ChiTietTienDo> chiTietTienDoList = allTienDo.stream()
                .filter(tienDo -> tienDo.getBangtheodoitiendo().getId().equals(bangTheoDoiTienDoId))
                .collect(Collectors.toList());

        return chiTietTienDoList;
    }

    public void save(ChiTietTienDo chiTietTienDo) {
        // Implementation for saving the ChiTietTienDo object
        chiTietTienDoRepository.save(chiTietTienDo);
    }


    public Optional<ChiTietTienDo> getChiTietTienDoById(Long id) {
        return chiTietTienDoRepository.findById(id);
    }
    @Transactional
    public void updateChiTietTienDo(ChiTietTienDo updatedChiTietTienDo) {
        // Ensure that the ID is not null before proceeding
        Long id = updatedChiTietTienDo.getId();
        if (id == null) {
            throw new IllegalArgumentException("The ID must not be null");
        }

        // Retrieve the existing ChiTietTienDo entity from the database
        ChiTietTienDo existingChiTietTienDo = chiTietTienDoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ChiTietTienDo not found with ID: " + id));

        // Update the fields you want to modify
        existingChiTietTienDo.setNameTask(updatedChiTietTienDo.getNameTask());
        existingChiTietTienDo.setNgayBatDau(updatedChiTietTienDo.getNgayBatDau());
        existingChiTietTienDo.setNgayHoanThanh(updatedChiTietTienDo.getNgayHoanThanh());
        existingChiTietTienDo.setTrangthai(updatedChiTietTienDo.getTrangthai());

        // Save the updated entity back to the database
        chiTietTienDoRepository.save(existingChiTietTienDo);
    }



}