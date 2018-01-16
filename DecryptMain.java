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
import java.util.ArrayList;

public class DecryptMain {

  private static final String ALGORITHM = "AES";

  public static void main(String [] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
    String KEY = CipherManager.readFile("./key/key");
    ArrayList<String> fileObject = FileManager.getFileContentsList("test.txt");
    System.out.println(fileObject);
    try {
      String decrypt = CipherManager.decrypt(fileObject.get(0), KEY, ALGORITHM);
      String hash = Hash.hashGanerate(decrypt, "MD5");
      System.out.println(fileObject.get(1));
      System.out.println(Hash.hashCheck(decrypt, fileObject.get(1), "MD5"));
      System.out.println(decrypt);
    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
      Logger.getLogger(MainAES.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}




