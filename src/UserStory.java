package src;

// imports
import java.util.Scanner;

// imports needed for openai request
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

// json imports


public class UserStory {

    // instance variables
    String[] colors;
    String[] diets;
    String[] names;
    String[] status;
    
    // object without parameters
    public UserStory(){

    }

    // object with parameters
    public UserStory(String[] colors, String[] diets, String[] names, String[] status){
        this.colors = colors;
        this.diets = diets;
        this.names = names;
        this.status = status;
    }



    // creating questions
    public String questions(int input) throws IOException, InterruptedException{

        //turning arrays in strings
        String namesList = "Names :";
        String colorsList = "Colors :";
        String dietsList = "Diets :";
        String statusList = "Status :";

        for(int i = 0; i < 4; i++){

            if(i == 0){
                for(int a = 0; a < 98; a++){
                    namesList = namesList + ", " + names[a];
                }
            }
            if(i == 1){
                for(int a = 0; a < 98; a++){
                    colorsList = colorsList + ", " + colors[a];
                }
            }
            if(i == 2){
                for(int a = 0; a < 98; a++){
                    dietsList = dietsList + ", " + diets[a];
                }
            }
            if(i == 3){
                for(int a = 0; a < 98; a++){
                    statusList = statusList + ", " + status[a];
                }
            }

        }


        // Using ChatGPT to help
        // code got from curl request -> https://www.baeldung.com/spring-boot-chatgpt-api-openai
        // website for converting curl to java -> https://www.scrapingbee.com/curl-converter/java/

        @SuppressWarnings("deprecation")
        URL url = new URL("https://api.openai.com/v1/chat/completions");
		HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
		httpConn.setRequestMethod("POST");

		httpConn.setRequestProperty("Content-Type", "application/json");
		httpConn.setRequestProperty("Authorization", "Bearer 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");

		httpConn.setDoOutput(true);
		OutputStreamWriter writer = new OutputStreamWriter(httpConn.getOutputStream());

        // chat gpt prompt
        String prompt = "By using this data create multiple choice questions that do not repeat answers or birds, for these birds (they correlate to their position in the list), give me" +  input +  "questions, while only using the data given. [DO NOT INCLUDE FORMATTING and INCLUDE ANSWER KEY AT BOTTOM] " + namesList + ". " + colorsList + ". " + dietsList + ". " + statusList;

		writer.write("{\n    \"model\": \"gpt-3.5-turbo\",\n    \"messages\": [{\"role\": \"user\", \"content\": \""+prompt+"\"}]\n  }");
		writer.flush();
		writer.close();
		httpConn.getOutputStream().close();

		InputStream responseStream = httpConn.getResponseCode() / 100 == 2
				? httpConn.getInputStream()
				: httpConn.getErrorStream();
		Scanner s = new Scanner(responseStream).useDelimiter("\\A");
		String response = s.hasNext() ? s.next() : "";



        s.close();

        return response;
    }







    // getters
    public String[] getColors() {
        return colors;
    }
    public String[] getDiets() {
        return diets;
    }
    public String[] getNames() {
        return names;
    }
    public String[] getStatus() {
        return status;
    }

    // setters
    public void setColors(String[] colors) {
        this.colors = colors;
    }
    public void setDiets(String[] diets) {
        this.diets = diets;
    }
    public void setNames(String[] names) {
        this.names = names;
    }
    public void setStatus(String[] status) {
        this.status = status;
    }
    
}
