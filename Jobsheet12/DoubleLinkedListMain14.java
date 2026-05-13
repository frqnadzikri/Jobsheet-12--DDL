package Jobsheet12;

import java.util.Scanner;

public class DoubleLinkedListMain14 {

    public static void main(String[] args) {
        DoubleLinkedList14 dll = new DoubleLinkedList14();
        Scanner sc = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n========================================");
            System.out.println("    DOUBLE LINKED LIST - PRESENSI 14   ");
            System.out.println("========================================");
            System.out.println(" [PERCOBAAN 1 - PENAMBAHAN]");
            System.out.println("  1. Tambah di Awal       (addFirst)");
            System.out.println("  2. Tambah di Akhir      (addLast)");
            System.out.println("  3. Sisipkan Setelah NIM (insertAfter)");
            System.out.println("  4. Cari Data            (search)");
            System.out.println("  5. Tampilkan Semua      (print)");
            System.out.println("  6. Tampilkan Terbalik   (printReverse)");
            System.out.println(" [PERCOBAAN 2 - PENGHAPUSAN]");
            System.out.println("  7. Hapus di Awal        (removeFirst)");
            System.out.println("  8. Hapus di Akhir       (removeLast)");
            System.out.println(" [TUGAS PRAKTIKUM]");
            System.out.println("  9. Tambah pada Indeks   (add)");
            System.out.println(" 10. Hapus Setelah NIM    (removeAfter)");
            System.out.println(" 11. Hapus pada Indeks    (remove)");
            System.out.println(" 12. Tampilkan Node Pertama (getFirst)");
            System.out.println(" 13. Tampilkan Node Terakhir (getLast)");
            System.out.println(" 14. Tampilkan Node Indeks  (getIndex)");
            System.out.println(" 15. Jumlah Data            (size)");
            System.out.println("  0. Keluar");
            System.out.println("========================================");
            System.out.print("Pilihan: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {

                case 1:
                    dll.addFirst(inputMahasiswa(sc));
                    System.out.println("Data berhasil ditambahkan di awal.");
                    break;

                case 2:
                    dll.addLast(inputMahasiswa(sc));
                    System.out.println("Data berhasil ditambahkan di akhir.");
                    break;

                case 3:
                    System.out.print("Masukkan NIM acuan: ");
                    String nimInsert = sc.nextLine();
                    dll.insertAfter(nimInsert, inputMahasiswa(sc));
                    System.out.println("Data berhasil disisipkan.");
                    break;

                case 4:
                    System.out.print("Masukkan NIM yang dicari: ");
                    String nimCari = sc.nextLine();
                    Node14 hasil = dll.search(nimCari);
                    if (hasil != null) {
                        System.out.println("Data ditemukan:");
                        hasil.data.tampil();
                    } else {
                        System.out.println("Data dengan NIM " + nimCari + " tidak ditemukan.");
                    }
                    break;

                case 5:
                    dll.print();
                    break;

                case 6:
                    dll.printReverse();
                    break;

                case 7:
                    dll.removeFirst();
                    break;

                case 8:
                    dll.removeLast();
                    break;

                case 9:
                    System.out.print("Masukkan indeks: ");
                    int idxAdd = sc.nextInt();
                    sc.nextLine();
                    dll.add(idxAdd, inputMahasiswa(sc));
                    System.out.println("Data berhasil ditambahkan pada indeks " + idxAdd + ".");
                    break;

                case 10:
                    System.out.print("Masukkan NIM acuan: ");
                    String nimRemoveAfter = sc.nextLine();
                    dll.removeAfter(nimRemoveAfter);
                    break;

                case 11:
                    System.out.print("Masukkan indeks yang dihapus: ");
                    int idxRemove = sc.nextInt();
                    sc.nextLine();
                    dll.remove(idxRemove);
                    break;

                case 12:
                    dll.getFirst();
                    break;

                case 13:
                    dll.getLast();
                    break;

                case 14:
                    System.out.print("Masukkan indeks: ");
                    int idxGet = sc.nextInt();
                    sc.nextLine();
                    dll.getIndex(idxGet);
                    break;

                case 15:
                    System.out.println("Jumlah data dalam linked list: " + dll.size());
                    break;

                case 0:
                    System.out.println("Program selesai. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }

        } while (pilihan != 0);

        sc.close();
    }

    // Helper method untuk input data mahasiswa
    static Mahasiswa14 inputMahasiswa(Scanner sc) {
        System.out.print("NIM   : ");
        String nim = sc.nextLine();
        System.out.print("Nama  : ");
        String nama = sc.nextLine();
        System.out.print("Kelas : ");
        String kelas = sc.nextLine();
        System.out.print("IPK   : ");
        double ipk = sc.nextDouble();
        sc.nextLine();
        return new Mahasiswa14(nim, nama, kelas, ipk);
    }
}