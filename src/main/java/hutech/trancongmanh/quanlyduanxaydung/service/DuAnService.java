package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.DuAn;
import hutech.trancongmanh.quanlyduanxaydung.repository.DuAnRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.Optional;



@Service
public class DuAnService {

    @Autowired
    private DuAnRepository duAnRepository;

    public List<DuAn> getAllDuAn() {
        return duAnRepository.findAll();
    }

    public DuAn getDuAnById(Long duanId) {
        Optional<DuAn> duAnOptional = duAnRepository.findById(duanId);
        return duAnOptional.orElse(null);
    }

    public DuAn save(DuAn duAn) {
        return duAnRepository.save(duAn);
    }

    @Transactional
    public DuAn updateDuAn(DuAn updatedDuAn) {
        Long duAnId = updatedDuAn.getId();
        DuAn existingDuAn = duAnRepository.findById(duAnId).orElse(null);

        if (existingDuAn != null) {
            // Cập nhật thuộc tính của existingDuAn bằng các giá trị từ updatedDuAn
            existingDuAn.setTenDuAn(updatedDuAn.getTenDuAn());
            existingDuAn.setDiaChi(updatedDuAn.getDiaChi());
            existingDuAn.setNgayKy(updatedDuAn.getNgayKy());
            existingDuAn.setNgayKhoiCong(updatedDuAn.getNgayKhoiCong());
            existingDuAn.setNgayHoanThanhDuKien(updatedDuAn.getNgayHoanThanhDuKien());
            existingDuAn.setChiPhiUocTinh(updatedDuAn.getChiPhiUocTinh());
            existingDuAn.setChiPhiThucTe(updatedDuAn.getChiPhiThucTe());
            // Cập nhật các trường khác tương tự
            existingDuAn.setkhachhang(updatedDuAn.getKhachhang());
            existingDuAn.setCachThucThanhToan(updatedDuAn.getCachthucthanhtoan());
            existingDuAn.settrangthai(updatedDuAn.getTrangthai());

            // Lưu đối tượng DuAn đã cập nhật bằng câu truy vấn
            return duAnRepository.save(existingDuAn);
        }
        return null;
    }



    private static final Logger logger = LoggerFactory.getLogger(DuAnService.class);

    public boolean deleteDuAn(Long duanId) {
        if (duAnRepository.existsById(duanId)) {
            logger.info("Deleting DuAn with ID: {}", duanId);
            duAnRepository.deleteById(duanId);
            return true;
        }
        logger.warn("DuAn with ID {} not found. Unable to delete.", duanId);
        return false;
    }


    public List<DuAn> getDuAnByKhachHangId(Long khachHangId) {
        return duAnRepository.findByKhachHang_Id(khachHangId);
    }

    public List<DuAn> getDuAnByNhaThauId(Long nhaThauId) {
        return duAnRepository.findByNhaThau_Id(nhaThauId);
    }

}
