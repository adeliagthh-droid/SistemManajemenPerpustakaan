/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package main;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Adbang 18
 */
public class Main {

    static Scanner scanner = new Scanner(System.in);

    static String[] kategoriBuku = {"Pemrograman", "Matematika", "Jaringan Komputer", "Basis Data"};

    static int[][] dataPeminjaman = {
        {5, 8, 3, 6, 9, 4},
        {2, 3, 4, 1, 5, 2},
        {4, 6, 5, 7, 8, 3},
        {7, 5, 6, 8, 9, 6}
    };

    static String[] hari = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};

    static final int JUMLAH_LANTAI = 2;
    static final int JUMLAH_RAK = 3;
    static final int JUMLAH_POSISI = 4;

    static String[][][] lokasiBuku = new String[JUMLAH_LANTAI][JUMLAH_RAK][JUMLAH_POSISI];

    static ArrayList<Buku> daftarBuku = new ArrayList<>();

    public static void main(String[] args) {
        for (int l = 0; l < JUMLAH_LANTAI; l++) {
            for (int r = 0; r < JUMLAH_RAK; r++) {
                for (int p = 0; p < JUMLAH_POSISI; p++) {
                    lokasiBuku[l][r][p] = "Kosong";
                }
            }
        }

        boolean jalan = true;
        while (jalan) {
            System.out.println("\n=== SISTEM MANAJEMEN PERPUSTAKAAN KAMPUS ===");
            System.out.println("--- Anggota 1: Kategori & Peminjaman ---");
            System.out.println("1. Tampilkan Kategori Buku (Array 1D)");
            System.out.println("2. Tampilkan Data Peminjaman (Array 2D)");
            System.out.println("--- Anggota 2: Lokasi & Daftar Buku ---");
            System.out.println("3. Tambah Buku (ArrayList + Array 3D)");
            System.out.println("4. Tampilkan Daftar Buku (ArrayList)");
            System.out.println("5. Hapus Buku (ArrayList + Array 3D)");
            System.out.println("6. Tampilkan Denah Lokasi Penyimpanan (Array 3D)");
            System.out.println("7. Keluar");
            int pilihan = bacaAngka("Pilih menu (1-7): ");

            switch (pilihan) {
                case 1:
                    tampilkanKategori();
                    break;
                case 2:
                    tampilkanPeminjaman();
                    break;
                case 3:
                    tambahBuku();
                    break;
                case 4:
                    tampilkanDaftarBuku();
                    break;
                case 5:
                    hapusBuku();
                    break;
                case 6:
                    tampilkanLokasi();
                    break;
                case 7:
                    jalan = false;
                    System.out.println("Terima kasih. Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        scanner.close();
    }

    static int bacaAngka(String pesan) {
        while (true) {
            System.out.print(pesan);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");
            }
        }
    }

    static void tampilkanKategori() {
        System.out.println("\n[ Daftar Kategori Buku ]");
        for (int i = 0; i < kategoriBuku.length; i++) {
            System.out.println((i + 1) + ". " + kategoriBuku[i]);
        }
    }

    static void tampilkanPeminjaman() {
        System.out.println("\n[ Data Jumlah Peminjaman Buku per Kategori & Hari ]");
        System.out.print(String.format("%-20s", "Kategori"));
        for (String h : hari) {
            System.out.print(String.format("%-10s", h));
        }
        System.out.println();

        for (int i = 0; i < kategoriBuku.length; i++) {
            System.out.print(String.format("%-20s", kategoriBuku[i]));
            for (int j = 0; j < hari.length; j++) {
                System.out.print(String.format("%-10d", dataPeminjaman[i][j]));
            }
            System.out.println();
        }
    }

    static void tambahBuku() {
        System.out.println("\n[ Tambah Buku ]");
        System.out.print("Judul buku: ");
        String judul = scanner.nextLine().trim();
        if (judul.isEmpty()) {
            System.out.println("Judul tidak boleh kosong!");
            return;
        }

        System.out.println("Pilih kategori:");
        for (int i = 0; i < kategoriBuku.length; i++) {
            System.out.println((i + 1) + ". " + kategoriBuku[i]);
        }
        int k = bacaAngka("Nomor kategori: ");
        if (k < 1 || k > kategoriBuku.length) {
            System.out.println("Kategori tidak valid!");
            return;
        }

        int lantai = bacaAngka("Lantai (1-" + JUMLAH_LANTAI + "): ");
        int rak = bacaAngka("Nomor rak (1-" + JUMLAH_RAK + "): ");
        int posisi = bacaAngka("Posisi (1-" + JUMLAH_POSISI + "): ");

        if (lantai < 1 || lantai > JUMLAH_LANTAI || rak < 1 || rak > JUMLAH_RAK
                || posisi < 1 || posisi > JUMLAH_POSISI) {
            System.out.println("Lokasi di luar jangkauan rak!");
            return;
        }

        if (!lokasiBuku[lantai - 1][rak - 1][posisi - 1].equals("Kosong")) {
            System.out.println("Posisi sudah terisi buku: " + lokasiBuku[lantai - 1][rak - 1][posisi - 1]);
            return;
        }

        daftarBuku.add(new Buku(judul, kategoriBuku[k - 1], lantai, rak, posisi));
        lokasiBuku[lantai - 1][rak - 1][posisi - 1] = judul;
        System.out.println("Buku \"" + judul + "\" berhasil ditambahkan.");
    }

    static void tampilkanDaftarBuku() {
        System.out.println("\n[ Daftar Buku ]");
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada buku.");
            return;
        }
        System.out.println(String.format("%-4s%-30s%-20s%s", "No", "Judul", "Kategori", "Lokasi"));
        for (int i = 0; i < daftarBuku.size(); i++) {
            Buku b = daftarBuku.get(i);
            System.out.println(String.format("%-4d%-30s%-20sLt.%d Rak %d Pos %d",
                    (i + 1), b.getJudul(), b.getKategori(), b.getLantai(), b.getRak(), b.getPosisi()));
        }
        System.out.println("Total buku: " + daftarBuku.size());
    }

    static void hapusBuku() {
        System.out.println("\n[ Hapus Buku ]");
        if (daftarBuku.isEmpty()) {
            System.out.println("Belum ada buku yang bisa dihapus.");
            return;
        }
        tampilkanDaftarBuku();
        int nomor = bacaAngka("Nomor buku yang dihapus: ");
        if (nomor < 1 || nomor > daftarBuku.size()) {
            System.out.println("Nomor buku tidak valid!");
            return;
        }

        Buku dihapus = daftarBuku.remove(nomor - 1);
        lokasiBuku[dihapus.getLantai() - 1][dihapus.getRak() - 1][dihapus.getPosisi() - 1] = "Kosong";
        System.out.println("Buku \"" + dihapus.getJudul() + "\" berhasil dihapus dan posisinya dikosongkan.");
    }

    static void tampilkanLokasi() {
        System.out.println("\n[ Denah Lokasi Penyimpanan Buku ]");
        for (int l = 0; l < JUMLAH_LANTAI; l++) {
            System.out.println("== Lantai " + (l + 1) + " ==");
            for (int r = 0; r < JUMLAH_RAK; r++) {
                System.out.println("  Rak " + (r + 1) + ":");
                for (int p = 0; p < JUMLAH_POSISI; p++) {
                    System.out.println("    Posisi " + (p + 1) + ": " + lokasiBuku[l][r][p]);
                }
            }
        }
    }
}