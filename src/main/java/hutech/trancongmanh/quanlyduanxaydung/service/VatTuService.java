package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.VatTu;
import hutech.trancongmanh.quanlyduanxaydung.repository.VatTuRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VatTuService {

    @Autowired
    private VatTuRepository vatTuRepository;

    public VatTu createVatTu(VatTu vattu) {
        // Set other fields if needed

        VatTu savedVatTu = vatTuRepository.save(vattu);
        return savedVatTu;
    }

    public VatTu getVatTuById(Long vattuId) {
        Optional<VatTu> vattuOptional = vatTuRepository.findById(vattuId);
        return vattuOptional.orElse(null);
    }

    @Transactional
    public VatTu updateVatTu(VatTu updatedVatTu) {
        Long vatTuId = updatedVatTu.getId();
        VatTu existingVatTu = vatTuRepository.findById(vatTuId).orElse(null);

        if (existingVatTu != null) {
            // Update properties of existingVatTu with values from updatedVatTu
            existingVatTu.setTenVatTu(updatedVatTu.getTenVatTu());
            existingVatTu.setDonViTinh(updatedVatTu.getDonViTinh());
            existingVatTu.setGiaNhap(updatedVatTu.getGiaNhap());
            existingVatTu.setGiaBan(updatedVatTu.getGiaBan());
            // Update other fields similarly

            // Save the updated VatTu object using the repository
            return vatTuRepository.save(existingVatTu);
        }
        return null;
    }


    public List<VatTu> getAllVatTu() {
        List<VatTu> vattuList = vatTuRepository.findAll();
        return vattuList;
    }
}
