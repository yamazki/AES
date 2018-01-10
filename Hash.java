import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;

public class Hash {

  public static String hashGanerate(String source, String algorithm)throws UnsupportedEncodingException, NoSuchAlgorithmException {
    Charset charset = StandardCharsets.UTF_8;
    byte[] bytes = MessageDigest.getInstance(algorithm).digest(source.getBytes(charset));
    String result = DatatypeConverter.printHexBinary(bytes);
    return result;
   }

  public static boolean hashCheck (String data, String hashValue, String algorithm) throws UnsupportedEncodingException, NoSuchAlgorithmException{
    if (hashValue.equals(hashGanerate(data,algorithm))){
      return true;
    }
    else {
      return false;
    }
  }
}
