package com.amartek.restful_demo.repository;

import java.util.List;
import java.util.Optional;

import com.amartek.restful_demo.entity.Buku;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BukuRepository extends JpaRepository<Buku, Long> {
    List<Buku> findByJUDULContainsIgnoreCase(String judul);

    List<Buku> findByPENERBITContainsIgnoreCase(String penerbit);

    Optional<Buku> findByISBN(String ISBN);
}
