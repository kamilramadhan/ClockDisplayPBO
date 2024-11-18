import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MusicOrganizer organizer = new MusicOrganizer();
        Scanner scanner = new Scanner(System.in);

        int pilihan;

        do {
            System.out.println("\n=== Music Organizer ===");
            System.out.println("1. Tambah Lagu");
            System.out.println("2. Hapus Lagu");
            System.out.println("3. Tampilkan Daftar Lagu");
            System.out.println("4. Cari Lagu");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Mengonsumsi newline

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan judul lagu: ");
                    String judul = scanner.nextLine();
                    System.out.print("Masukkan nama artis: ");
                    String artis = scanner.nextLine();
                    System.out.print("Masukkan nama album: ");
                    String album = scanner.nextLine();
                    organizer.tambahLagu(new Lagu(judul, artis, album));
                    break;
                case 2:
                    System.out.print("Masukkan judul lagu yang ingin dihapus: ");
                    String judulHapus = scanner.nextLine();
                    organizer.hapusLagu(judulHapus);
                    break;
                case 3:
                    organizer.tampilkanDaftarLagu();
                    break;
                case 4:
                    System.out.print("Masukkan judul lagu yang ingin dicari: ");
                    String judulCari = scanner.nextLine();
                    organizer.cariLagu(judulCari);
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan Music Organizer!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan != 5);

        scanner.close();
    }
}
