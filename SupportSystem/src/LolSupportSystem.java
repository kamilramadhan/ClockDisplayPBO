import java.util.Scanner;

public class LolSupportSystem {
    private InputReader inputReader;
    private ComedyResponder responder;

    public LolSupportSystem() {
        this.inputReader = new InputReader();
        this.responder = new ComedyResponder();
    }

    public void start() {
        System.out.println("Selamat datang di Sistem Dukungan Teknis Kocak!");
        System.out.println("Ayok ceritain masalahmu, kita cari solusinya bareng-bareng!");
        System.out.println("Ketik 'lol' buat keluar dari sistem ini.");

        while (true) {
            String userInput = inputReader.readInput();
            if (userInput.equalsIgnoreCase("lol")) {
                System.out.println("Haha, sampai jumpa!");
                break;
            } else {
                String response = responder.generateComedicResponse(userInput);
                System.out.println(response);
            }
        }
    }

    public static void main(String[] args) {
        LolSupportSystem lolSupportSystem = new LolSupportSystem();
        lolSupportSystem.start();
    }
}

class InputReader {
    private Scanner scanner;

    public InputReader() {
        this.scanner = new Scanner(System.in);
    }

    public String readInput() {
        System.out.print("Anda: ");
        return scanner.nextLine();
    }
}

class ComedyResponder {
    public String generateComedicResponse(String userInput) {
        // Implementasi logika menghasilkan respons yang lucu berdasarkan input pengguna
        if (userInput.contains("simpan file")) {
            return "Wah, file kamu terlalu berat buat disimpan nih. Coba ganti ke format komik aja deh!";
        } else if (userInput.contains("crash")) {
            return "Waduh, komputernya habis makan taco nih kayaknya. Coba tambahin bumbu cabe biar nggak ngadat lagi!";
        } else {
            return "Hmm, kayaknya kamu belum minum kopi pagi nih. Mau kubuatin kopi susu+permen karet?";
        }
    }
}
