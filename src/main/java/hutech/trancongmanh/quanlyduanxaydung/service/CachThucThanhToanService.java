package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.CachThucThanhToan;
import hutech.trancongmanh.quanlyduanxaydung.repository.CachThucThanhToanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CachThucThanhToanService {

    @Autowired
    private CachThucThanhToanRepository cachThucThanhToanRepository;

    public CachThucThanhToan createCachThucThanhToan(CachThucThanhToan cachThucThanhToan) {
        CachThucThanhToan savedCachThucThanhToan = cachThucThanhToanRepository.save(cachThucThanhToan);
        return savedCachThucThanhToan;
    }

    public CachThucThanhToan getCachThucThanhToanById(Long cachThucThanhToanId) {
        Optional<CachThucThanhToan> cachThucThanhToanOptional = cachThucThanhToanRepository.findById(cachThucThanhToanId);
        return cachThucThanhToanOptional.orElse(null);
    }

    public CachThucThanhToan updateCachThucThanhToan(Long cachThucThanhToanId, CachThucThanhToan cachThucThanhToan) {
        Optional<CachThucThanhToan> cachThucThanhToanOptional = cachThucThanhToanRepository.findById(cachThucThanhToanId);
        if (cachThucThanhToanOptional.isPresent()) {
            CachThucThanhToan existingCachThucThanhToan = cachThucThanhToanOptional.get();
            existingCachThucThanhToan.setTenCachThuc(cachThucThanhToan.getTenCachThuc());
            // Update other fields if needed

            CachThucThanhToan updatedCachThucThanhToan = cachThucThanhToanRepository.save(existingCachThucThanhToan);
            return updatedCachThucThanhToan;
        }
        return null;
    }

    public boolean deleteCachThucThanhToan(Long cachThucThanhToanId) {
        if (cachThucThanhToanRepository.existsById(cachThucThanhToanId)) {
            cachThucThanhToanRepository.deleteById(cachThucThanhToanId);
            return true;
        }
        return false;
    }

    public List<CachThucThanhToan> getAllCachThucThanhToan() {
        List<CachThucThanhToan> cachThucThanhToanList = cachThucThanhToanRepository.findAll();
        return cachThucThanhToanList;
    }

    public CachThucThanhToan getDefault() {
        // Lấy một giá trị bất kỳ từ cơ sở dữ liệu
        CachThucThanhToan defaultCachThucThanhToan = cachThucThanhToanRepository.findTopByOrderByIdAsc();

        // Nếu không tìm thấy giá trị, bạn có thể trả về giá trị mặc định khác hoặc báo lỗi
        if (defaultCachThucThanhToan == null) {
            // Bạn có thể báo lỗi hoặc trả về một giá trị mặc định khác tại đây
            throw new RuntimeException("Không có giá trị CachThucThanhToan mặc định.");
        }

        return defaultCachThucThanhToan;
    }
}
