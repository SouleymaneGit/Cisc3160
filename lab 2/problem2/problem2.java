import java.util.Scanner;
import java.io.PrintStream;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;

class WeatherForecaste{

  public static void main(String[] args) {
    Scanner sc;
    PrintStream ps;
    try {
      ArrayList<Double> temperature = new ArrayList<>(); // store the temperatures

      sc = new Scanner(new File("forecast_data.csv"));
      ps = new PrintStream("output2.txt");
      ps.println("\nTemperature ( °F)             Temperature(°C)  \n"); 
      while (sc.hasNextLine()) {
         String line = sc.nextLine();
         temperature.add(Filter(line));
      }

          temperature.forEach((n) ->ps.printf("    %.2f                         %.2f\n",n,convertionToCelsuis(n))); 
      

            sc.close(); // closing of the Scanner class
            ps.close(); // closing of the PrintStream class
    } 
    catch (FileNotFoundException e) {
        
            e.printStackTrace();
    }
    }
  

    // the function below helps to get the temperature  and return it as a double
    public static  Double Filter(String line){

      ArrayList<Integer> IndiceOfComma = new ArrayList<Integer>();
      int countQuote = 0; // to count the number of quote that we ancounter in order to get the position of the right commas(which seperate the colunms).
     for(int i=0; i<line.length(); i++){
        
        if(line.charAt(i) == '\"'){
          if(countQuote == 0) countQuote++;
          else countQuote = 0;
        } 
        if(line.charAt(i) == ','){
          if(countQuote == 0)IndiceOfComma.add(i);
        }  
     }

     String result= line.substring(IndiceOfComma.get(3), IndiceOfComma.get(4)); 
             result = result.substring(1,result.length());
     
     return Double.parseDouble(result) ;
   }
   //  the function below helps convert the temperature from fahrenheit to celsius by using the formuler T(°C) = (T(°F) - 32) × 5/9 
  public static Double convertionToCelsuis(Double temperature){
    
    return (temperature - 32) * 5/9;

  }
}
