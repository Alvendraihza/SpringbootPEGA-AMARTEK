package com.amartek.restful_demo.repository;

import java.util.List;
// import java.util.Optional;
import java.util.Optional;

// import com.amartek.restful_demo.entity.Buku;
import com.amartek.restful_demo.entity.Pelanggan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {

    List<Pelanggan> findByKODEPELContainsIgnoreCase(String kodepel);

    List<Pelanggan> findByNAMAContainsIgnoreCase(String nama);

    Optional<Pelanggan> findByKODEPEL(String kodepel);
    
}