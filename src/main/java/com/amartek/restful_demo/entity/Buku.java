package com.amartek.restful_demo.entity;

import java.sql.Date;
// import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Buku {
    @Id
    @SequenceGenerator(name = "BUKU_SEQ", allocationSize = 1)                     
    @GeneratedValue(generator = "BUKU_SEQ", strategy = GenerationType.SEQUENCE)    
    private Long ID;

    @Column(nullable = false)
    private String JUDUL;

    @Column(nullable = false)
    private String PENGARANG;
    
    @Column(nullable = false)
    private Date TGLTERBIT;
    
    @Column(nullable = false)
    private String PENERBIT;
    
    @Column(nullable = false)
    private String ISBN;
    
    private Long USERID;

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getJUDUL() {
        return this.JUDUL;
    }

    public void setJUDUL(String JUDUL) {
        this.JUDUL = JUDUL;
    }

    public String getPENGARANG() {
        return this.PENGARANG;
    }

    public void setPENGARANG(String PENGARANG) {
        this.PENGARANG = PENGARANG;
    }

    public Date getTGLTERBIT() {
        return this.TGLTERBIT;
    }

    public void setTGLTERBIT(Date TGLTERBIT) {
        this.TGLTERBIT = TGLTERBIT;
    }

    public String getPENERBIT() {
        return this.PENERBIT;
    }

    public void setPENERBIT(String PENERBIT) {
        this.PENERBIT = PENERBIT;
    }

    public String getISBN() {
        return this.ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public Long getUSERID() {
        return this.USERID;
    }

    public void setUSERID(Long USERID) {
        this.USERID = USERID;
    }


}
