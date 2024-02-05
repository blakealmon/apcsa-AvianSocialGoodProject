package src;


public class DataRunner {

    // instance variables
    private String[] colors;
    private String[] diets;
    private String[] names;
    private String[] status;

    // object without parameters
    public DataRunner(){

    }

    // object with parameters
    public DataRunner(String[] colors, String[] diets, String[] names, String[] status){

        this.colors = colors;
        this.diets = diets;
        this.names = names;
        this.status = status;
    
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


    // to string with all data
    public String toString() {
        
        String listOfData = "";
        for(int a = 0; a < 98; a++){
            listOfData = listOfData + ", " + names[a];
        }
        for(int a = 0; a < 98; a++){
            listOfData = listOfData + ", " + diets[a];
        }
        for(int a = 0; a < 98; a++){
            listOfData = listOfData + ", " + colors[a];
        }
        for(int a = 0; a < 98; a++){
            listOfData = listOfData + ", " + status[a];
        }
       
      
        return listOfData;
    }
}
