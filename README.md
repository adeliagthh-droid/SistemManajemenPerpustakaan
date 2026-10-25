# Sistem Manajemen Perpustakaan Kampus

## Implementasi dan Pembahasan Array 3D dan ArrayList

### 1. Deskripsi Fitur
Pada bagian ini, fokus utama pengembangan adalah mengimplementasikan **Array 3 Dimensi** dan **ArrayList** ke dalam sistem manajemen perpustakaan berbasis Java.

* **Array 3 Dimensi** digunakan untuk merepresentasikan lokasi penyimpanan buku berdasarkan tiga petunjuk: lantai, nomor rak, dan posisi buku di dalam rak. Contoh gambarannya itu seperti gedung perpustakaan: setiap lantai punya beberapa rak, dan setiap rak punya beberapa slot tempat untuk buku diletakkan.
* **ArrayList** digunakan untuk mengelola daftar buku secara dinamis, yaitu jumlah buku dapat bertambah saat buku ditambahkan dan berkurang saat buku dihapus tanpa perlu menentukan ukuran di awal.
* Kedua struktur data ini saling terhubung. Saat buku ditambahkan, datanya masuk ke ArrayList dan judulnya ditempatkan pada posisi rak di Array 3D. Saat buku dihapus, datanya dikeluarkan dari ArrayList dan posisi rak tersebut dikosongkan kembali.
* Data satu buku disimpan dalam sebuah objek dari class `Buku` yang dibuat terpisah pada file `Buku.java`.

---

### 2. Penjelasan *Source Code* Baris demi Baris
Berikut adalah penjelasan rinci baris demi baris dari kode program yang diimplementasikan pada bagian Anggota 2:

#### A. Class `Buku` (file `Buku.java`)

* `package main;`
  Menyatakan bahwa class `Buku` berada dalam package `main`, sama dengan class utama program, sehingga keduanya dapat saling digunakan.

* `public class Buku {`
  Mendeklarasikan class `Buku` yang berfungsi sebagai "cetakan" data satu buku. Setiap buku yang ditambahkan akan dibuat sebagai satu objek dari class ini.

* `private String judul;` dan `private String kategori;`
  Mendeklarasikan atribut bertipe `String` untuk menyimpan judul dan kategori buku. Kata kunci `private` membuat atribut hanya dapat diakses dari dalam class `Buku` itu sendiri (konsep *encapsulation*).

* `private int lantai;`, `private int rak;`, dan `private int posisi;`
  Mendeklarasikan atribut bertipe `int` untuk menyimpan lokasi buku, yaitu nomor lantai, nomor rak, dan nomor posisi di dalam rak.

* `public Buku(String judul, String kategori, int lantai, int rak, int posisi) {`
  Mendeklarasikan *constructor*, yaitu method khusus yang dijalankan saat objek `Buku` dibuat dengan `new Buku(...)`. Constructor menerima lima nilai sebagai parameter.

* `this.judul = judul;` (dan baris serupa untuk atribut lainnya)
  Menyalin nilai parameter ke atribut milik objek. Kata `this` menunjukkan bahwa yang diisi adalah atribut objek, bukan parameter yang namanya sama.

* `public String getJudul() { return judul; }` (dan `getKategori()`, `getLantai()`, `getRak()`, `getPosisi()`)
  Method *getter* yang berfungsi mengembalikan nilai atribut `private` agar dapat dibaca dari class lain. Karena atribut dikunci dengan `private`, getter menjadi satu-satunya jalan untuk membaca datanya.

#### B. Deklarasi Data pada Class Utama

* `import java.util.ArrayList;`
  Mengimpor class `ArrayList` dari pustaka bawaan Java agar dapat digunakan untuk membuat daftar buku yang ukurannya dinamis.

* `static final int JUMLAH_LANTAI = 2;`, `JUMLAH_RAK = 3;`, dan `JUMLAH_POSISI = 4;`
  Mendeklarasikan tiga konstanta yang menentukan ukuran gedung perpustakaan: 2 lantai, 3 rak per lantai, dan 4 posisi per rak. Kata kunci `final` membuat nilainya tidak dapat diubah, dan dengan konstanta ini ukuran rak cukup diubah di satu tempat saja.

* `static String[][][] lokasiBuku = new String[JUMLAH_LANTAI][JUMLAH_RAK][JUMLAH_POSISI];`
  Mendeklarasikan **Array 3 Dimensi** bertipe `String` dengan nama `lokasiBuku`. Indeks pertama mewakili lantai, indeks kedua mewakili rak, dan indeks ketiga mewakili posisi. Total terdapat 2 x 3 x 4 = 24 slot penyimpanan, yang masing-masing menyimpan judul buku atau tulisan "Kosong".

* `static ArrayList<Buku> daftarBuku = new ArrayList<>();`
  Membuat **ArrayList** bernama `daftarBuku` yang hanya boleh berisi objek `Buku`. Awalnya daftar ini kosong dan ukurannya bertambah otomatis setiap kali buku ditambahkan.

#### C. Pengisian Awal Array 3D (di dalam method `main`)

