package com.amartek.restful_demo.controller;

import com.amartek.restful_demo.service.BukuService;

import java.util.List;

import com.amartek.restful_demo.entity.Buku;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buku")
public class BukuController {
    private final BukuService bukuServices;

    //Constructor
    public BukuController(BukuService bukuServices) {
        this.bukuServices = bukuServices;
    }

    @GetMapping("/gets")
    public List<Buku> getsBuku() {
        return bukuServices.getAll();
    }
    
    @GetMapping("/get/{judul}")
    public List<Buku> getBukuById(@PathVariable final String judul) {
        return bukuServices.getBukuByJudul(judul);
    }

    @GetMapping("/get_by_penerbit/{penerbit}")
    public List<Buku> getBukuByPenerbit(@PathVariable final String penerbit) {
        return bukuServices.getBukuByPenerbit(penerbit);
    }

    @PostMapping("/create")
    public void createBuku(@RequestBody final Buku buku) {
        bukuServices.createBuku(buku);
    }

    @DeleteMapping("/delete/{IdBuku}")
    public void deleteBuku(@PathVariable final Long IdBuku) {
        bukuServices.deleteBuku(IdBuku);
    }

    @PutMapping("/edit/{IdBuku}")
    public void deleteBuku(@PathVariable final Long IdBuku, @RequestBody final Buku buku) {
        bukuServices.editBuku(IdBuku, buku);
    }
}
