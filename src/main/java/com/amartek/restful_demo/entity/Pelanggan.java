package com.amartek.restful_demo.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Pelanggan {
    @Id
    @SequenceGenerator(name = "PELANGGAN_SEQ", allocationSize = 1)                     
    @GeneratedValue(generator = "PELANGGAN_SEQ", strategy = GenerationType.SEQUENCE)    
    private Long ID;

    @Column(nullable = false)
    private String KODEPEL;

    @Column(nullable = false)
    private String ALAMAT;
    
    @Column(nullable = false)
    private String TELP;
    
    @Column(nullable = false)
    private String JK;
    
    @Column(nullable = false)
    private String NAMA;

    @Column(nullable = false)
    private String EMAIL;

    public Long getID() {
        return this.ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getKODEPEL() {
        return this.KODEPEL;
    }

    public void setKODEPEL(String KODEPEL) {
        this.KODEPEL = KODEPEL;
    }

    public String getALAMAT() {
        return this.ALAMAT;
    }

    public void setALAMAT(String ALAMAT) {
        this.ALAMAT = ALAMAT;
    }

    public String getTELP() {
        return this.TELP;
    }

    public void setTELP(String TELP) {
        this.TELP = TELP;
    }


    public String getJK() {
        return this.JK;
    }

    public void setJK(String JK) {
        this.JK = JK;
    }

    public String getNAMA() {
        return this.NAMA;
    }

    public void setNAMA(String NAMA) {
        this.NAMA = NAMA;
    }

    public String getEMAIL() {
        return this.EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }


}
