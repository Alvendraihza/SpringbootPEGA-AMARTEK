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

    //Add isEmpty Throw error apabila pencarian Kode pelanggan tidak ditemukan
    public List<Pelanggan> getPelangganByKODEPEL(String kodepelanggan) {
        if(pelangganRepository.findByKODEPELContainsIgnoreCase(kodepelanggan).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "KODE PELANGGAN TIDAK DAPAT DITEMUKAN !");
        }  
            return pelangganRepository.findByKODEPELContainsIgnoreCase(kodepelanggan);
    }

    //Add isEmpty Throw error apabila pencarian Nama pelanggan tidak ditemukan
    public List<Pelanggan> getPelangganByNAMA(String nama) {
        if(pelangganRepository.findByNAMAContainsIgnoreCase(nama).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "NAMA PELANGGAN TIDAK DAPAT DITEMUKAN !");
        }
            return pelangganRepository.findByNAMAContainsIgnoreCase(nama);
    
    }

    //Add isEmpty Throw error apabila pencarian Alamat pelanggan tidak ditemukan
    public List<Pelanggan> getPelangganByALAMAT(String alamat) {
        if(pelangganRepository.findByALAMATContainsIgnoreCase(alamat).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ALAMAT PELANGGAN TIDAK DAPAT DITEMUKAN !");
        }  
            return pelangganRepository.findByALAMATContainsIgnoreCase(alamat);
    }

    //Add isEmpty Throw error apabila pencarian Telepon pelanggan tidak ditemukan
    public List<Pelanggan> getPelangganByTELP(String telepon) {
        if(pelangganRepository.findByTELP(telepon).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "TELEPON PELANGGAN TIDAK DAPAT DITEMUKAN !");
        }  
            return pelangganRepository.findByTELP(telepon);
    }

    //Add isEmpty Throw error apabila pencarian Email pelanggan tidak ditemukan
    public List<Pelanggan> getPelangganByEMAIL(String email) {
        if(pelangganRepository.findByEMAILContainsIgnoreCase(email).isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "EMAIL PELANGGAN TIDAK DAPAT DITEMUKAN !");
        }  
            return pelangganRepository.findByEMAILContainsIgnoreCase(email);
    }

    //CONFLICT apabila ditemukan kesamaan pada data pelanggan berdasarkan Kode Pelanggan
    public Pelanggan createPelanggan(Pelanggan pelanggan) {
        Optional<Pelanggan> pelangganOptional = pelangganRepository.findByKODEPEL(pelanggan.getKODEPEL());
        if (pelangganOptional.isPresent()) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, "TELAH DI TEMUKAN KESAMAAN DATA KODE PELANGGAN !");
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
				HttpStatus.NOT_FOUND, "DATA PELANGGAN DENGAN [ID=" + pelanggan.getID() + "] TIDAK DAPAT DITEMUKAN !");
		}
    }

    public void deletePelanggan(Long id) {
        Optional<Pelanggan> pelangganOptional = pelangganRepository.findById(id);
		
		if (pelangganOptional.isPresent()) {
            pelangganRepository.deleteById(id);
			throw new ResponseStatusException(HttpStatus.OK, "DATA TELAH BERHASIL DIHAPUS !");
		}
		else {
	        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID TIDAK DAPAT DITEMUKAN !");
		}
    }
}
