public class Object {
  private final String encryptData;
  private final String hashValue;

  Object (String encryptData, String hashValue) {
    this.encryptData = encryptData;
    this.hashValue   = hashValue;
  }

  String getEncryptData() {
    return encryptData;   
  }

  String getHashValue() {
    return hashValue;   
  }
}
