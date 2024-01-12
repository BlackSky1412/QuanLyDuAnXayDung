package hutech.trancongmanh.quanlyduanxaydung.repository;

import hutech.trancongmanh.quanlyduanxaydung.entity.KhachHang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface KhachHangRepository extends JpaRepository<KhachHang, Long> {
}
