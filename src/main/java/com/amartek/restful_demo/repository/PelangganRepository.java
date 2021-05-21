package com.amartek.restful_demo.repository;

import java.util.List;
import java.util.Optional;

import com.amartek.restful_demo.entity.Pelanggan;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PelangganRepository extends JpaRepository<Pelanggan, Long> {

    //Repo List
    List<Pelanggan> findByKODEPELContainsIgnoreCase(String kodepelanggan);
    List<Pelanggan> findByNAMAContainsIgnoreCase(String nama);
    List<Pelanggan> findByALAMATContainsIgnoreCase(String alamat);
    List<Pelanggan> findByTELP(String telepon);
    List<Pelanggan> findByEMAILContainsIgnoreCase(String email);

    //Repo Optional
    Optional<Pelanggan> findByKODEPEL(String kodepel);
}