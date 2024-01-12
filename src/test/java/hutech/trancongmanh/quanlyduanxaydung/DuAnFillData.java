/*
package hutech.trancongmanh.quanlyduanxaydung;

import hutech.trancongmanh.quanlyduanxaydung.entity.CachThucThanhToan;
import hutech.trancongmanh.quanlyduanxaydung.entity.KhachHang;
import hutech.trancongmanh.quanlyduanxaydung.entity.TrangThai;
import hutech.trancongmanh.quanlyduanxaydung.repository.CachThucThanhToanRepository;
import hutech.trancongmanh.quanlyduanxaydung.repository.DuAnRepository;
import hutech.trancongmanh.quanlyduanxaydung.repository.KhachHangRepository;
import hutech.trancongmanh.quanlyduanxaydung.repository.TrangThaiRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import hutech.trancongmanh.quanlyduanxaydung.entity.DuAn;
import org.springframework.context.annotation.ComponentScan;
import java.util.Date;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
@ComponentScan("hutech.trancongmanh.quanlyduanxaydung")
public class DuAnFillData {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private DuAnRepository duAnRepository;
    @Autowired
    private KhachHangRepository khachHangRepository;
    @Autowired
    private CachThucThanhToanRepository cachThucThanhToanRepository;
    @Autowired
    private TrangThaiRepository trangThaiRepository;

    @Test
    public void testCreateDuAn() {
        DuAn duAn1 = new DuAn();
        duAn1.setTenDuAn("Dự án A");
        duAn1.setDiaChi("Địa chỉ A");
        duAn1.setNgayKy(new Date());
        duAn1.setNgayKhoiCong(new Date());
        duAn1.setNgayHoanThanhDuKien(new Date());
        duAn1.setChiPhiUocTinh(1000000L);
        duAn1.setChiPhiThucTe(900000L);
        duAn1.setGiayPhepXayDung("GPXD-001");
        duAn1.setBanThietKe("Ban thiet ke A");

        CachThucThanhToan cachThucThanhToan1 = cachThucThanhToanRepository.findById(1L).orElseGet(() -> {
            CachThucThanhToan newCachThucThanhToan = new CachThucThanhToan();
            // Set the name for the new payment method if needed
            newCachThucThanhToan.setTenCachThuc("Cach Thuc Thanh Toan A");
            return cachThucThanhToanRepository.save(newCachThucThanhToan);
        });
        duAn1.setCachthucthanhtoan(cachThucThanhToan1);


        KhachHang khachHang1 = khachHangRepository.findById(1L).orElseGet(() -> {
            KhachHang newKhachHang = new KhachHang();
            newKhachHang.setTenKhachHang("Khach Hang A");
            return khachHangRepository.save(newKhachHang);
        });
        duAn1.setKhachhang(khachHang1);

        TrangThai trangThai1 = trangThaiRepository.findById(1L).orElseGet(() -> {
            TrangThai newTrangThai = new TrangThai();
            newTrangThai.setTenTrangThai("Trang Thai A");
            return trangThaiRepository.save(newTrangThai);
        });
        duAn1.setTrangthai(trangThai1);

        entityManager.persist(duAn1);

        DuAn duAn2 = new DuAn();
        duAn2.setTenDuAn("Dự án B");
        duAn2.setDiaChi("Địa chỉ B");
        duAn2.setNgayKy(new Date());
        duAn2.setNgayKhoiCong(new Date());
        duAn2.setNgayHoanThanhDuKien(new Date());
        duAn2.setChiPhiUocTinh(1200000L);
        duAn2.setChiPhiThucTe(1100000L);
        duAn2.setGiayPhepXayDung("GPXD-002");
        duAn2.setBanThietKe("Ban thiet ke B");

        CachThucThanhToan cachThucThanhToan2 = cachThucThanhToanRepository.findById(2L).orElseGet(() -> {
            CachThucThanhToan newCachThucThanhToan = new CachThucThanhToan();
            newCachThucThanhToan.setTenCachThuc("Cach Thuc Thanh Toan B");
            return cachThucThanhToanRepository.save(newCachThucThanhToan);
        });
        duAn2.setCachthucthanhtoan(cachThucThanhToan2);

        KhachHang khachHang2 = khachHangRepository.findById(2L).orElseGet(() -> {
            KhachHang newKhachHang = new KhachHang();
            newKhachHang.setTenKhachHang("Khach Hang B");
            return khachHangRepository.save(newKhachHang);
        });
        duAn2.setKhachhang(khachHang2);

        TrangThai trangThai2 = trangThaiRepository.findById(2L).orElseGet(() -> {
            TrangThai newTrangThai = new TrangThai();
            newTrangThai.setTenTrangThai("Trang Thai B");
            return trangThaiRepository.save(newTrangThai);
        });
        duAn2.setTrangthai(trangThai2);

        entityManager.persist(duAn2);
    }
}

*/
