package hutech.trancongmanh.quanlyduanxaydung.repository;

import hutech.trancongmanh.quanlyduanxaydung.entity.NhaCungCapVatTu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NhaCungCapVatTuRepository extends JpaRepository<NhaCungCapVatTu, Long> {}