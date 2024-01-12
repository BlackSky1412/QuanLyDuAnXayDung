package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.ChiTietDuAn;
import hutech.trancongmanh.quanlyduanxaydung.entity.ChucVu;
import hutech.trancongmanh.quanlyduanxaydung.repository.CachThucThanhToanRepository;
import hutech.trancongmanh.quanlyduanxaydung.repository.ChiTietDuAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class ChiTietDuAnService {

    @Autowired
    private ChiTietDuAnRepository chiTietDuAnRepository;

    public ChiTietDuAn saveChiTietDuAn(ChiTietDuAn chiTietDuAn) {
        return chiTietDuAnRepository.save(chiTietDuAn);
    }
}


