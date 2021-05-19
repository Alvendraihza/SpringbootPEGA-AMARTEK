package com.amartek.restful_demo.controller;

import com.amartek.restful_demo.service.BukuService;

import java.util.List;

// import javax.persistence.Id;

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
    public BukuController(BukuService bukuServices) {
        this.bukuServices = bukuServices;
    }

    @GetMapping("/gets")
    public List<Buku> getAllBuku() {
        return bukuServices.getAll();
    }

    @GetMapping("/getsid/{id}")
    public Buku getBukuById(@PathVariable final Long id){
        return bukuServices.getBukuById(id);
    }
    @GetMapping("/getsjudul/{judul}")
    public List<Buku> getBukuByJUDUL(@PathVariable final String judul){
        return bukuServices.getBukuByJUDUL(judul);
    }

    @GetMapping("/getspenerbit/{penerbit}")
    public List<Buku> getBukuByPENERBIT(@PathVariable final String penerbit){
        return bukuServices.getBukuByPENERBIT(penerbit);
    }

    @PostMapping("/create")
	public Buku create(@RequestBody final Buku buku) {
		return bukuServices.createBuku(buku);
	}

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable final Long id){
        bukuServices.deleteBuku(id);
    }

    @PutMapping("/edit/{id}")
    public Buku edit(@RequestBody final Buku buku, @PathVariable final Long id){
    	return bukuServices.editPost(buku, id);
    }

}
