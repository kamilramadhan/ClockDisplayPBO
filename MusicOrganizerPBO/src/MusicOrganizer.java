import java.util.ArrayList;
import java.util.List;

public class MusicOrganizer {
    private List<Lagu> daftarLagu;

    public MusicOrganizer() {
        daftarLagu = new ArrayList<>();
    }

    public void tambahLagu(Lagu lagu) {
        daftarLagu.add(lagu);
        System.out.println("Lagu \"" + lagu.getJudul() + "\" berhasil ditambahkan!");
    }

    public void hapusLagu(String judul) {
        boolean ditemukan = false;
        for (int i = 0; i < daftarLagu.size(); i++) {
            if (daftarLagu.get(i).getJudul().equalsIgnoreCase(judul)) {
                daftarLagu.remove(i);
                System.out.println("Lagu \"" + judul + "\" berhasil dihapus!");
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Lagu \"" + judul + "\" tidak ditemukan!");
        }
    }

    public void tampilkanDaftarLagu() {
        if (daftarLagu.isEmpty()) {
            System.out.println("Daftar lagu kosong.");
        } else {
            System.out.println("Daftar Lagu:");
            for (Lagu lagu : daftarLagu) {
                System.out.println(lagu);
            }
        }
    }

    public void cariLagu(String judul) {
        boolean ditemukan = false;
        for (Lagu lagu : daftarLagu) {
            if (lagu.getJudul().equalsIgnoreCase(judul)) {
                System.out.println("Lagu ditemukan: " + lagu);
                ditemukan = true;
                break;
            }
        }
        if (!ditemukan) {
            System.out.println("Lagu \"" + judul + "\" tidak ditemukan!");
        }
    }
}
