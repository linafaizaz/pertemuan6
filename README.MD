public class BinarySearch {
    // Deklarasi class BinarySearch
    public static int binarySearch(int[] arr, int target) {
        // Method binarySearch dengan parameter array integer dan target
        int low = 0;                    // Set index awal ke 0
        int high = arr.length - 1;      // Set index akhir ke panjang array - 1

        while (low <= high) {            // Loop selama low tidak melebihi high
            int mid = low + (high - low) / 2;  // Hitung index tengah (cara aman untuk hindari overflow)

            if (arr[mid] == target) {    // Jika elemen tengah sama dengan target
                return mid;              // Return index tengah
            }

            if (arr[mid] > target) {     // Jika elemen tengah lebih besar dari target
                high = mid - 1;          // Geser high ke kiri mid (cari di setengah kiri)
            } else {                     // Jika elemen tengah lebih kecil dari target
                low = mid + 1;           // Geser low ke kanan mid (cari di setengah kanan)
            }
        }

        return -1;  // Return -1 jika tidak ditemukan
    }

    public static void main(String[] args) {
        // Method main untuk testing
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};  // Array yang sudah terurut
        int target = 23;  // Nilai yang dicari

        int result = binarySearch(arr, target);  // Panggil method binarySearch

        if (result == -1) {                      // Jika return -1 (tidak ditemukan)
            System.out.println("Elemen " + target + " tidak ditemukan dalam array");
        } else {                                 // Jika ditemukan
            System.out.println("Elemen " + target + " ditemukan pada indeks " + result);
        }
    }
}

public class BinarySearchRecursive {
    // Deklarasi class BinarySearchRecursive
    public static int binarySearchRecursive(int[] arr, int target, int low, int high) {
        // Method rekursif dengan parameter tambahan low dan high
        if (low > high) {                // Base case: jika low > high (tidak ditemukan)
            return -1;                   // Return -1
        }

        int mid = low + (high - low) / 2;  // Hitung index tengah

        if (arr[mid] == target) {        // Jika elemen tengah sama dengan target
            return mid;                   // Return index tengah
        }

        if (arr[mid] > target) {         // Jika elemen tengah lebih besar dari target
            return binarySearchRecursive(arr, target, low, mid - 1);  // Cari di setengah kiri
        }

        return binarySearchRecursive(arr, target, mid + 1, high);  // Cari di setengah kanan
    }

    public static int binarySearch(int[] arr, int target) {
        // Wrapper method untuk memanggil method rekursif
        return binarySearchRecursive(arr, target, 0, arr.length - 1);  // Panggil rekursif dengan inisialisasi low=0, high=length-1
    }

    public static void main(String[] args) {
        // Implementasi sama dengan versi iteratif
        int[] arr = {2, 5, 8, 12, 16, 23, 38, 45, 56, 72, 91};
        int target = 23;

        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Elemen " + target + " tidak ditemukan dalam array");
        } else {
            System.out.println("Elemen " + target + " ditemukan pada indeks " + result);
        }
    }
}

import java.util.Arrays;  // Import class Arrays untuk utilitas

interface Searchable<T> {  // Deklarasi interface generik
    int compare(T value);  // Method untuk membandingkan nilai
}

public class GenericBinarySearch {  // Deklarasi class utama
    public static <T> int binarySearch(T[] array, Searchable<T> searchable) {
        // Method generik binarySearch dengan parameter array dan objek Searchable
        int low = 0;  // Inisialisasi index awal
        int high = array.length - 1;  // Inisialisasi index akhir

        while (low <= high) {  // Loop selama low <= high
            int mid = low + (high - low) / 2;  // Hitung index tengah
            int comparison = searchable.compare(array[mid]);  // Bandingkan nilai menggunakan interface

            if (comparison == 0) {  // Jika sama
                return mid;         // Return index tengah
            } else if (comparison < 0) {  // Jika lebih kecil
                high = mid - 1;    // Geser high ke kiri
            } else {               // Jika lebih besar
                low = mid + 1;     // Geser low ke kanan
            }
        }
        return -1;  // Return -1 jika tidak ditemukan
    }

