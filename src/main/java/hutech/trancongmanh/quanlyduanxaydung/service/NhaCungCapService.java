package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.NhaCungCapVatTu;
import hutech.trancongmanh.quanlyduanxaydung.repository.NhaCungCapVatTuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaCungCapService {

    @Autowired
    private NhaCungCapVatTuRepository nhaCungCapVatTuRepository;

    public NhaCungCapVatTu createNhaCungCapVatTu(NhaCungCapVatTu nhaCungCapVatTu) {
        return nhaCungCapVatTuRepository.save(nhaCungCapVatTu);
    }

    public NhaCungCapVatTu getNhaCungCapVatTuById(Long id) {
        Optional<NhaCungCapVatTu> nhaCungCapVatTuOptional = nhaCungCapVatTuRepository.findById(id);
        return nhaCungCapVatTuOptional.orElse(null);
    }

    @Transactional
    public NhaCungCapVatTu updateNhaCungCapVatTu(NhaCungCapVatTu updatedNhaCungCap) {
        Long nhaCungCapId = updatedNhaCungCap.getId();
        Optional<NhaCungCapVatTu> optionalExistingNhaCungCap = nhaCungCapVatTuRepository.findById(nhaCungCapId);

        if (optionalExistingNhaCungCap.isPresent()) {
            NhaCungCapVatTu existingNhaCungCap = optionalExistingNhaCungCap.get();

            // Update properties of existingNhaCungCap with values from updatedNhaCungCap
            existingNhaCungCap.setTenNhaCungCap(updatedNhaCungCap.getTenNhaCungCap());
            existingNhaCungCap.setVatTuCungCap(updatedNhaCungCap.getVatTuCungCap());
            existingNhaCungCap.setDiaChi(updatedNhaCungCap.getDiaChi());
            existingNhaCungCap.setSDT(updatedNhaCungCap.getSDT());
            existingNhaCungCap.setEmail(updatedNhaCungCap.getEmail());
            existingNhaCungCap.setTenNganHang(updatedNhaCungCap.getTenNganHang());
            existingNhaCungCap.setSoTaiKhoan(updatedNhaCungCap.getSoTaiKhoan());
            // Update other fields similarly

            // Save the updated NhaCungCapVatTu object using the repository
            return nhaCungCapVatTuRepository.save(existingNhaCungCap);
        }
        return null; // Or throw an exception, return an error response, etc., based on your requirements
    }
    public List<NhaCungCapVatTu> getAllNhaCungCapVatTu() {
        return nhaCungCapVatTuRepository.findAll();
    }
}
