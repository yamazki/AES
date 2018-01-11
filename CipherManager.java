import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class CipherManager {
  public static String encrypt(String source, String key, String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    Cipher cipher = Cipher.getInstance(algorithm);
    cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key.getBytes(), algorithm));
    return new String(Base64.getEncoder().encode(cipher.doFinal(source.getBytes())));
  }

  public static String decrypt(String encryptSource, String key, String algorithm) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
    Cipher cipher = Cipher.getInstance(algorithm);
    cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key.getBytes(), algorithm));
    return new String(cipher.doFinal(Base64.getDecoder().decode(encryptSource.getBytes())));
  }

  public static String readFile(String filename) {
    try {
      File file = new File(filename);
      BufferedReader br = new BufferedReader(new FileReader(file));
      String line = br.readLine();
      String allLine = "";
      while (line != null) {
      allLine = allLine + line;
      line = br.readLine();
      }
      return allLine;
    } catch (Exception e) {
    }
   return null;
  }  

  public static String readPem (String filename) {
    
    
  return null;
  }
}
