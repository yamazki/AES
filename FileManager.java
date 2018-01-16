import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

  public static ArrayList<String> getFileContentsList(String fileName) {
    ArrayList<String> fileList = new ArrayList<String>();
    try{
      File file = new File(fileName);
      BufferedReader br = new BufferedReader(new FileReader(file));
      fileList.add(br.readLine());
      while(true){
        fileList.add(br.readLine());
        if (fileList.get(fileList.size() - 1) == null){
          break;
        }
      }
      br.close();
    }catch(FileNotFoundException e){
      System.out.println(e);
    }catch(IOException e){
      System.out.println(e);
    }
    return fileList;
  }

  public static void writeFile (String fileName, Boolean mode, Object object) {
    try {
      FileWriter fw = new FileWriter(fileName,mode);
      fw.write(object.getEncryptData() + "\r\n");
      fw.write(object.getHashValue()   + "\r\n");
      fw.close();
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
