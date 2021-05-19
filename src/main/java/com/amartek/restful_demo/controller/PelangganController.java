package com.amartek.restful_demo.controller;


import java.util.List;

import com.amartek.restful_demo.entity.Pelanggan;
import com.amartek.restful_demo.service.PelangganService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class PelangganController {
    private final PelangganService pelangganServices;
    public PelangganController(PelangganService pelangganServices) {
        this.pelangganServices = pelangganServices;
    }

    @GetMapping("/pelanggan")
    public List<Pelanggan> getAllPelanggan() {
        return pelangganServices.getAll();
    }

    @GetMapping("/pelanggan/{id}")
    public Pelanggan getBukuById(@PathVariable final Long id){
        return pelangganServices.getPelangganById(id);
    }

    @GetMapping("/pelanggan/bykode/{kodepel}")
    public List<Pelanggan> getPelangganByKODEPEL(@PathVariable final String kodepel){
        return pelangganServices.getPelangganByKODEPEL(kodepel);
    }

    @GetMapping("/pelanggan/bynama/{nama}")
    public List<Pelanggan> getPelangganByNAMA(@PathVariable final String nama){
        return pelangganServices.getPelangganByNAMA(nama);
    }

    @PostMapping("pelanggan/create")
	public Pelanggan create(@RequestBody final Pelanggan pelanggan) {
		return pelangganServices.createPelanggan(pelanggan);
	}

    @PutMapping("/pelanggan/{id}")
    public Pelanggan edit(@RequestBody final Pelanggan pelanggan, @PathVariable final Long id){
    	return pelangganServices.editPelanggan(pelanggan, id);
    }

    @DeleteMapping("/pelanggan/{id}")
    public void delete(@PathVariable final Long id){
        pelangganServices.deletePelanggan(id);
    }

    

    // @GetMapping("/getspenerbit/{penerbit}")
    // public List<Buku> getBukuByPENERBIT(@PathVariable final String penerbit){
    //     return bukuServices.getBukuByPENERBIT(penerbit);
    // }

    // @PostMapping("/create")
	// public Buku create(@RequestBody final Buku buku) {
	// 	return bukuServices.createBuku(buku);
	// }





}
