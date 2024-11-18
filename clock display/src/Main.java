public class Main {
    public static void main(String[] args) {
        // Membuat objek jam dengan waktu awal 00:00
        ClockDisplay clock1 = new ClockDisplay();
        System.out.println("Clock1 initial time: " + clock1.getTime());

        // Membuat objek jam dengan waktu awal 15:30
        ClockDisplay clock2 = new ClockDisplay(15, 30);
        System.out.println("Clock2 initial time: " + clock2.getTime());

        // Menjalankan clock1 selama beberapa menit
        System.out.println("\nRunning clock1 for 5 minutes:");
        for(int i = 0; i < 5; i++) {
            clock1.timeTick();
            System.out.println("Clock1 time: " + clock1.getTime());
        }

        // Mengatur waktu baru untuk clock2
        System.out.println("\nSetting new time for clock2:");
        clock2.setTime(23, 58);
        System.out.println("Clock2 new time: " + clock2.getTime());

        // Menjalankan clock2 melewati tengah malam
        System.out.println("\nRunning clock2 past midnight:");
        for(int i = 0; i < 3; i++) {
            clock2.timeTick();
            System.out.println("Clock2 time: " + clock2.getTime());
        }
    }
}