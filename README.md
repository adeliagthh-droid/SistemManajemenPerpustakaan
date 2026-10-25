# Sistem Manajemen Perpustakaan Kampus

## Implementasi dan Pembahasan Stack dan Queue

## 1. Deskripsi Fitur

Pada bagian ini, fokus utama pengembangan adalah mengimplementasikan struktur data **Stack** dan **Queue** ke dalam sistem manajemen perpustakaan berbasis Java.

- **Stack** digunakan untuk menyimpan riwayat transaksi dengan prinsip **LIFO (Last In, First Out)**, yaitu transaksi yang terakhir dimasukkan akan menjadi transaksi pertama yang ditampilkan atau dihapus.
- **Queue** digunakan untuk mengelola antrean mahasiswa dengan prinsip **FIFO (First In, First Out)**, yaitu mahasiswa yang pertama masuk ke antrean akan menjadi mahasiswa pertama yang diproses.

Kedua struktur data tersebut diintegrasikan ke dalam menu utama program sehingga pengguna dapat memilih fitur riwayat transaksi maupun antrean mahasiswa.

> **Catatan:** Riwayat transaksi dan antrean mahasiswa disimpan sementara selama program berjalan. Data akan hilang ketika program dihentikan karena belum menggunakan penyimpanan permanen seperti database.

---

## 2. Penjelasan Source Code Baris demi Baris

Berikut adalah penjelasan bagian-bagian kode program yang diimplementasikan pada bagian **Anggota 3** dalam file `Main.java`.

### A. Import Library dan Deklarasi Stack dan Queue

| Kode | Penjelasan |
|------|------------|
| `import java.util.Stack;` | Mengimpor class Stack dari pustaka Java agar dapat digunakan untuk menyimpan dan mengelola riwayat transaksi menggunakan prinsip LIFO. |
| `import java.util.Queue;` | Mengimpor interface Queue yang digunakan untuk mendefinisikan struktur data antrean mahasiswa. |
| `import java.util.LinkedList;` | Mengimpor class LinkedList yang digunakan sebagai implementasi dari interface Queue. |
| `static Stack<String> riwayatTransaksi = new Stack<>();` | Membuat objek Stack bernama `riwayatTransaksi` yang menyimpan data transaksi dalam bentuk teks (String). Objek ini dapat digunakan oleh method dalam class utama. |
| `static Queue<String> antreanMahasiswa = new LinkedList<>();` | Membuat objek Queue bernama `antreanMahasiswa` dengan implementasi LinkedList. Struktur data ini digunakan untuk menyimpan nama mahasiswa berdasarkan urutan kedatangan. |

### B. Menu Anggota 3 pada Class Utama

| Kode | Penjelasan |
|------|------------|
| `System.out.println("--- Anggota 3: Riwayat Transaksi & Antrean Mahasiswa ---");` | Menampilkan judul bagian menu yang berisi fitur Stack dan Queue milik Anggota 3. |
| `System.out.println("7. Riwayat Transaksi (Stack)");` | Menampilkan pilihan menu untuk mengelola riwayat transaksi. |
| `System.out.println("8. Antrean Mahasiswa (Queue)");` | Menampilkan pilihan menu untuk mengelola antrean mahasiswa. |
| `System.out.println("9. Keluar");` | Menampilkan pilihan untuk menghentikan program. |
| `case 7:` | Memanggil method menu Stack ketika pengguna memilih angka 7. |
| `case 8:` | Memanggil method menu Queue ketika pengguna memilih angka 8. |
| `case 9:` | Menjalankan proses keluar dari program. |

### C. Menu Riwayat Transaksi (Stack)

Menu riwayat transaksi digunakan untuk menjalankan operasi penambahan, penampilan, dan penghapusan transaksi terakhir.

Method menu Stack menampilkan pilihan untuk menambahkan transaksi, melihat transaksi terakhir, membatalkan transaksi terakhir, melihat seluruh riwayat, dan kembali ke menu utama.

