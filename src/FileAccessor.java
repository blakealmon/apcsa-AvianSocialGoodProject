package src;

import java.io.BufferedReader;
// imports
import java.io.FileReader;
import java.io.IOException;

public class FileAccessor {

    // filename
    private String fileName;

    // object without parameters
    public FileAccessor(){

    }
    
    // object with parameters
    public FileAccessor(String fileName){
        this.fileName = fileName;
    }

    // set filename
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    // accessing file
    public String[] accessFile() throws IOException{

        // array that will be returned
        String[] returnedArray = new String[98];

   

        // accessing file and adding each line to array
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String currentLine = reader.readLine();

        // counter for array position
        int counter = 0;

        while(currentLine != null){
            returnedArray[counter] = currentLine;

            counter++;
            currentLine =reader.readLine();
        }

        reader.close();

        // returning new array
        return returnedArray;
    }
}
