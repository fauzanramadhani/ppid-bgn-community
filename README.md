# PPID BGN Community 🏛️
<img src="https://github.com/user-attachments/assets/df867331-1fbe-46e0-ab5f-4ef881f447ed" style="width:250px; height:auto;" />
<img src="https://github.com/user-attachments/assets/24989345-4a66-4b90-af23-3eef955b7526" style="width:250px; height:auto;" />

Aplikasi mobile alternatif untuk Pejabat Pengelola Informasi dan Dokumentasi (PPID) Badan Gizi Nasional yang dibangun secara native dengan semangat transparansi dan efisiensi informasi.

## 📌 Latar Belakang

Proyek ini bermula dari kebutuhan akan akses informasi publik yang lebih stabil dan handal. Saat ini, aplikasi resmi masih menggunakan pendekatan **WebView** yang terkadang mengalami kendala teknis (seperti tautan yang mengarah ke domain staging). 

**PPID BGN Community** hadir sebagai inisiatif komunitas untuk menyediakan solusi alternatif yang lebih matang secara teknis, memberikan pengalaman pengguna yang lebih baik, dan memastikan data informasi publik dapat diakses kapan saja tanpa hambatan infrastruktur web yang kurang optimal.

## 🎯 Tujuan Proyek

- **Native Experience**: Memberikan performa yang jauh lebih mulus dibandingkan pendekatan WebView.
- **Reliability**: Memastikan aplikasi tetap berfungsi dengan baik meskipun ada perubahan pada sisi server atau domain web utama.
- **Accessibility**: Menyediakan struktur informasi yang lebih rapi dan mudah dinavigasi oleh masyarakat.
- **Modern UI/UX**: Mengimplementasikan standar desain Material 3 yang modern dan profesional.

## 🚀 Perbedaan & Improvement

Fokus utama kami bukan untuk menggantikan, melainkan memberikan standar baru dalam penyajian informasi:

| Fitur | Aplikasi Sebelumnya | PPID BGN Community |
|-------|--------------------|--------------------|
| **Teknologi** | WebView (Web Wrapper) | Native (Jetpack Compose) |
| **Kecepatan** | Tergantung loading browser | Instan dengan caching lokal |
| **Stabilitas** | Rentan error domain/server | Lebih tangguh dengan penanganan error native |
| **Navigasi** | Mengikuti struktur website | Dioptimalkan untuk perangkat mobile |

## 🛠️ Tech Stack

Aplikasi ini menggunakan teknologi Android terkini untuk memastikan kode yang bersih dan mudah dipelihara:

- **Bahasa**: [Kotlin](https://kotlinlang.org/)
- **UI Framework**: [Jetpack Compose](https://developer.android.com/jetpack/compose) (Material 3)
- **Arsitektur**: MVI (Model-View-Intent) dengan Clean Architecture
- **Dependency Injection**: [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- **Navigasi**: Navigation Compose (Typed-safe Routes)
- **Serialization**: Kotlinx Serialization
- **Font**: Inter (via Google Fonts)

## 📂 Struktur Folder

```text
app/src/main/java/com/fgr/ppidbgncommunity/
├── common/         # Utilitas dan Base Classes (BaseViewModel, dll)
├── data/           # Layer Data (Repository, Data Sources, Models)
├── domain/         # Layer Bisnis (Usecases, Domain Models)
└── ui/             # Layer Presentasi
    ├── component/  # Reusable UI Components
    ├── feature/    # Fitur aplikasi (Home, Berkala, dll)
    ├── navigation/ # Konfigurasi Navigasi
    └── theme/      # Konfigurasi Tema (Color, Type, Theme)
```

## 🛠️ Cara Menjalankan Project

1. **Clone Repository**
   ```bash
   git clone https://github.com/username/PPIDBGNCOMMUNITY.git
   ```
2. **Buka di Android Studio**
   Gunakan Android Studio versi terbaru (Ladybug atau yang lebih baru direkomendasikan).
3. **Sync Gradle**
   Tunggu hingga proses sinkronisasi selesai.
4. **Run**
   Klik tombol 'Run' dan pilih emulator atau perangkat fisik Anda.

## 🗺️ Roadmap

- [x] Redesign Home Screen Modern
- [x] Implementasi Informasi Berkala (JSON Data)
- [ ] Implementasi Form Permohonan Informasi
- [ ] Mode Offline untuk dokumen yang sudah diunduh

## 🤝 Kontribusi

Kami sangat terbuka bagi para developer Indonesia yang ingin ikut berkontribusi membangun aplikasi ini menjadi lebih baik. 🇮🇩

### Langkah-langkah Kontribusi:
1. **Fork** repository ini.
2. Buat **Branch** baru untuk fitur/perbaikan Anda (`git checkout -b fitur/nama-fitur`).
3. **Commit** perubahan Anda dengan pesan yang jelas dan deskriptif.
4. **Push** ke branch Anda (`git push origin fitur/nama-fitur`).
5. Buat **Pull Request** ke repository `development`.

### Panduan Singkat:
- Pastikan kode mengikuti *coding standard* Kotlin.
- Gunakan komponen UI yang sudah ada jika memungkinkan.
- Sertakan deskripsi singkat mengenai perubahan yang Anda lakukan di PR.

## 📄 Lisensi

Proyek ini dilisensikan di bawah **MIT License**. Lihat file [LICENSE](LICENSE) untuk detail lebih lanjut.

---

Mari berkolaborasi untuk akses informasi publik yang lebih baik! Jika Anda memiliki saran atau pertanyaan, jangan ragu untuk membuka *Issue* atau menghubungi saya melalui email di [fauzan.g.ramadhani@gmail.com](mailto:fauzan.g.ramadhani@gmail.com).
