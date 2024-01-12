package hutech.trancongmanh.quanlyduanxaydung.repository;

import hutech.trancongmanh.quanlyduanxaydung.entity.DuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DuAnRepository extends JpaRepository<DuAn, Long> {
    // You can add custom query methods if needed
    @Query("SELECT d FROM DuAn d WHERE d.khachhang.id = :khachHangId")
    List<DuAn> findByKhachHang_Id(Long khachHangId);

    @Query("SELECT DISTINCT d.duan FROM ChiTietDuAn d WHERE d.nhathau.id = :nhaThauId")
    List<DuAn> findByNhaThau_Id(Long nhaThauId);

}

