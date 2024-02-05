package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileAccessor {

    // filename
    private String fileName;
    
    // object
    public FileAccessor(String fileName){
        this.fileName = fileName;
    }

    // set filename
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // accessing file
    public String[] accessFile() throws FileNotFoundException{

        // array that will be returned
        String[] returnedArray = new String[98];

        // counter for array position
        int counter = 0;

        // accessing file and adding each line to array
        File myObj = new File("txtfiles/" + fileName);
        
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            returnedArray[counter] = data;
            counter++;
        }
        myReader.close();

        // returning new array
        return returnedArray;
    }
}