    public static void main(String[] args) {
        // Implementasi untuk berbagai tipe data
        Scanner scanner = new Scanner(System.in);  // Buat objek Scanner untuk input
        System.out.println("=== SISTEM PENCARIAN DATASET ===");
        // Menu pilihan tipe data
        System.out.println("Pilih jenis data yang ingin dicari:");
        System.out.println("1. Integer");
        System.out.println("2. Double");
        System.out.println("3. String");
        System.out.print("Pilihan Anda (1-3): ");
        
        int pilihan = scanner.nextInt();  // Baca input pilihan
        scanner.nextLine();  // Bersihkan newline di buffer

        switch (pilihan) {  // Switch berdasarkan pilihan
            case 1:  // Untuk integer
                Integer[] dataInteger = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
                System.out.println("\nData Integer: " + Arrays.toString(dataInteger));
                System.out.print("Masukkan nilai integer yang dicari: ");
                int targetInt = scanner.nextInt();
                // Implementasi pencarian dengan anonymous class
                int indexInt = binarySearch(dataInteger, new Searchable<Integer>() {
                    @Override
                    public int compare(Integer value) {
                        return targetInt - value;  // Bandingkan integer
                    }
                });
                // Output hasil
                if (indexInt != -1) {
                    System.out.println("Nilai " + targetInt + " ditemukan pada indeks " + indexInt);
                } else {
                    System.out.println("Nilai " + targetInt + " tidak ditemukan dalam dataset");
                }
                break;
            // Case 2 dan 3 implementasi serupa untuk Double dan String
        }
        scanner.close();  // Tutup scanner
    }
}

import java.util.Scanner;  // Import Scanner untuk input

class Buku {  // Class untuk representasi buku
    String isbn;  // Field ISBN
    String judul;  // Field judul
    String penulis;  // Field penulis
    int tahunTerbit;  // Field tahun terbit

    public Buku(String isbn, String judul, String penulis, int tahunTerbit) {  // Constructor
        this.isbn = isbn;
        this.judul = judul;
        this.penulis = penulis;
        this.tahunTerbit = tahunTerbit;
    }

    @Override
    public String toString() {  // Method untuk representasi string
        return String.format("ISBN: %s\nJudul: %s\nPenulis: %s\nTahun Terbit: %d",
                            isbn, judul, penulis, tahunTerbit);
    }
}

public class PencarianBuku {  // Class utama
    public static void main(String[] args) {
        // Data buku yang sudah terurut berdasarkan ISBN
        Buku[] daftarBuku = {
            new Buku("9780071606301", "Java: The Complete Reference", "Herbert Schildt", 2007),
            // Data buku lainnya...
        };

        Scanner scanner = new Scanner(System.in);  // Buat objek Scanner
        System.out.println("=== SISTEM PENCARIAN BUKU PERPUSTAKAAN ===");
        System.out.print("Masukkan nomor ISBN buku yang dicari: ");
        String isbnCari = scanner.nextLine();  // Baca input ISBN

        int index = cariBukuByISBN(daftarBuku, isbnCari);  // Panggil method pencarian

        System.out.println("\nHASIL PENCARIAN:");
        if (index != -1) {  // Jika ditemukan
            System.out.println("Buku ditemukan!");
            System.out.println(daftarBuku[index]);  // Tampilkan info buku
        } else {  // Jika tidak ditemukan
            System.out.println("Buku dengan ISBN " + isbnCari + " tidak ditemukan.");
        }
        scanner.close();  // Tutup scanner
    }

