
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float toplamFiyat = 0;
        double[] urunFiyatlari = {8.9, 33.45, 75.99, 126.5, 17.85, 9.90, 99.99};
        String[] urunler = {"ekmek", "yogurt", "sampuan", "camasirYumusaticisi", "cikolata", "cubukKraker", "arapSabunu"};
        boolean devam = true;

        System.out.println("---- HOSGELDINIZ ----");
        System.out.println("Ürünler:");
        for (int i = 0; i < urunler.length; i++) {
            System.out.println((i + 1) + ". " + urunler[i] + " - " + urunFiyatlari[i] + " TL");
        }
        System.out.println("");

        while (devam) {
            System.out.print("Ürün seçiniz (1-" + urunler.length + " arasında olmalı): ");
            int secim = scanner.nextInt();

            if (secim >= 1 && secim <= urunler.length) {
                System.out.print("Kaç adet " + urunler[secim - 1] + " almak istersiniz? ");
                int adet = scanner.nextInt();
                toplamFiyat += urunFiyatlari[secim - 1] * adet;
            } else {
                System.out.println("Geçersiz seçim yaptınız. Lütfen geçerli bir ürün numarası giriniz.");
            }

            System.out.println("");
            System.out.print("Başka bir ürün almak ister misiniz? (Evet: 1, Hayır: 0): ");
            int cevap = scanner.nextInt();

            if (cevap == 0) {
                devam = false;
            }
        }

        System.out.println("");
        System.out.println("Toplam tutarınız: " + toplamFiyat + " TL");

        // İndirim kuponu kontrolü
        double indirim = 0;
        System.out.print("İndirim kuponunuz var mı? (Evet: 1, Hayır: 0): ");
        int kuponCevabi = scanner.nextInt();

        switch (kuponCevabi) {  // Burada cevap değişkenini kontrol ediyoruz
            case 1:
                System.out.println("İndirim kuponu %10 olarak uygulanıyor.");
                indirim = toplamFiyat * 10 / 100;
                toplamFiyat -= indirim;
                break;
            case 0:
                System.out.println("İndirim uygulanmadı.");
                break;
            default:
                System.out.println("Geçersiz giriş.");
                break;
        }

        System.out.println("Toplam ödenecek tutar: " + toplamFiyat + " TL");
        System.out.println("Bizleri tercih ettiginiz icin tesekkürler");
        scanner.close();
    }
}