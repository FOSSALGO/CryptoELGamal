package crypto;

import java.util.Scanner;

public class Main {

    //bilangan prima di set secara hardkoding
    //untuk generate bilangan prima bisa dilihat di: https://bigprimes.org/
    //String sPrime = "716989511441211045742201237159752396815648847047842134710243893383233867576941932039217734411988198241869358979939222807441691290551407580319031513839295262958219633389352614319921885253930146769104801527624822271333636286290364437001284336468225798032985491499512786659279757123359333313591292841531";
    public static String ssPrime = "5963195521";

    public static void main(String[] args) {
        ElGamal elgamal = new ElGamal();

        boolean running = true;

        while (running) {
            Scanner sc = new Scanner(System.in);
            String sOperation = null;
            System.out.println("====================================");
            System.out.println("Pilih Operasi");
            System.out.println("[E] = Encrypt");
            System.out.println("[D] = Decrypt");
            System.out.println("[X] = Exit");
            System.out.println("====================================");
            System.out.print("Operasi yang anda pilih: ...? ");
            sOperation = sc.nextLine();
            if (sOperation.equalsIgnoreCase("E")) {
                System.out.println("\nANDA MEMILIH OPERASI ENKRIPSI");
                System.out.println("------------------------------------");
                System.out.print("Input Pesan       :");
                String message = sc.nextLine();

                System.out.print("Input Kunci Publik: ");
                String kunciPublik = sc.nextLine();

                //bilangan prima di set secara hardkoding
                //untuk generate bilangan prima bisa dilihat di: https://bigprimes.org/
                String sPrime = ssPrime;

                System.out.print("Input Kunci Privat: ");
                String kunciPrivat = sc.nextLine();

                System.out.println("------------------------------------");
                Output out = elgamal.encrypt(message, kunciPublik, sPrime, kunciPrivat);
                System.out.println("Hasil Enkripsi:");
                System.out.println("Ciphertext-a  : " + out.ciphertext_a);
                System.out.println("Ciphertext-b  : " + out.ciphertext_b);
                System.out.println("------------------------------------");
            } else if (sOperation.equalsIgnoreCase("D")) {
                System.out.println("\nANDA MEMILIH OPERASI DEKRIPSI");
                System.out.println("------------------------------------");
                System.out.print("Input Ciphertext-a: ");
                String ciphertext_a = sc.nextLine();
                
                System.out.print("Input Ciphertext-b: ");
                String ciphertext_b = sc.nextLine();
                
                String sPrime = ssPrime;
                
                System.out.print("Input Kunci Privat: ");
                String kunciPrivat = sc.nextLine();
                System.out.println("------------------------------------");
                Output out = elgamal.decrypt(ciphertext_a, ciphertext_b, sPrime, kunciPrivat);
                System.out.println("Hasil Dekripsi:");
                System.out.println("Pesan: "+out.message);
                System.out.println("------------------------------------");
            } else if (sOperation.equalsIgnoreCase("X")) {
                System.out.println("PROSES DIAKHIRI");
                running = false;
            } else {
                System.err.println("\nOPERASI YANG ANDA PILIH TIDAK DIKENALI");
            }
        }
    }
}
