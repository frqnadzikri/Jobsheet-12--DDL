1. Perbedaan Single Linked List dan Double Linked List
Single Linked List: setiap node hanya memiliki pointer next, sehingga traversal hanya satu arah.
Double Linked List: setiap node memiliki pointer next dan prev, sehingga traversal bisa dua arah.
2. Fungsi atribut next dan prev pada Node
next: menunjuk ke node berikutnya.
prev: menunjuk ke node sebelumnya.
3. Fungsi konstruktor pada DoubleLinkedList
Konstruktor digunakan untuk menginisialisasi linked list dalam keadaan kosong dengan:
head = null
tail = null
size = 0
4. Mengapa head dan tail harus menunjuk node yang sama?
Karena saat linked list hanya memiliki satu node, node tersebut menjadi node pertama sekaligus node terakhir.