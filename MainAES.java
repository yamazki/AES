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
  private static final String KEY = "1234567890abcdef";
  private static final String ALGORITHM = "AES";
    public static void main(String [] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
    String source = "test";
    try {
      String encrypt = CipherManager.encrypt(source, KEY, ALGORITHM);
      String decrypt = CipherManager.decrypt(encrypt, KEY, ALGORITHM);
      String hash = Hash.hashGanerate(encrypt, "MD5");
      Object object = new Object(encrypt, hash);
      System.out.println(Hash.hashCheck(object.getEncryptData(),object.getHashValue(), "MD5"));
      System.out.println(object.getEncryptData());
      System.out.println(object.getHashValue());
      System.out.println("hash: " + hash);
    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
      Logger.getLogger(MainAES.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}



