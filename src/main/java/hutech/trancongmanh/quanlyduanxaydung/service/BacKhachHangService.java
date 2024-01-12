package hutech.trancongmanh.quanlyduanxaydung.service;


import hutech.trancongmanh.quanlyduanxaydung.entity.BacKhachHang;
import hutech.trancongmanh.quanlyduanxaydung.repository.BacKhachHangRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BacKhachHangService {

    @Autowired
    private BacKhachHangRepository bacKhachHangRepository;

    public BacKhachHang createBacKhachHang(BacKhachHang bacKhachHang) {
        // Set other fields if needed

        BacKhachHang savedBacKhachHang = bacKhachHangRepository.save(bacKhachHang);
        return savedBacKhachHang;
    }

    public BacKhachHang getBacKhachHangById(Long bacKhachHangId) {
        Optional<BacKhachHang> bacKhachHangOptional = bacKhachHangRepository.findById(bacKhachHangId);
        return bacKhachHangOptional.orElse(null);
    }

    public BacKhachHang updateBacKhachHang(Long bacKhachHangId, BacKhachHang bacKhachHang) {
        Optional<BacKhachHang> bacKhachHangOptional = bacKhachHangRepository.findById(bacKhachHangId);
        if (bacKhachHangOptional.isPresent()) {
            BacKhachHang existingBacKhachHang = bacKhachHangOptional.get();
            // Copy information from DTO to existing entity
            BeanUtils.copyProperties(bacKhachHang, existingBacKhachHang);
            // Update other fields if needed

            BacKhachHang updatedBacKhachHang = bacKhachHangRepository.save(existingBacKhachHang);
            return updatedBacKhachHang;
        }
        return null;
    }

    public boolean deleteBacKhachHang(Long bacKhachHangId) {
        if (bacKhachHangRepository.existsById(bacKhachHangId)) {
            bacKhachHangRepository.deleteById(bacKhachHangId);
            return true;
        }
        return false;
    }

    public List<BacKhachHang> getAllBacKhachHang() {
        List<BacKhachHang> bacKhachHangList = bacKhachHangRepository.findAll();
        return bacKhachHangList;
    }
}

