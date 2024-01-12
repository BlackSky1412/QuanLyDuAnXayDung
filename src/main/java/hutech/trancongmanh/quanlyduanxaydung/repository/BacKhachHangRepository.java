package hutech.trancongmanh.quanlyduanxaydung.repository;

import org.springframework.stereotype.Repository;
import hutech.trancongmanh.quanlyduanxaydung.entity.BacKhachHang;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface BacKhachHangRepository extends JpaRepository<BacKhachHang, Long> {

}