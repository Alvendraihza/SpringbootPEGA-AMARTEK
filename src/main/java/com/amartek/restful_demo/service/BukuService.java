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

    public List<Buku> getBukuByJudul(String judul) {
        return bukuRepository.findByJUDULContainsIgnoreCase(judul);
    }

    public List<Buku> getBukuByPenerbit(String penerbit) {
        return bukuRepository.findByPENERBITContainsIgnoreCase(penerbit);
    }

    public void createBuku(Buku buku) {
        Optional<Buku> bukuOptional = bukuRepository.findByISBN(buku.getISBN());

        if (bukuOptional.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "A book with same ISBN number is present!");
        }
        else {
            bukuRepository.save(buku);
            throw new ResponseStatusException(HttpStatus.OK, "Book data successfully saved!");
        }
    }

    public void deleteBuku(Long IdBuku) {
        Optional<Buku> bukuOptional = bukuRepository.findById(IdBuku);

        if(bukuOptional.isPresent()) {
            bukuRepository.deleteById(IdBuku);
            throw new ResponseStatusException(HttpStatus.OK, "Book has successfully been Deleted!");
        }
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book is not available!");
    }

    public void editBuku(Long IdBuku, Buku buku) {
        Optional<Buku> bukuOptional = bukuRepository.findById(IdBuku);

        if(bukuOptional.isPresent()) {
            bukuRepository.save(buku);
            throw new ResponseStatusException(HttpStatus.OK, "Book has successfully been Updated!");
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Book is not available!");
        }
    }
}
