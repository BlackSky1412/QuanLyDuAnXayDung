package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.DangGiaoDich;
import hutech.trancongmanh.quanlyduanxaydung.repository.DangGiaoDichRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class DangGiaoDichService {

    @Autowired
    private DangGiaoDichRepository dangGiaoDichRepository;

    public List<DangGiaoDich> getAllDangGiaoDich() {
        return dangGiaoDichRepository.findAll();
    }

    public DangGiaoDich getDangGiaoDichById(Long dangGiaoDichId) {
        Optional<DangGiaoDich> dangGiaoDichOptional = dangGiaoDichRepository.findById(dangGiaoDichId);
        return dangGiaoDichOptional.orElse(null);
    }

    public DangGiaoDich saveDangGiaoDich(DangGiaoDich dangGiaoDich) {
        return dangGiaoDichRepository.save(dangGiaoDich);
    }

    @Transactional
    public DangGiaoDich updateDangGiaoDich(DangGiaoDich updatedDangGiaoDich) {
        Long dangGiaoDichId = updatedDangGiaoDich.getId();
        DangGiaoDich existingDangGiaoDich = dangGiaoDichRepository.findById(dangGiaoDichId).orElse(null);

        if (existingDangGiaoDich != null) {
            existingDangGiaoDich.setDangGiaoDich(updatedDangGiaoDich.getDangGiaoDich());

            // Save the updated DangGiaoDich object using the repository
            return dangGiaoDichRepository.save(existingDangGiaoDich);
        }
        return null;
    }
}
