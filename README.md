# Reflection: Exercise 1
## Implementasi Clean Code pada Tutorial 1
### 1. Penamaan variabel, fungsi/method, dan class secara deskriptif
- Memberikan suffix file .java sesuai dengan nama folder (Contoh: semua nama file didalam `Controller` memiliki suffix Controller seperti ProductController.)
- Memberikan penamaan variabel yang deskriptif agar kode mudah dibaca.
- Menggunakan camelCase untuk penamaan variabel dan method, dan PascalCase untuk penamaan class.

### 2. Penerapan Prinsip dalam Fungsi
- Penerapan prinsip bahwasanya suatu fungsi hanya melakukan satu tujuan utama. Sehingga bagian-bagian lebih kecil dapat dipecah kedalam fungsi lainnya. "Function should do one thing. They should do it well. They should do it only."
- Penerapan prinsip bahwasanya suatu fungsi seharusnya berukuran relatif kecil, hal ini merupakan akibat dari prinsip sebelumnya.

### 3. Memperbaiki/Improvisasi kesalahan pada source code
- Ketika Produk diinisialisasi, tidak ada bagian kode yang membuat unique id pada setiap produk. Hal ini dapat menyebabkan error pada edit/delete, sehingga setiap kali produk dibuat, saya membuat random UUID untuk di-set pada `productId`.





# Reflection: Exercise 2
## Implementasi unit test pada program
- Saya membuat unit test untuk method method yang saya buat pada  `Repository`.
- Saya memastikan agar method saya bisa `Passed` dalam edge cases yang mungkin terdapat dalam implementasi kode saya.
- Setelah kode saya bisa melewati semua testcases yang saya buat, saya merasa bahwa kode saya lebih aman dari tricky cases (Contoh: berusaha menghapus elemen dengan id non-existent). Sebab unit test memberikan jaminan bahwa method yang dieksekusi berjalan sesuai harapan.

## Implementasi functional test pada program
- Pada functional test, hal utama yang perlu diperhatikan adalah untuk memastikan bahwa interaksi antara client dan server berjalan dengan baik.
- Sehingga pada functional test, akan dibuat 'simulasi' interaksi client (Memencet tombol `Create`, Mengisi form `Create Product`, Submit form) dengan menggunakan library eksternal `selenium`.
- Perlu diperhatikan bahwa hal utama yang akan diuji disini adalah experience user (Bagaimana seluruh produk terlihat) dapat berjalan dengan lancar.
- Dapat terjadi kasus function yang tidak sesuai dengan tujuannya. Terlalu banyak logika yang kompleks dapat membuat test suite sulit dimengerti dan rentan terhadap bug. Sebaiknya perlu dipastikan bahwa setiap metode atau langkah di dalam test suite memiliki tujuan yang jelas dan sesuai dengan pengujian jumlah item dalam daftar produk.

Untuk mengimplementasikan `Clean Code` lebih lanjut, Saya memastikan bahwa nama variabel serta class telah memenuhi `Naming Convention`. Saya juga melakukan penerapan prinsip "DRY (Don't Repeat Yourself), yaitu membuat suatu fungsi untuk suatu bagian kode yang relatif sama agar tidak menuliskan bagian kode yang sama berulang-ulang.