package hutech.trancongmanh.quanlyduanxaydung.service;

import hutech.trancongmanh.quanlyduanxaydung.entity.Anh;
import hutech.trancongmanh.quanlyduanxaydung.repository.AnhRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnhService {

    private final AnhRepository anhRepository;

    @Autowired
    public AnhService(AnhRepository anhRepository) {
        this.anhRepository = anhRepository;
    }

    public List<Anh> getAllImages() {
        return anhRepository.findAll();
    }

    public Optional<Anh> getImageById(Long id) {
        return anhRepository.findById(id);
    }

    public List<Anh> getImagesByChiTietTienDoId(Long chiTietTienDoId) {
        return anhRepository.findByChitiettiendoId(chiTietTienDoId);
    }

    public void saveImage(Anh anh) {
        anhRepository.save(anh);
    }

    public void deleteImage(Long id) {
        anhRepository.deleteById(id);
    }
}
