/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author Adbang 18
 */
public class Buku {

    private String judul;
    private String kategori;
    private int lantai;
    private int rak;
    private int posisi;

    public Buku(String judul, String kategori, int lantai, int rak, int posisi) {
        this.judul = judul;
        this.kategori = kategori;
        this.lantai = lantai;
        this.rak = rak;
        this.posisi = posisi;
    }

    public String getJudul() {
        return judul;
    }

    public String getKategori() {
        return kategori;
    }

    public int getLantai() {
        return lantai;
    }

    public int getRak() {
        return rak;
    }

    public int getPosisi() {
        return posisi;
    }
}