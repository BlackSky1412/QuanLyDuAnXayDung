package hutech.trancongmanh.quanlyduanxaydung.repository;

import hutech.trancongmanh.quanlyduanxaydung.entity.Anh;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnhRepository extends JpaRepository<Anh, Long> {
    List<Anh> findByChitiettiendoId(Long chiTietTienDoId);
}

