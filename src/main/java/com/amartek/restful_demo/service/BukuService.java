package com.amartek.restful_demo.service;

import java.util.List;
import java.util.Optional;

import com.amartek.restful_demo.entity.Buku;
import com.amartek.restful_demo.repository.BukuRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BukuService {
    @Autowired
    private BukuRepository bukuRepository;

    public List<Buku> getAll() {
        return bukuRepository.findAll();
    }

    public Buku getBukuById(Long id) {
        return bukuRepository.findById(id).get();
    }

    public List<Buku> getBukuByJUDUL(String judul) {
        return bukuRepository.findByJUDULContainsIgnoreCase(judul);
    }

    public List<Buku> getBukuByPENERBIT(String penerbit) {
        return bukuRepository.findByPENERBITContainsIgnoreCase(penerbit);
    }

    public Buku createBuku(Buku buku) {
        Optional<Buku> bukuOptional = bukuRepository.findByJUDUL(buku.getJUDUL());
		
		if (bukuOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "JUDUL SAMA");
		}
		else {
	        bukuRepository.save(buku);
	        throw new ResponseStatusException(HttpStatus.OK, "Buku berhasil ditambahkan!");
		}
    }

    public void deleteBuku(Long IdBuku) {
        Optional<Buku> bukuOptional = bukuRepository.findById(IdBuku);
		
		if (bukuOptional.isPresent()) {
            bukuRepository.deleteById(IdBuku);
			throw new ResponseStatusException(HttpStatus.OK, "Berhasil dihapus");
		}
		else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID tidak ada");
		}
    }

    public Buku editPost(Buku buku, Long id) {
        Optional<Buku> postOptional = bukuRepository.findById(id);
		
		if (postOptional.isPresent()) {
			bukuRepository.save(buku);
			throw new ResponseStatusException(
				HttpStatus.OK, "Sukses Edit Buku"
			);
		}
		else {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "Post [id=" + buku.getID() + "] tidak ditemukan");
		}
    }
    
}
