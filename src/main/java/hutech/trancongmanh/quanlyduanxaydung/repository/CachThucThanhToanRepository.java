package hutech.trancongmanh.quanlyduanxaydung.repository;

import hutech.trancongmanh.quanlyduanxaydung.entity.CachThucThanhToan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CachThucThanhToanRepository extends JpaRepository<CachThucThanhToan, Long> {
    CachThucThanhToan findTopByOrderByIdAsc();
}
