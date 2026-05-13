package Jobsheet12;

public class DoubleLinkedList14 {

    Node14 head;
    Node14 tail;
    int size;

    // ============================================================
    // KONSTRUKTOR
    // ============================================================
    public DoubleLinkedList14() {
        head = null;
        tail = null;
        size = 0;
    }

    // Mengecek apakah linked list kosong
    public boolean isEmpty() {
        return head == null;
    }

    // Mengembalikan jumlah data (Tugas 5)
    public int size() {
        return size;
    }

    // ============================================================
    // PERCOBAAN 1 - OPERASI PENAMBAHAN
    // ============================================================

    // Menambahkan node baru di awal linked list
    public void addFirst(Mahasiswa14 data) {
        Node14 newNode = new Node14(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Menambahkan node baru di akhir linked list
    public void addLast(Mahasiswa14 data) {
        Node14 newNode = new Node14(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Menyisipkan node baru setelah node dengan NIM tertentu
    public void insertAfter(String nim, Mahasiswa14 data) {
        Node14 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                Node14 newNode = new Node14(data);
                newNode.next = current.next;
                newNode.prev = current;
                if (current.next != null) {
                    current.next.prev = newNode;
                } else {
                    tail = newNode;
                }
                current.next = newNode;
                size++;
                return;
            }
            current = current.next;
        }
        System.out.println("NIM " + nim + " tidak ditemukan.");
    }

    // Mencari node berdasarkan NIM
    public Node14 search(String nim) {
        Node14 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Menampilkan seluruh data dari head ke tail
    public void print() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
            return;
        }
        System.out.println("===== DATA MAHASISWA (Head -> Tail) =====");
        Node14 current = head;
        while (current != null) {
            current.data.tampil();
            current = current.next;
        }
    }

    // Menampilkan seluruh data dari tail ke head (terbalik)
    public void printReverse() {
        if (isEmpty()) {
            System.out.println("Linked List masih kosong");
            return;
        }
        System.out.println("===== DATA MAHASISWA (Tail -> Head) =====");
        Node14 current = tail;
        while (current != null) {
            current.data.tampil();
            current = current.prev;
        }
    }

    // ============================================================
    // PERCOBAAN 2 - OPERASI PENGHAPUSAN
    // ============================================================

    // Menghapus node paling depan (head)
    public void removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List kosong, tidak ada data yang dihapus.");
            return;
        }
        System.out.println("Data yang dihapus (removeFirst):");
        head.data.tampil();

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;  // geser head ke node berikutnya
            head.prev = null;  // putus pointer prev dari head baru
        }
        size--;
    }

    // Menghapus node paling belakang (tail)
    public void removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List kosong, tidak ada data yang dihapus.");
            return;
        }
        System.out.println("Data yang dihapus (removeLast):");
        tail.data.tampil();

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;  // geser tail ke node sebelumnya
            tail.next = null;  // putus pointer next dari tail baru
        }
        size--;
    }

    // ============================================================
    // TUGAS PRAKTIKUM
    // ============================================================

    // Tugas 1: Menambahkan node pada indeks tertentu
    public void add(int index, Mahasiswa14 data) {
        if (index < 0 || index > size) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size) {
            addLast(data);
            return;
        }
        Node14 newNode = new Node14(data);
        Node14 current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        newNode.prev = current;
        current.next.prev = newNode;
        current.next = newNode;
        size++;
    }

    // Tugas 2: Menghapus node setelah node dengan NIM tertentu
    public void removeAfter(String nim) {
        Node14 current = head;
        while (current != null) {
            if (current.data.nim.equals(nim)) {
                if (current.next == null) {
                    System.out.println("Tidak ada node setelah NIM " + nim);
                    return;
                }
                Node14 toDelete = current.next;
                System.out.println("Data yang dihapus (removeAfter):");
                toDelete.data.tampil();

                current.next = toDelete.next;
                if (toDelete.next != null) {
                    toDelete.next.prev = current;
                } else {
                    tail = current;
                }
                size--;
                return;
            }
            current = current.next;
        }
        System.out.println("NIM " + nim + " tidak ditemukan.");
    }

    // Tugas 3: Menghapus node pada indeks tertentu
    public void remove(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            System.out.println("Indeks tidak valid atau linked list kosong.");
            return;
        }
        if (index == 0) {
            removeFirst();
            return;
        }
        if (index == size - 1) {
            removeLast();
            return;
        }
        Node14 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println("Data yang dihapus (indeks " + index + "):");
        current.data.tampil();

        current.prev.next = current.next;
        current.next.prev = current.prev;
        size--;
    }

    // Tugas 4a: Menampilkan data node pertama
    public void getFirst() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        System.out.println("=== Node Pertama ===");
        head.data.tampil();
    }

    // Tugas 4b: Menampilkan data node terakhir
    public void getLast() {
        if (isEmpty()) {
            System.out.println("Linked List kosong.");
            return;
        }
        System.out.println("=== Node Terakhir ===");
        tail.data.tampil();
    }

    // Tugas 4c: Menampilkan data node pada indeks tertentu
    public void getIndex(int index) {
        if (isEmpty() || index < 0 || index >= size) {
            System.out.println("Indeks tidak valid.");
            return;
        }
        Node14 current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        System.out.println("=== Node Indeks " + index + " ===");
        current.data.tampil();
    }
}