package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.KhachHang;
import hutech.trancongmanh.quanlyduanxaydung.repository.KhachHangRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KhachHangService {

    @Autowired
    private KhachHangRepository khachHangRepository;

    public KhachHang createKhachHang(KhachHang khachHang) {
        // Set other fields if needed

        KhachHang savedKhachHang = khachHangRepository.save(khachHang);
        return savedKhachHang;
    }

    public KhachHang getKhachHangById(Long khachHangId) {
        Optional<KhachHang> khachHangOptional = khachHangRepository.findById(khachHangId);
        return khachHangOptional.orElse(null);
    }

    @Transactional
    public KhachHang updateKhachHang(KhachHang updatedKhachHang) {
        Long khachHangId = updatedKhachHang.getId();
        KhachHang existingKhachHang = khachHangRepository.findById(khachHangId).orElse(null);

        if (existingKhachHang != null) {
            // Update properties of existingKhachHang with values from updatedKhachHang
            existingKhachHang.setTenKhachHang(updatedKhachHang.getTenKhachHang());
            existingKhachHang.setDiaChi(updatedKhachHang.getDiaChi());
            existingKhachHang.setSDT(updatedKhachHang.getSDT());
            existingKhachHang.setEmail(updatedKhachHang.getEmail());
            existingKhachHang.setTenNganHang(updatedKhachHang.getTenNganHang());
            existingKhachHang.setSoTaiKhoan(updatedKhachHang.getSoTaiKhoan());
            // Update other fields similarly
            existingKhachHang.setBackhachhang(updatedKhachHang.getBackhachhang());

            // Save the updated KhachHang object using the repository
            return khachHangRepository.save(existingKhachHang);
        }
        return null;
    }


    public boolean deleteKhachHang(Long khachHangId) {
        if (khachHangRepository.existsById(khachHangId)) {
            khachHangRepository.deleteById(khachHangId);
            return true;
        }
        return false;
    }

    public List<KhachHang> getAllKhachHang() {
        List<KhachHang> khachHangList = khachHangRepository.findAll();
        return khachHangList;
    }
}
