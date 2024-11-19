// Kelas utama untuk sistem dukungan teknis
import java.util.Scanner;
import java.util.HashMap;

class SistemDukunganTeknis {
    private PembacaInput pembacaInput;
    private Responder responder;

    public SistemDukunganTeknis() {
        pembacaInput = new PembacaInput();
        responder = new Responder();
    }

    public void mulai() {
        System.out.println("Selamat datang di Sistem Dukungan Teknis!");
        System.out.println("Ketik 'keluar' untuk mengakhiri sesi.");

        boolean selesai = false;
        while (!selesai) {
            String input = pembacaInput.bacaBaris();
            if (input.equalsIgnoreCase("keluar")) {
                selesai = true;
            } else {
                String tanggapan = responder.berikanTanggapan(input);
                System.out.println(tanggapan);
            }
        }

        System.out.println("Terima kasih telah menggunakan Sistem Dukungan Teknis. Sampai jumpa!");
    }
}

// Kelas untuk membaca input pengguna
class PembacaInput {
    private Scanner scanner;

    public PembacaInput() {
        scanner = new Scanner(System.in);
    }

    public String bacaBaris() {
        System.out.print("> ");
        return scanner.nextLine();
    }
}

// Kelas untuk memberikan tanggapan berdasarkan input pengguna
class Responder {
    private HashMap<String, String> tanggapan;

    public Responder() {
        tanggapan = new HashMap<>();
        muatTanggapan();
    }

    private void muatTanggapan() {
        tanggapan.put("file tidak bisa disimpan", "Pastikan Anda memiliki izin menulis pada folder tersebut.");
        tanggapan.put("aplikasi sering macet", "Coba perbarui aplikasi ke versi terbaru.");
        tanggapan.put("komputer lambat", "Periksa apakah ada terlalu banyak aplikasi berjalan di latar belakang.");
        tanggapan.put("printer tidak merespon", "Pastikan printer terhubung dengan benar dan driver telah diinstal.");
        tanggapan.put("layar tidak menyala", "Periksa koneksi kabel daya dan coba tekan tombol power.");
        tanggapan.put("internet lambat", "Coba restart router Anda atau hubungi penyedia layanan internet.");
        tanggapan.put("suara tidak keluar", "Periksa apakah volume diatur dengan benar dan perangkat audio terhubung.");
        tanggapan.put("tidak bisa masuk akun", "Pastikan Anda menggunakan nama pengguna dan kata sandi yang benar.");
        tanggapan.put("email tidak terkirim", "Periksa koneksi internet dan pastikan alamat email tujuan benar.");
        tanggapan.put("baterai cepat habis", "Kurangi kecerahan layar dan tutup aplikasi yang tidak diperlukan.");
    }

    public String berikanTanggapan(String masalah) {
        for (String kunci : tanggapan.keySet()) {
            if (masalah.toLowerCase().contains(kunci)) {
                return tanggapan.get(kunci);
            }
        }
        return "Mohon ceritakan lebih detail mengenai masalah Anda.";
    }
}

// Kelas untuk menjalankan program
public class Main {
    public static void main(String[] args) {
        SistemDukunganTeknis sistem = new SistemDukunganTeknis();
        sistem.mulai();
    }
}
