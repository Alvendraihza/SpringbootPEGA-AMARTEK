package com.amartek.restful_demo.controller;


import java.util.List;

import com.amartek.restful_demo.entity.Pelanggan;
import com.amartek.restful_demo.service.PelangganService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("")
public class PelangganController {
    private final PelangganService pelangganServices;

    //Constructor

    public PelangganController(PelangganService pelangganServices) {
        this.pelangganServices = pelangganServices;
    }

    //Get all data pelanggan
    @GetMapping("/allpelanggan")
    public List<Pelanggan> getAllPelanggan() {
        return pelangganServices.getAll();
    }

    //Get data pelanggan by id
    @GetMapping("/pelanggan/{id}")
    public Pelanggan getBukuById(@PathVariable final Long id){
        return pelangganServices.getPelangganById(id);
    }

    //Get data pelanggan by KODEPEL
    @GetMapping("/pelanggan/getby_kode/{kodepelanggan}")
    public List<Pelanggan> getPelangganByKODEPEL(@PathVariable final String kodepelanggan){
        return pelangganServices.getPelangganByKODEPEL(kodepelanggan);
    }

    //Get data pelanggan by NAMA
    @GetMapping("/pelanggan/getby_nama/{nama}")
    public List<Pelanggan> getPelangganByNAMA(@PathVariable final String nama){
        return pelangganServices.getPelangganByNAMA(nama);
    }

    //Get data pelanggan by ALAMAT
    @GetMapping("/pelanggan/getby_alamat/{alamat}")
    public List<Pelanggan> getPelangganByALAMAT(@PathVariable final String alamat){
        return pelangganServices.getPelangganByALAMAT(alamat);
    }

    //Get data pelanggan by TELP
    @GetMapping("/pelanggan/getby_telp/{telepon}")
    public List<Pelanggan> getPelangganByTELP(@PathVariable final String telepon){
        return pelangganServices.getPelangganByTELP(telepon);
    }

    //Get data pelanggan by EMAIL
    @GetMapping("/pelanggan/getby_email/{email}")
    public List<Pelanggan> getPelangganByEMAIL(@PathVariable final String email){
        return pelangganServices.getPelangganByEMAIL(email);
    }

    //Post data pelanggan
    @PostMapping("/create")
	public Pelanggan create(@RequestBody final Pelanggan pelanggan) {
		return pelangganServices.createPelanggan(pelanggan);
	}

    //Edit data pelanggan
    @PutMapping("/edit/{id}")
    public Pelanggan edit(@RequestBody final Pelanggan pelanggan, @PathVariable final Long id){
    	return pelangganServices.editPelanggan(pelanggan, id);
    }

    //Delete data pelanggan
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable final Long id){
        pelangganServices.deletePelanggan(id);
    }

}
