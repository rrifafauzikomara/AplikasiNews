# AplikasiNews

Aplikasi berita di indonesia menggunakan API dari https://newsapi.org/


## Screenshots

<pre>
<img src="Screenshot/Screenshot_20180622-142258.jpg" width="250" height="444">         <img src="Screenshot/Screenshot_20180622-142309.jpg" width="250" height="444">         <img src="Screenshot/Screenshot_20180622-142318.jpg" width="250" height="444">         <img src="Screenshot/Screenshot_20180622-142403.jpg" width="250" height="444">
</pre>


### Petunjuk menjalankan source code aplikasi
Untuk menjalankan source code aplikasi ini, anda perlu registrasi API KEY dari https://newsapi.org/
kemudian memasukkan API KEY yang telah didapat ke dalam file ***gradle.properties***

```
NewsApiToken="Masukan API KEY anda disini"
```

Kemudian tambah baris berikut pada file ***build.gradle*** dibawah ***buildTypes***

```
buildTypes.each {
        it.buildConfigField 'String', 'NEWS_API_TOKEN', NewsApiToken
    }
```

## Author

* **R Rifa Fauzi Komara**

Jangan lupa untuk follow dan ★
