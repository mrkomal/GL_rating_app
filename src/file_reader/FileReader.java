package file_reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    String textFilePath;

    public FileReader(String textFilePath) {
        this.textFilePath = textFilePath;
    }

    public ArrayList<String> read() {
        ArrayList<String> output = new ArrayList<>();

        try {
            if(textFilePath != null){
                File file = new File(textFilePath);
                FileInputStream fis = new FileInputStream(file);
                Scanner scanner = new Scanner(fis);

                while (scanner.hasNextLine()) {
                    output.add(scanner.nextLine());
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found!");
        }

        return output;
    }
}
