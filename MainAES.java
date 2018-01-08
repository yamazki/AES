import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainAES {
  private static final String KEY = "YKo83n14SWf7o8G5";
  private static final String ALGORITHM = "AES";
    public static void main(String [] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
    try {
      String source = "test";
      String encrypt = CipherManager.encrypt(source, KEY, ALGORITHM);
      String decrypt = CipherManager.decrypt(encrypt, KEY, ALGORITHM);
      System.out.println("Source: "  + source);
      System.out.println("Encrypt: " + encrypt);
      System.out.println("Decrypt: " + decrypt);
      String hash = Hash.hashGanerate(encrypt, "MD5");
      System.out.println("hash: " + hash);
    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
      Logger.getLogger(MainAES.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}



