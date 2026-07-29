# WhatsApp Business Alarm

WhatsApp Business bildirimlerinde kullanıcının uygulama içinden kaydettiği metni arar. Eşleşme olduğunda medya ve alarm sesini en yüksek seviyeye getirip varsayılan alarm sesini döngü halinde çalar.

İlk açılıştaki varsayılan tetikleyici **Gazipaşa** kelimesidir.

Tetikleyici uygulama içinden istenildiği zaman değiştirilebilir. Örnekler:

- `Gazipaşa`
- `10:50 Alanya AYT`
- `Mahmutlar AYT`

Eşleşmede büyük-küçük harf ve Türkçe karakter farkı önemsenmez. Örneğin `Gazipaşa`, `GAZIPASA` ve `gazipasa` eşleşir. Girilen ifade bildirim metninin içinde aynı sırayla bulunmalıdır.

## Kurulum

1. Android Studio'da klasörü açın.
2. Gradle eşitlemesini yapın.
3. Telefona yükleyin.
4. Uygulamayı açıp **Bildirim erişimini aç** düğmesine basın.
5. Listeden **WhatsApp İş Alarmı** için erişimi açın.
6. Alarm metnini yazıp **Tetikleyiciyi kaydet** düğmesine basın.
7. Samsung'da Ayarlar > Uygulamalar > WhatsApp İş Alarmı > Pil > Kısıtlanmamış seçilmesi yararlı olabilir.

Alarm, uygulamadaki **Alarmı durdur** düğmesiyle durur.
