package hutech.trancongmanh.quanlyduanxaydung.repository;


import hutech.trancongmanh.quanlyduanxaydung.entity.ChiTietDuAn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietDuAnRepository extends JpaRepository<ChiTietDuAn, Long> {

}