    public static int cariBukuByISBN(Buku[] daftarBuku, String isbn) {
        // Method binary search untuk cari buku berdasarkan ISBN
        int low = 0;  // Inisialisasi index awal
        int high = daftarBuku.length - 1;  // Inisialisasi index akhir

        while (low <= high) {  // Loop selama low <= high
            int mid = low + (high - low) / 2;  // Hitung index tengah
            int comparison = daftarBuku[mid].isbn.compareTo(isbn);  // Bandingkan ISBN

            if (comparison == 0) {  // Jika ISBN sama
                return mid;         // Return index tengah
            }

            if (comparison > 0) {  // Jika ISBN yang dicari lebih kecil
                high = mid - 1;    // Geser high ke kiri
            } else {              // Jika ISBN yang dicari lebih besar
                low = mid + 1;    // Geser low ke kanan
            }
        }
        return -1;  // Return -1 jika tidak ditemukan
    }
}

import java.time.LocalDate;  // Import class untuk tanggal
import java.time.format.DateTimeFormatter;  // Import class untuk format tanggal
import java.util.Scanner;  // Import Scanner untuk input

class Acara {  // Class untuk representasi acara
    LocalDate tanggal;  // Field tanggal
    String nama;        // Field nama acara
    String lokasi;      // Field lokasi
    String deskripsi;   // Field deskripsi

    public Acara(LocalDate tanggal, String nama, String lokasi, String deskripsi) {  // Constructor
        this.tanggal = tanggal;
        this.nama = nama;
        this.lokasi = lokasi;
        this.deskripsi = deskripsi;
    }

    @Override
    public String toString() {  // Method untuk representasi string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");  // Format tanggal
        return String.format("Tanggal: %s\nNama Acara: %s\nLokasi: %s\nDeskripsi: %s",
                            tanggal.format(formatter), nama, lokasi, deskripsi);
    }
}

public class PencarianAcara {  // Class utama
    public static void main(String[] args) {
        // Data acara yang sudah terurut berdasarkan tanggal
        Acara[] jadwalAcara = {
            new Acara(LocalDate.of(2025, 5, 10), "Workshop Java", "Ruang Pelatihan A", "Workshop dasar pemrograman Java"),
            // Data acara lainnya...
        };

        Scanner scanner = new Scanner(System.in);  // Buat objek Scanner
        System.out.println("=== SISTEM PENCARIAN ACARA ===");
        System.out.println("Format tanggal: yyyy-MM-dd (contoh: 2025-05-20)");
        System.out.print("Masukkan tanggal yang ingin dicari: ");
        String tanggalInput = scanner.nextLine();  // Baca input tanggal

        try {
            LocalDate tanggalCari = LocalDate.parse(tanggalInput);  // Parse input ke LocalDate
            int index = cariAcaraByTanggal(jadwalAcara, tanggalCari);  // Panggil method pencarian

            System.out.println("\nHASIL PENCARIAN:");
            if (index != -1) {  // Jika ditemukan
                System.out.println("Acara ditemukan pada tanggal " + tanggalInput + "!");
                System.out.println(jadwalAcara[index]);  // Tampilkan info acara
            } else {  // Jika tidak ditemukan
                System.out.println("Tidak ada acara yang terjadwal pada tanggal " + tanggalInput + ".");
            }
        } catch (Exception e) {  // Tangani error parsing tanggal
            System.out.println("Format tanggal tidak valid. Gunakan format yyyy-MM-dd.");
        }
        scanner.close();  // Tutup scanner
    }

    public static int cariAcaraByTanggal(Acara[] jadwalAcara, LocalDate tanggal) {
        // Method binary search untuk cari acara berdasarkan tanggal
        int low = 0;  // Inisialisasi index awal
        int high = jadwalAcara.length - 1;  // Inisialisasi index akhir

        while (low <= high) {  // Loop selama low <= high
            int mid = low + (high - low) / 2;  // Hitung index tengah

            if (jadwalAcara[mid].tanggal.isEqual(tanggal)) {  // Jika tanggal sama
                return mid;                                  // Return index tengah
            }

            if (jadwalAcara[mid].tanggal.isAfter(tanggal)) {  // Jika tanggal acara lebih akhir
                high = mid - 1;                              // Geser high ke kiri
            } else {                                        // Jika tanggal acara lebih awal
                low = mid + 1;                             // Geser low ke kanan
            }
        }
        return -1;  // Return -1 jika tidak ditemukan
    }
}