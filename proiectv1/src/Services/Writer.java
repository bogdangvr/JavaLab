package Services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Writer {

    private static String BASE_PATH;
    private static Writer single_instance = null;

    private Writer(){
        BASE_PATH = "./src/Files/";
    }

    public static Writer getInstance(){
        if (single_instance == null)
            single_instance = new Writer();
        return single_instance;
    }

    public void write(String toWrite) throws IOException {
        FileWriter fw;
        File file = new File(BASE_PATH + "output.csv");
        if (file.exists()){
            fw = new FileWriter(file, true);
        }
        else{
            file.createNewFile();
            fw = new FileWriter(file, true);
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
        Date date = new Date();
        fw.append(toWrite);
        fw.append(", ");
        fw.append(dateFormat.format(date));
        fw.append('\n');
        fw.flush();
        fw.close();
    }
}