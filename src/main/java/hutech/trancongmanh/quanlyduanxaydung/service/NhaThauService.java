package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.KhachHang;
import hutech.trancongmanh.quanlyduanxaydung.entity.NhaThau;
import hutech.trancongmanh.quanlyduanxaydung.repository.NhaThauRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhaThauService {

    @Autowired
    private NhaThauRepository nhaThauRepository;

    public NhaThau createNhaThau(NhaThau nhaThau) {
        // Set other fields if needed

        NhaThau savedNhaThau = nhaThauRepository.save(nhaThau);
        return savedNhaThau;
    }

    public NhaThau getNhaThauById(Long nhaThauId) {
        Optional<NhaThau> nhaThauOptional = nhaThauRepository.findById(nhaThauId);
        return nhaThauOptional.orElse(null);
    }

    @Transactional
    public NhaThau updateNhaThau(NhaThau updatedNhaThau) {
        Long nhaThauId = updatedNhaThau.getId();
        NhaThau existingNhaThau = nhaThauRepository.findById(nhaThauId).orElse(null);

        if (existingNhaThau != null) {
            // Update properties of existingNhaThau with values from updatedNhaThau
            existingNhaThau.setTenNhaThau(updatedNhaThau.getTenNhaThau());
            existingNhaThau.setDiaChi(updatedNhaThau.getDiaChi());
            existingNhaThau.setSDT(updatedNhaThau.getSDT());
            existingNhaThau.setEmail(updatedNhaThau.getEmail());
            existingNhaThau.setTenNganHang(updatedNhaThau.getTenNganHang());
            existingNhaThau.setSoTaiKhoan(updatedNhaThau.getSoTaiKhoan());
            // Update other fields similarly

            // Save the updated NhaThau object using the repository
            return nhaThauRepository.save(existingNhaThau);
        }
        return null;
    }

    public List<NhaThau> getAllNhaThau() {
        List<NhaThau> nhaThauList = nhaThauRepository.findAll();
        return nhaThauList;
    }
}