| Operasi | Penjelasan |
|---------|------------|
| `push(transaksi)` | Menambahkan transaksi baru ke bagian paling atas Stack. Transaksi yang baru dimasukkan menjadi transaksi terakhir. |
| `peek()` | Mengambil atau menampilkan transaksi yang berada di bagian paling atas Stack tanpa menghapusnya. Jika Stack kosong, program menampilkan informasi bahwa belum ada transaksi. |
| `pop()` | Menghapus dan mengembalikan transaksi yang berada di bagian paling atas Stack. Operasi ini digunakan pada fitur pembatalan transaksi terakhir. |
| `isEmpty()` | Memeriksa apakah Stack kosong sebelum transaksi ditampilkan atau dihapus. Pemeriksaan ini membantu mencegah kesalahan ketika tidak ada data. |

Perulangan dari indeks terakhir menuju indeks pertama digunakan untuk menampilkan riwayat transaksi dari yang terbaru hingga yang terlama.

### D. Fitur Tambah Transaksi

| Kode | Penjelasan |
|------|------------|
| `String transaksi = scanner.nextLine().trim();` | Membaca deskripsi transaksi yang dimasukkan pengguna dan menghapus spasi di awal maupun akhir teks. |
| `transaksi.isEmpty()` | Memeriksa apakah pengguna memasukkan teks kosong. Jika kosong, transaksi tidak ditambahkan. |
| `riwayatTransaksi.push(transaksi);` | Memasukkan deskripsi transaksi ke dalam Stack. |
| `System.out.println(...)` | Menampilkan pesan bahwa transaksi berhasil ditambahkan. |

Fitur ini memungkinkan pengguna memasukkan deskripsi transaksi secara manual, misalnya peminjaman buku atau pengembalian buku.

### E. Fitur Melihat Transaksi Terakhir

| Kode | Penjelasan |
|------|------------|
| `riwayatTransaksi.isEmpty()` | Memeriksa apakah Stack memiliki data transaksi. |
| `riwayatTransaksi.peek()` | Mengambil transaksi paling baru tanpa menghapusnya dari Stack. |
| `System.out.println(...)` | Menampilkan transaksi terakhir yang tersimpan. |

Fitur ini menerapkan prinsip LIFO karena transaksi yang terakhir ditambahkan berada di posisi paling atas Stack.

### F. Fitur Membatalkan Transaksi Terakhir

| Kode | Penjelasan |
|------|------------|
| `riwayatTransaksi.isEmpty()` | Memastikan terdapat transaksi yang dapat dihapus. |
| `riwayatTransaksi.pop()` | Menghapus transaksi yang berada di bagian paling atas Stack. |
| `System.out.println(...)` | Menampilkan informasi transaksi yang telah dihapus dari riwayat. |

> **Catatan:** Fitur pembatalan ini hanya menghapus catatan transaksi dari Stack. Fitur tersebut tidak secara otomatis membatalkan proses peminjaman atau pengembalian buku pada bagian program lainnya.

### G. Fitur Menampilkan Seluruh Riwayat Transaksi

| Kode | Penjelasan |
|------|------------|
| `riwayatTransaksi.isEmpty()` | Memeriksa apakah terdapat riwayat transaksi yang tersimpan. |
| Perulangan dari `riwayatTransaksi.size() - 1` | Digunakan untuk membaca data dari posisi terakhir menuju posisi pertama. |
| `riwayatTransaksi.get(i)` | Mengambil transaksi berdasarkan indeks yang sedang diproses. |
| `System.out.println(...)` | Menampilkan setiap transaksi secara berurutan dari transaksi terbaru hingga transaksi terlama. |

Dengan cara ini, pengguna dapat melihat seluruh riwayat transaksi yang masih tersimpan di dalam Stack.

### H. Menu Antrean Mahasiswa (Queue)

Menu antrean mahasiswa digunakan untuk menambahkan mahasiswa ke antrean, melihat urutan antrean, dan memproses mahasiswa berikutnya.

Menu Queue menampilkan pilihan untuk menambahkan antrean mahasiswa, menampilkan antrean, memproses mahasiswa berikutnya, dan kembali ke menu utama.

