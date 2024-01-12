package hutech.trancongmanh.quanlyduanxaydung.repository;


import hutech.trancongmanh.quanlyduanxaydung.entity.DangGiaoDich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DangGiaoDichRepository extends JpaRepository<DangGiaoDich, Long> {

}