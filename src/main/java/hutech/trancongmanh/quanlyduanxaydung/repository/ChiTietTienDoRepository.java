package hutech.trancongmanh.quanlyduanxaydung.repository;


import hutech.trancongmanh.quanlyduanxaydung.entity.ChiTietTienDo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChiTietTienDoRepository extends JpaRepository<ChiTietTienDo, Long> {

}