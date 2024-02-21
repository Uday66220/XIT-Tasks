
//Copy text file to another text file
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.*;

public class FileCopy {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        File source = new File("Source.txt");
        File destination = new File("destination.txt");
        Copycontent(source, destination);
    }

    public static void Copycontent(File source, File destination) throws Exception {
        FileInputStream in = new FileInputStream(source);
        FileOutputStream out = new FileOutputStream(destination);
        try {
            int n;
            while ((n = in.read()) != -1) {
                out.write(n);
            }
        } finally {
            in.close();
            out.close();
        }
        System.out.println("File copied");

    }
}
