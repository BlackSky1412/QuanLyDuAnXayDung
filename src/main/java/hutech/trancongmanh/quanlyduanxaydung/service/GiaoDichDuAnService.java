package hutech.trancongmanh.quanlyduanxaydung.service;


import hutech.trancongmanh.quanlyduanxaydung.entity.BacKhachHang;
import hutech.trancongmanh.quanlyduanxaydung.entity.ChucVu;
import hutech.trancongmanh.quanlyduanxaydung.entity.DangGiaoDich;
import hutech.trancongmanh.quanlyduanxaydung.entity.QuanLyGiaoDichDuAn;
import hutech.trancongmanh.quanlyduanxaydung.repository.ChucVuRepository;
import hutech.trancongmanh.quanlyduanxaydung.repository.GiaoDichDuAnRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class GiaoDichDuAnService {

    @Autowired
    private GiaoDichDuAnRepository giaoDichDuAnRepository;
    public List<QuanLyGiaoDichDuAn> getAllGiaoDich() {
        return giaoDichDuAnRepository.findAll();
    }

    public List<QuanLyGiaoDichDuAn> getGiaoDichByKhachHangId(Long khachHangId) {
        return giaoDichDuAnRepository.findByKhachHang_Id(khachHangId);
    }


    public QuanLyGiaoDichDuAn saveGiaoDichDuAn(QuanLyGiaoDichDuAn giaodichduan) {
        return giaoDichDuAnRepository.save(giaodichduan);
    }
}
