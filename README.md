# akilli-tedarik-ve-lojistik-sistemi
1.	Proje Konusu: Akıllı Tedarik ve Lojistik Yönetim Sistemi 
Bu proje kapsamında; karmaşık iş kurallarına sahip bir envanter ve lojistik yönetim sisteminin analiz, tasarım, gerçekleme ve test aşamalarını içeren uçtan uca bir yazılım geliştirilmesi beklenmektedir.-
Yazılım geliştirme yaşam döngüsü (SDLC) aşamalarını takip ederek, OOAD prensiplerine uygun, SOLID ilkelerini temel alan ve çeşitli Tasarım Desenleri ile desteklenmiş, test edilebilir bir yazılım sistemi geliştirmelisiniz. 

2.	Proje Senaryosu 
Bir e-ticaret lojistik merkezi, stok takibi, sipariş yönetimi, farklı kargo stratejileri ve dinamik yetkilendirme sistemine ihtiyaç duymaktadır. Sistemde farklı roller (Yönetici, Depo Görevlisi, Kurye) bulunmalı ve sistemin genişleyebilir (yeni kargo firmaları veya yeni ödeme yöntemleri eklenebilir) olması gerekmektedir.
Sistem, bir ana depo ve bu depoya bağlı çalışan farklı tedarikçi ve kargo birimlerini yönetir. Süreçler şu detaylara sahip olmalıdır:
A.	Dinamik ürün ve stok yönetimi
Sistemde hem basit ürünler (örn: kalem) hem de karmaşık/montaj gerektiren ürünler (ör: bilgisayar kasası- içinde RAM, CPU vb. barındıran) bulunmalıdır. 
Bir ürünün stoğu belirlenen eşik değerin altına düştüğünde; Satın Alma birimine e-posta, Depo sorumlusuna ise sistem içi bildirim gitmelidir.
B.	Sipariş ve Ödeme Akışı
Bir sipariş sırasıyla; Beklemede -> Onaylandı -> Hazırlanıyor -> Kargoda -> Teslim Edildi aşamalarından geçer. Bazı durumlarda (örn: ürün hatalıysa) Kargoda aşamasından direkt İade sürecine geçebilmelidir. Her durumda yapılabilecek işlemler farklıdır (Örn: Kargodaki ürün iptal edilemez, sadece iade edilebilir).
Sistem; Kredi Kartı, Havale ve ileride eklenebilecek "Kripto Ödeme" gibi yöntemleri desteklemelidir.
C.	Lojistik ve Kargo Stratejileri
Şirket "Aras", "Yurtiçi" ve "GlobalExpres" gibi farklı firmalarla çalışır. Her firmanın gönderi takip numarası üretme ve fiyatlandırma algoritması (API'si) farklıdır. Sistemin bu farklı yapıları tek bir standart arayüz üzerinden konuşmaya zorlaması gerekir.
Kargo ücreti; paketin ağırlığına, mesafeye ve seçilen ek hizmetlere (Sigortalı gönderim, Kırılacak eşya koruması vb.) göre değişir.
D.	Kullanıcı yetkilendirme ve Sistem Günlükleri 
Sisteme giriş yapan kişinin rolüne göre (Admin, Personel, Müşteri) görebileceği menüler ve yapabileceği işlemler (Metotlar) kısıtlanmalıdır.
Sistemde yapılan her kritik işlem (stok değişimi, ödeme onayı vb.) bir dosyaya veya veritabanına loglanmalıdır. Loglama nesnesinden sistem genelinde sadece bir tane olmalıdır.

Beklenti 1: Kod yazarken switch-case veya iç içe geçmiş uzun if-else bloklarından kaçınılmalıdır. İş kurallarındaki her bir 'değişim' veya 'farklılaşma', uygun bir Tasarım Deseni (Design Pattern) ile polimorfik olarak çözülmelidir. Katı (rigid) ve kırılgan kod yazan projeler, tasarım puanından feragat etmiş sayılacaktır.
Beklenti 2: Ödev raporunda; aşağıdaki verilen tablo taslağı doldurulmalıdır. 
Süreç	Karşılaşılan Problem	Seçilen Tasarım Deseni	Neden bu desen?
Sipariş aşamaları	Durum geçişlerinin karmaşıklığı ve if-else yığınları.	State Pattern	Her durumu bir sınıfa bölerek kodun okunabilirliğini ve yönetilebilirliğini artırmak için.
…			

3.	Teknik Gereksinimler ve Mimari
Uygulama Model-View-Controller (MVC) mimarisine uygun olarak katmanlandırılmalıdır. 
Tüm sistem bileşenleri kodlamaya geçilmeden önce UML 2.0 standartlarında diyagramlarla (Sınıf, kullanım durumu, sıralama, durum ve etkinlik şemaları) belgelenmelidir. 
Kod tabanı SOLID prensiplerine tam uyumlu olmalıdır. 

4.	Tasarım Desenleri Beklentisi
Aşağıdaki kategorilerden en az 6 tanesini mantıklı bir senaryo içerisinde kullanmalısınız. 
1.	Yaratımsal (Creational) Desenler (En az 2 adet): Singleton, Factory Method/ Abstract Factory, Builder
2.	 Yapısal (Structural) Desenler (En az 2 adet): Adapter, Decorator, Facade
3.	Davranışsal (Behavioral) Desenler (En az 2 adet): Observer, Strategy, Command, State
