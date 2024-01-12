package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.ChucVu;
import hutech.trancongmanh.quanlyduanxaydung.repository.ChucVuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChucVuService {

    @Autowired
    private ChucVuRepository chucVuRepository;

    public List<ChucVu> getAllChucVu() {
        return chucVuRepository.findAll();
    }

    public ChucVu getChucVuById(Long chucVuId) {
        Optional<ChucVu> chucVuOptional = chucVuRepository.findById(chucVuId);
        return chucVuOptional.orElse(null);
    }

    public ChucVu saveChucVu(ChucVu chucVu) {
        return chucVuRepository.save(chucVu);
    }

    @Transactional
    public ChucVu updateChucVu(ChucVu updatedChucVu) {
        Long chucVuId = updatedChucVu.getId();
        ChucVu existingChucVu = chucVuRepository.findById(chucVuId).orElse(null);

        if (existingChucVu != null) {
            existingChucVu.setTenChucVu(updatedChucVu.getTenChucVu());

            // Save the updated ChucVu object using the repository
            return chucVuRepository.save(existingChucVu);
        }
        return null;
    }
}
