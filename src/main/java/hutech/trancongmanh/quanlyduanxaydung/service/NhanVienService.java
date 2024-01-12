package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.KhachHang;
import hutech.trancongmanh.quanlyduanxaydung.entity.NhanVien;
import hutech.trancongmanh.quanlyduanxaydung.repository.NhanVienRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NhanVienService {

    @Autowired
    private NhanVienRepository nhanVienRepository;

    public NhanVien createNhanVien(NhanVien nhanVien) {
        // Set other fields if needed

        NhanVien savedNhanVien = nhanVienRepository.save(nhanVien);
        return savedNhanVien;
    }

    public NhanVien getNhanVienById(Long nhanVienId) {
        Optional<NhanVien> nhanVienOptional = nhanVienRepository.findById(nhanVienId);
        return nhanVienOptional.orElse(null);
    }

    @Transactional
    public NhanVien updateNhanVien(NhanVien updatedNhanVien) {
        Long nhanVienId = updatedNhanVien.getId();
        NhanVien existingNhanVien = nhanVienRepository.findById(nhanVienId).orElse(null);

        if (existingNhanVien != null) {
            // Update properties of existingNhanVien with values from updatedNhanVien
            existingNhanVien.setTenNhanVien(updatedNhanVien.getTenNhanVien());
            existingNhanVien.setNgaySinh(updatedNhanVien.getNgaySinh());
            existingNhanVien.setGioiTinh(updatedNhanVien.getGioiTinh());
            existingNhanVien.setNgayVaoLam(updatedNhanVien.getNgayVaoLam());
            existingNhanVien.setDiaChi(updatedNhanVien.getDiaChi());
            existingNhanVien.setSDT(updatedNhanVien.getSDT());
            existingNhanVien.setEmail(updatedNhanVien.getEmail());
            // Update other fields similarly

            // Set ChucVu directly
            existingNhanVien.setChucvu(updatedNhanVien.getChucvu());

            // Save the updated NhanVien object using the repository
            return nhanVienRepository.save(existingNhanVien);
        }
        return null;
    }


    public List<NhanVien> getAllNhanVien() {
        List<NhanVien> nhanVienList = nhanVienRepository.findAll();
        return nhanVienList;
    }
}