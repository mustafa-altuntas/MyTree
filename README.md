# Tree - Trie Tabanlı Kelime Öneri Sistemi

Java ile geliştirilmiş, Trie veri yapısını kullanan interaktif kelime öneri uygulaması. Kullanıcıdan aldığı önek ile başlayan tüm kelimeleri bulup sıralar.

## 🚀 Özellikler

- **Trie Veri Yapısı**: Verimli kelime arama ve saklama
- **Önek Tabanlı Arama**: Girilen önek ile başlayan tüm kelimeleri bulur
- **Sıralı Sonuçlar**: Bulunan kelimeler alfabetik sırada gösterilir
- **Interaktif Kullanım**: Konsol üzerinden kullanıcı dostu arayüz
- **Docker Desteği**: Container teknolojisi ile kolay dağıtım

## 📁 Proje Yapısı

```
Tree/
├── src/
│   ├── MyTree.java
│   ├── Tree.java
│   ├── TrieNode.java
│   ├── IWordSource.java
│   └── FileWordSource.java
├── sozluk.txt
├── Dockerfile
├── docker-compose.yml
└── README.md
```

## 🛠️ Teknolojiler

- **Java 21** - Ana programlama dili
- **Eclipse Temurin JDK/JRE** - Java runtime environment
- **Docker** - Containerization
- **Docker Compose** - Multi-container yönetimi

## 📋 Gereksinimler

### Yerel Çalıştırma
- Java 21
- JDK (derleme için)

### Docker ile Çalıştırma
- Docker
- Docker Compose

## 🚀 Kurulum ve Çalıştırma

### Docker ile Çalıştırma (Önerilen)

1. **Projeyi klonlayın:**
   ```bash
   git clone https://github.com/mustafa-altuntas/MyTree
   ```

   ```bash
   cd MyTree
   ```

2. **Container'ı build edin ve çalıştırın:**
   ```bash
   docker compose up -d
   ```

3. **Interaktif modda çalıştırın:**
   ```bash
   docker compose exec mytree-app java -jar mytree.jar sozluk.txt
   ```


### Yerel Çalıştırma

1. **Projeyi klonlayın:**
   ```bash
   git clone https://github.com/mustafa-altuntas/MyTree
   ```

   ```bash
   cd MyTree
   ```

2. **Projeyi derleyin:**
   ```bash
   javac -d out src/*.java
   ```

3. **Uygulamayı Çalıştır ve Komut Satırı Argümanını Gönder:**
   ```bash
   java -cp out MyTree sozluk.txt
   ```

## 📚 Kullanım

Uygulama başladığında:

1. Sözlük yüklenir ve toplam kelime sayısı gösterilir
2. Bir önek (kelime başlangıcı) girin
3. O önek ile başlayan tüm kelimeler alfabetik sırada listelenir
4. `0` yazarak programdan çıkabilirsiniz

### Örnek Kullanım

```
Sözlük Yüklendi. (15423 kelime)

Bir Kelime Yazıp Enter Tuşuna Basınız (çıkmak için '0' yazın):
> Delete

Olası Kelimeler:
DELETE
DELETED
DELETERIOUS
DELETERIOUSLY
DELETERIOUSNESS
DELETES

Bir Kelime Yazıp Enter Tuşuna Basınız (çıkmak için '0' yazın):
> Browse
Olası Kelimeler:
BROWSE
BROWSED
BROWSER
BROWSERS
BROWSES
```

