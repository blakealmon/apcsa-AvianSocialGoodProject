import java.io.File;
import java.io.FileNotFoundException;

import src.*;


public class Conductor {
    
    public static void main(String[] args) throws FileNotFoundException {

        // data runner
        DataRunner dataRunner = new DataRunner();

        // file accessor
        FileAccessor fileAccessor = new FileAccessor();

        // array with all txt filenames
        String[] txtFileNames = {"colors.txt", "diets.txt", "names.txt", "status.txt"};



        // adding txt file data to datarunner
        for(int i = 0; i < 4; i++){
            
            // setting txt filename to file accessor
            fileAccessor.setFileName(txtFileNames[i]);
            
            // colors
            if(i == 0){
                dataRunner.setColors(fileAccessor.accessFile());
            }
            // diets
            if(i == 1){
                dataRunner.setDiets(fileAccessor.accessFile());
            }
            // names
            if(i == 2){
                dataRunner.setNames(fileAccessor.accessFile());
            }
            // status
            if(i == 3){
                dataRunner.setStatus(fileAccessor.accessFile());
            }
        }
        

        // user story -> question creator
        UserStory userStory = new UserStory(dataRunner.getColors(), dataRunner.getDiets(), dataRunner.getNames(), dataRunner.getStatus());

        // array with all questions
        String[] questions = userStory.questions();


       
    }
}
