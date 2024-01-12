package hutech.trancongmanh.quanlyduanxaydung.repository;

import hutech.trancongmanh.quanlyduanxaydung.entity.BangTheoDoiTienDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BangTheoDoiTienDoRepository extends JpaRepository<BangTheoDoiTienDo, Long> {}