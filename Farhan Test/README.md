Efishery Test Documentations

Teknologi yang di pakai <br>
-Kotlin <br>
-MVVM Patern <br>
-Retrofit<br>
-DI Hilt dagger <br>
-XMl MaterialsDesign menngunakan constraint layout <br>
-Menggunakan Single Activity pada jetpack navigations component <br>
-Room DB

<br>
<br>
Instalasi lewat project android studio <br>
- Clone repository ini <br>
- https://github.com/arysugiarto/EfisheryTest  (jangan lupa pilih branch, terdapat 2 branch master dan develop yang terupdate pada develop) <br>
- Setelah di clone buka project android menggunakan android studio lalu jalankan Run (jangan lupa emulator / device android terpasang)<br>

<br>

Instalasi lewat Apk <br>
-Download apk lewat link berikut <br>
https://drive.google.com/file/d/1ve67zViBXQJfKvRPrL6xk6S9wJjGeZwd/view?usp=sharing <br>
-setelah terdownload pada device lakukan instalasi <br>
-tunggu sampai selesai dan aplikasi siap digunakan

<br>
<br>

Petunjuk penggunaan <br>
<img align="left" src="ss/1.png" width="200" height="400"> 
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

Terdapat dropdown ke bawah pada toolbar itu di tunjukan untuk ke halaman area
<br><br>

<img align="left" src="ss/2.png" width="200" height="400">
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

Jika Item di klik pada halaman area misal jawa barat nantinya bakal muncul pada toolbar home
<br>

Jika pada home salah satu jenis ikan di klik maka akan mengarah ke halaman detail ikan
<br><br>

<img align="left" src="ss/3.png" width="200" height="400">
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

Untuk memesan ikan tersebut pengguna bisa klik button pesan sekarang yang ada di bawah <br>
<img align="left" src="ss/4.png" width="200" height="400">
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>

Pengguna harus mengisi formulir pemesanan jika formulir sudah terisi pengguna bisa klik pesan pada button di bawah (harus scroll karena form banyak)<br>

untuk melihat pesanan pengguna bisa klik bottom navigations pesanan yang ada di bawah maka akan menuju halaman list pesanan <br>
<img align="left" src="ss/5.png" width="200" height="400">
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>


Dan kesimpulannya untuk test ini ada beberapa fitur yang belum selesai <br>

Data yang telah tampil tidak akan hilang jika internet lost connect<br>
Data aman jika device android melakukan rotate

menurut saya untuk fitur search dan tabulasi baiknya response API list ikan berisi body json <br>

{
    "search": "ikan nila",
    "jenis_ikan": "Ikan Gurame"
}

<br>
body json diatas memungkinkan untuk,  bisa mengirim param sesuai data yang ingin di cari atau di tampilkan,<br>
mungkin ada cara lain namun yang terikirkan oleh saya mungkin cara seperti diatas
<br><br>

untuk fitur tambah data, saya mengakalinya dengan input ke local data menggunakan Room DB,
yang seolah-olah user memesan ke server, namun karena tidak ada API submit maka saya akali dengan Room DB

<br><br>
Senang mengerjakan test nya mari berdiskusi :)








