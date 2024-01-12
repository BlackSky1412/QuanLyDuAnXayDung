package hutech.trancongmanh.quanlyduanxaydung.repository;

import hutech.trancongmanh.quanlyduanxaydung.entity.TrangThai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface TrangThaiRepository extends JpaRepository<TrangThai, Long> {

}