* `for (int l = 0; l < JUMLAH_LANTAI; l++) {`, `for (int r = 0; r < JUMLAH_RAK; r++) {`, dan `for (int p = 0; p < JUMLAH_POSISI; p++) {`
  Tiga perulangan `for` yang bersarang (*nested loop*). Perulangan terluar (`l`) berjalan untuk setiap lantai, perulangan tengah (`r`) untuk setiap rak, dan perulangan terdalam (`p`) untuk setiap posisi. Dengan begitu, seluruh 24 slot dikunjungi satu per satu.

* `lokasiBuku[l][r][p] = "Kosong";`
  Mengisi setiap slot dengan teks "Kosong" sebagai tanda belum ada buku. Tanpa langkah ini, isi array `String` bernilai `null` dan dapat menyebabkan error saat dibandingkan atau ditampilkan.

#### D. Menu Anggota 2 (di dalam `switch (pilihan)`)

* `System.out.println("3. Tambah Buku (ArrayList + Array 3D)");` sampai `System.out.println("6. Tampilkan Denah Lokasi Penyimpanan (Array 3D)");`
  Mencetak empat pilihan menu milik Anggota 2 pada layar.

* `case 3:` memanggil `tambahBuku();`
  Menjalankan method untuk menambah buku, lalu `break;` menghentikan percabangan.

* `case 4:` memanggil `tampilkanDaftarBuku();`
  Menjalankan method untuk menampilkan seluruh buku yang ada di ArrayList.

* `case 5:` memanggil `hapusBuku();`
  Menjalankan method untuk menghapus buku dari ArrayList sekaligus mengosongkan posisinya di rak.

* `case 6:` memanggil `tampilkanLokasi();`
  Menjalankan method untuk menampilkan denah seluruh lantai, rak, dan posisi dari Array 3D.

#### E. Method `bacaAngka` (pembaca input angka yang aman)

* `static int bacaAngka(String pesan) {`
  Mendeklarasikan method yang menerima teks pesan (misalnya "Pilih menu (1-7): ") dan mengembalikan sebuah angka `int`.

* `while (true) {`
  Perulangan tanpa henti yang baru berhenti ketika pengguna memasukkan angka yang benar (melalui `return`).

* `System.out.print(pesan);`
  Menampilkan pertanyaan kepada pengguna.

* `String input = scanner.nextLine().trim();`
  Membaca satu baris ketikan pengguna sebagai teks, lalu `trim()` membuang spasi di awal dan akhir.

* `try { return Integer.parseInt(input); }`
  Mencoba mengubah teks menjadi angka. Jika berhasil, angka langsung dikembalikan dan method selesai.

* `catch (NumberFormatException e) { System.out.println("Input harus berupa angka!"); }`
  Jika pengguna mengetik huruf atau simbol, perubahan ke angka gagal dan Java melemparkan `NumberFormatException`. Blok `catch` menangkapnya, menampilkan peringatan, dan perulangan `while` mengulang pertanyaan. Dengan cara ini program tidak akan berhenti mendadak.

#### F. Method `tambahBuku()` (menambah buku ke ArrayList dan Array 3D)

* `System.out.print("Judul buku: ");` dan `String judul = scanner.nextLine().trim();`
  Meminta dan membaca judul buku dari pengguna.

* `if (judul.isEmpty()) { ... return; }`
  Percabangan untuk memeriksa apakah judul kosong. Jika kosong, program menampilkan pesan lalu `return` menghentikan method sehingga buku tidak ditambahkan.

* `for (int i = 0; i < kategoriBuku.length; i++) { System.out.println((i + 1) + ". " + kategoriBuku[i]); }`
  Perulangan untuk mencetak pilihan kategori dari array `kategoriBuku` milik Anggota 1, diberi nomor mulai dari 1.

* `int k = bacaAngka("Nomor kategori: ");`
  Membaca nomor kategori yang dipilih pengguna.

* `if (k < 1 || k > kategoriBuku.length) { ... return; }`
  Memastikan nomor kategori berada dalam rentang 1 sampai 4. Jika tidak, proses dibatalkan.

* `int lantai = bacaAngka(...);`, `int rak = bacaAngka(...);`, dan `int posisi = bacaAngka(...);`
  Membaca tiga angka lokasi penyimpanan dari pengguna. Batas yang ditampilkan pada pesan mengambil nilai dari konstanta, sehingga selalu sesuai ukuran rak.

* `if (lantai < 1 || lantai > JUMLAH_LANTAI || rak < 1 || rak > JUMLAH_RAK || posisi < 1 || posisi > JUMLAH_POSISI) { ... return; }`
  Percabangan dengan operator logika `||` (atau) untuk memeriksa apakah salah satu dari tiga angka lokasi berada di luar jangkauan. Jika ya, proses dibatalkan agar tidak terjadi error `ArrayIndexOutOfBoundsException`.

* `if (!lokasiBuku[lantai - 1][rak - 1][posisi - 1].equals("Kosong")) { ... return; }`
  Memeriksa apakah slot yang dipilih sudah terisi. Pengurangan `- 1` diperlukan karena pengguna mengetik angka mulai dari 1, sedangkan indeks array dimulai dari 0. Tanda `!` membalik hasil `equals`, jadi blok ini berjalan bila slot **bukan** "Kosong", lalu menampilkan judul buku yang sudah menempati slot tersebut dan membatalkan proses.

