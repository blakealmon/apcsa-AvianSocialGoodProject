// imports
import java.io.IOException;
import java.util.Scanner;
import src.*;


public class Conductor {
    
    public static void main(String[] args) throws IOException, InterruptedException {

        
        String apiKey = "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";

        System.out.println("Welcome to the avian social good project\nThis project has questions created by chatgpt, you can run it over and over to get more questions");
        System.out.println("Please type the ammount of questions you want (no greater than 30)");

        Scanner myScanner = new Scanner(System.in);

        int input = myScanner.nextInt();

        System.out.println("Thank you for the input, the questions will take some time to generate");

        myScanner.close();

        // data runner
        DataRunner dataRunner = new DataRunner();
        // file accessor
        FileAccessor fileAccessor = new FileAccessor();
        

        // relative path
        String path = "./txtfiles/";

        // array with all txt filenames
        String[] txtFileNames = {path + "colors.txt", path +  "diets.txt", path + "names.txt", path + "status.txt"};


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

        // questions done

        // String with all questions from chatGPT
        String rawQuestions = userStory.questions(input, apiKey);

        //getting valuable information out of questions var without using json (I have to download it)
        
        // removing top part of json in questions
        String removedTopPartQuestions = rawQuestions.substring(248);

        // removing bottom part of json in questions by finding where the json starts again after questions
        int x = 0;

        while(removedTopPartQuestions.substring(x, x+1) != "\""){
            if(removedTopPartQuestions.substring(x, x+1).equals("\"")){
                break;
            }
            x++;
        }

        // questions without json
        String onlyQuestions = removedTopPartQuestions.substring(0, x);

        // removing format from - https://stackoverflow.com/questions/2163045/how-to-remove-line-breaks-from-a-file-in-java
      
        System.out.println(onlyQuestions);

        

    }
}
