package crypto;

public class Output {
    public String message = null;
    public String ciphertext_a = null;
    public String ciphertext_b = null;
    
    public Output(String ciphertext_a, String ciphertext_b){
        this.message = null;
        this.ciphertext_a = ciphertext_a;
        this.ciphertext_b = ciphertext_b;
    }
    
    public Output(String message){
        this.message = message;
        this.ciphertext_a = null;
        this.ciphertext_b = null;
    }
}