* `daftarBuku.add(new Buku(judul, kategoriBuku[k - 1], lantai, rak, posisi));`
  Membuat objek `Buku` baru dari data yang dimasukkan, lalu `add` menambahkannya ke bagian akhir ArrayList. Ukuran ArrayList otomatis bertambah satu.

* `lokasiBuku[lantai - 1][rak - 1][posisi - 1] = judul;`
  Menaruh judul buku pada slot yang dipilih di Array 3D, sehingga slot tersebut tidak lagi "Kosong".

* `System.out.println("Buku \"" + judul + "\" berhasil ditambahkan.");`
  Menampilkan pesan bahwa penambahan berhasil.

#### G. Method `tampilkanDaftarBuku()` (menampilkan isi ArrayList)

* `if (daftarBuku.isEmpty()) { System.out.println("Belum ada buku."); return; }`
  Memeriksa apakah ArrayList kosong. Jika kosong, program menampilkan pesan dan menghentikan method.

* `System.out.println(String.format("%-4s%-30s%-20s%s", "No", "Judul", "Kategori", "Lokasi"));`
  Mencetak judul kolom tabel. Format `%-4s` berarti teks rata kiri dengan lebar 4 karakter, sehingga kolom tampil sejajar dan rapi.

* `for (int i = 0; i < daftarBuku.size(); i++) {`
  Perulangan sebanyak jumlah buku. Method `size()` mengembalikan banyaknya elemen di ArrayList.

* `Buku b = daftarBuku.get(i);`
  Mengambil objek `Buku` pada urutan ke-`i` dari ArrayList dan menyimpannya sementara pada variabel `b`.

* `System.out.println(String.format("%-4d%-30s%-20sLt.%d Rak %d Pos %d", (i + 1), b.getJudul(), b.getKategori(), b.getLantai(), b.getRak(), b.getPosisi()));`
  Mencetak satu baris data buku: nomor urut, judul, kategori, dan lokasi. Data dibaca melalui getter dan `(i + 1)` dipakai agar nomor urut dimulai dari 1.

* `System.out.println("Total buku: " + daftarBuku.size());`
  Menampilkan jumlah seluruh buku yang tersimpan.

#### H. Method `hapusBuku()` (menghapus dari ArrayList dan mengosongkan Array 3D)

* `if (daftarBuku.isEmpty()) { ... return; }`
  Jika belum ada buku, program menampilkan pesan dan tidak melanjutkan proses penghapusan.

* `tampilkanDaftarBuku();`
  Menampilkan daftar buku terlebih dahulu agar pengguna dapat melihat nomor buku yang akan dihapus.

* `int nomor = bacaAngka("Nomor buku yang dihapus: ");`
  Membaca nomor buku yang dipilih pengguna.

* `if (nomor < 1 || nomor > daftarBuku.size()) { ... return; }`
  Memastikan nomor berada di antara 1 dan jumlah buku yang ada. Jika tidak valid, proses dibatalkan.

* `Buku dihapus = daftarBuku.remove(nomor - 1);`
  Method `remove` menghapus buku pada indeks `nomor - 1` dari ArrayList dan mengembalikan objek yang dihapus, yang disimpan di variabel `dihapus`. Elemen setelahnya otomatis bergeser maju sehingga tidak ada celah kosong di daftar.

* `lokasiBuku[dihapus.getLantai() - 1][dihapus.getRak() - 1][dihapus.getPosisi() - 1] = "Kosong";`
  Memakai data lokasi dari buku yang baru dihapus untuk menemukan slotnya di Array 3D, lalu mengembalikan isinya menjadi "Kosong" agar slot dapat dipakai buku lain.

* `System.out.println("Buku \"" + dihapus.getJudul() + "\" berhasil dihapus dan posisinya dikosongkan.");`
  Menampilkan pesan bahwa penghapusan berhasil.

#### I. Method `tampilkanLokasi()` (menampilkan denah Array 3D)

* `for (int l = 0; l < JUMLAH_LANTAI; l++) {`
  Perulangan terluar yang berjalan untuk setiap lantai.

* `System.out.println("== Lantai " + (l + 1) + " ==");`
  Mencetak judul lantai. Ditambah 1 agar tampil sebagai Lantai 1 dan Lantai 2, bukan 0 dan 1.

* `for (int r = 0; r < JUMLAH_RAK; r++) {` dan `System.out.println("  Rak " + (r + 1) + ":");`
  Perulangan tengah untuk setiap rak di lantai tersebut, beserta pencetakan nama rak.

* `for (int p = 0; p < JUMLAH_POSISI; p++) {`
  Perulangan terdalam untuk setiap posisi di dalam rak.

* `System.out.println("    Posisi " + (p + 1) + ": " + lokasiBuku[l][r][p]);`
  Mencetak nomor posisi beserta isi slot tersebut, yaitu judul buku atau "Kosong". Hasil akhirnya adalah denah bertingkat: lantai, rak, lalu posisi.
