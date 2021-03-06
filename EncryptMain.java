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

public class EncryptMain {

  private static final String ALGORITHM = "AES";

  public static void main(String [] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
    String source = "test";
    String KEY = CipherManager.readFile("./key/key");
    try {
      String encrypt = CipherManager.encrypt(source,  KEY, ALGORITHM);
      String hash = Hash.hashGanerate(source, "MD5");
      Object object = new Object(encrypt, hash);
      System.out.println(FileManager.getFileContentsList("./key/key"));
      FileManager.writeFile("test.txt",false,object);
      System.out.println(object.getHashValue());
    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
      Logger.getLogger(MainAES.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}

