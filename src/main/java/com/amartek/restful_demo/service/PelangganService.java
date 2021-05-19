package com.amartek.restful_demo.service;

import java.util.List;
import java.util.Optional;

import com.amartek.restful_demo.entity.Pelanggan;
import com.amartek.restful_demo.repository.PelangganRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PelangganService {
    @Autowired
    private PelangganRepository pelangganRepository;

    public List<Pelanggan> getAll() {
        return pelangganRepository.findAll();
    }

    public Pelanggan getPelangganById(Long id) {
        return pelangganRepository.findById(id).get();
    }

    public List<Pelanggan> getPelangganByKODEPEL(String kodepel) {
        return pelangganRepository.findByKODEPELContainsIgnoreCase(kodepel);
    }

    public List<Pelanggan> getPelangganByNAMA(String nama) {
        return pelangganRepository.findByNAMAContainsIgnoreCase(nama);
    }

    public Pelanggan createPelanggan(Pelanggan pelanggan) {
        Optional<Pelanggan> pelangganOptional = pelangganRepository.findByKODEPEL(pelanggan.getKODEPEL());
        if (pelangganOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "TELAH DI TEMUKAN KESAMAAN DATA PELANGGAN !");
		}
		else {
	        pelangganRepository.save(pelanggan);
	        throw new ResponseStatusException(HttpStatus.OK, "DATA PELANGGAN TELAH BERHASIL DITAMBAHKAN !");
		}
    }

    public Pelanggan editPelanggan(Pelanggan pelanggan, Long id) {
        Optional<Pelanggan> postOptional = pelangganRepository.findById(id);
		
		if (postOptional.isPresent()) {
			pelangganRepository.save(pelanggan);
			throw new ResponseStatusException(
				HttpStatus.OK, "DATA PELANGGAN TELAH BERHASIL DI EDIT !"
			);
		}
		else {
			throw new ResponseStatusException(
				HttpStatus.NOT_FOUND, "DATA PELANGGAN DENGAN [ID=" + pelanggan.getID() + "] TIDAK DITEMUKAN !");
		}
    }

    public void deletePelanggan(Long id) {
        Optional<Pelanggan> pelangganOptional = pelangganRepository.findById(id);
		
		if (pelangganOptional.isPresent()) {
            pelangganRepository.deleteById(id);
			throw new ResponseStatusException(HttpStatus.OK, "DATA BERHASIL DIHAPUS !");
		}
		else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID TIDAK DITEMUKAN !");
		}
    }
}
