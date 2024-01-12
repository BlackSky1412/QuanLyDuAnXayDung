package hutech.trancongmanh.quanlyduanxaydung.repository;

import hutech.trancongmanh.quanlyduanxaydung.entity.QuanLyGiaoDichDuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GiaoDichDuAnRepository extends JpaRepository<QuanLyGiaoDichDuAn, Long> {

    @Query("SELECT g FROM QuanLyGiaoDichDuAn g JOIN g.duan d JOIN d.khachhang k WHERE k.id = :khachHangId")
    List<QuanLyGiaoDichDuAn> findByKhachHang_Id(Long khachHangId);
}