| Operasi | Penjelasan |
|---------|------------|
| `antreanMahasiswa.offer(nama)` | Menambahkan nama mahasiswa ke bagian belakang antrean. |
| `antreanMahasiswa.poll()` | Mengambil sekaligus menghapus mahasiswa yang berada di bagian depan antrean. |
| `antreanMahasiswa.isEmpty()` | Memeriksa apakah antrean kosong sebelum data ditampilkan atau diproses. |

Perulangan *for-each* digunakan untuk membaca dan menampilkan seluruh mahasiswa sesuai urutan antrean tanpa menghapus data.

### I. Fitur Menambahkan Mahasiswa ke Antrean

| Kode | Penjelasan |
|------|------------|
| `String nama = scanner.nextLine().trim();` | Membaca nama mahasiswa yang dimasukkan pengguna. |
| `nama.isEmpty()` | Memeriksa apakah nama mahasiswa kosong. Jika kosong, data tidak dimasukkan ke antrean. |
| `antreanMahasiswa.offer(nama);` | Menambahkan nama mahasiswa ke bagian belakang antrean. |
| `System.out.println(...)` | Menampilkan pesan bahwa mahasiswa berhasil ditambahkan ke antrean. |

Setiap mahasiswa akan ditempatkan di belakang mahasiswa yang sudah lebih dahulu mengantre.

### J. Fitur Menampilkan Antrean Mahasiswa

| Kode | Penjelasan |
|------|------------|
| `antreanMahasiswa.isEmpty()` | Memeriksa apakah terdapat mahasiswa dalam antrean. |
| `for (String nama : antreanMahasiswa)` | Melakukan perulangan untuk membaca setiap nama mahasiswa dalam urutan antrean. |
| `System.out.println(...)` | Menampilkan nama mahasiswa sesuai urutan kedatangan. |

Fitur ini hanya menampilkan data dan tidak menghapus mahasiswa dari antrean.

### K. Fitur Memproses Mahasiswa Berikutnya

| Kode | Penjelasan |
|------|------------|
| `antreanMahasiswa.isEmpty()` | Memeriksa apakah antrean memiliki mahasiswa yang dapat diproses. |
| `antreanMahasiswa.poll()` | Mengambil dan menghapus mahasiswa yang berada di urutan paling depan. |
| `System.out.println(...)` | Menampilkan nama mahasiswa yang sedang diproses. |

Fitur ini menerapkan prinsip FIFO karena mahasiswa yang pertama masuk ke antrean akan diproses terlebih dahulu.

---

## 3. Skenario Pengujian dan Hasil

### A. Pengujian Stack

| No. | Skenario Pengujian | Hasil yang Diharapkan |
|:---:|--------------------|-----------------------|
| 1 | Menambahkan transaksi Peminjaman buku Basis Data | Transaksi berhasil ditambahkan |
| 2 | Menambahkan transaksi Pengembalian buku Matematika | Transaksi berhasil ditambahkan |
| 3 | Melihat transaksi terakhir | Menampilkan Pengembalian buku Matematika |
| 4 | Membatalkan transaksi terakhir | Transaksi Pengembalian buku Matematika dihapus dari riwayat |
| 5 | Menampilkan seluruh riwayat | Menampilkan transaksi yang masih tersimpan dari terbaru ke terlama |

### B. Pengujian Queue

| No. | Skenario Pengujian | Hasil yang Diharapkan |
|:---:|--------------------|-----------------------|
| 1 | Menambahkan mahasiswa Andi | Andi berhasil masuk antrean |
| 2 | Menambahkan mahasiswa Budi | Budi berhasil masuk setelah Andi |
| 3 | Menampilkan antrean mahasiswa | Andi tampil sebelum Budi |
| 4 | Memproses mahasiswa berikutnya | Andi diproses terlebih dahulu |
| 5 | Menampilkan antrean kembali | Budi menjadi mahasiswa terdepan |

Pengujian dilakukan dengan menjalankan program dan memilih menu Stack maupun Queue. Hasil aktual pengujian dapat didokumentasikan melalui tangkapan layar (*screenshot*) setelah setiap fitur dijalankan.
