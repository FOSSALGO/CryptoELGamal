package crypto;

import java.math.BigInteger;

public class ElGamal {

    public Output encrypt(String message, String kunciPublik, String sPrime, String kunciPrivat) {
        Output result = null;
        String sG = "2";
        try {
            //PROSES PEMBANGKITAN KUNCI
            BigInteger p = new BigInteger(sPrime);//Bilangan Prima - tidak rahasia
            BigInteger g = new BigInteger(sG);//Bilangan Acak - tidak rahasia
            BigInteger x = new BigInteger(kunciPrivat);//Kunci Private - rahasia
            BigInteger y = g.modPow(x, p);//Kunci Public - tidak rahasia

            //PROSES ENCRYPT
            BigInteger m = new BigInteger(message);
            BigInteger k = new BigInteger(kunciPublik);

            //Proses Encrypt
            BigInteger a = g.modPow(k, p);
            BigInteger b = m.multiply(y.modPow(k, p)).mod(p);

            //SET OUTPUT terdiri dari ciphertext_a dan ciphertext_b
            result = new Output(a.toString(), b.toString());
        } catch (Exception e) {
            System.out.println("GAGAL melakukan ENKRIPSI");
            e.printStackTrace();
        }
        return result;
    }

    public Output decrypt(String ciphertext_a, String ciphertext_b, String sPrime, String kunciPrivat) {
        Output result = null;
        try {
            BigInteger a = new BigInteger(ciphertext_a);//Cihertext-a - tidak rahasia
            BigInteger b = new BigInteger(ciphertext_b);//Cihertext-b - tidak rahasia
            BigInteger p = new BigInteger(sPrime);//Bilangan Prima - tidak rahasia
            BigInteger x = new BigInteger(kunciPrivat);//Kunci Private - rahasia
            //Proses Decrypt        
            BigInteger aPowx = a.modPow(x, p);
            BigInteger aPowx_inverse = aPowx.modInverse(p);
            BigInteger m= b.multiply(aPowx_inverse).mod(p);
            result = new Output(m.toString());
        } catch (Exception e) {
            System.out.println("GAGAL melakukan DEKRIPSI");
            e.printStackTrace();
        }
        return result;
    }

}
