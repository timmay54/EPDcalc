/**
*Written by Tim Mardesen
* 3-6-2018
* made with algorithms found in ANSI 314
*
*/
import java.util.Scanner;
import java.lang.Math;

public class EPDcalc{
   public static void main(String[] args){
      boolean quit = false;
      Scanner scan = new Scanner(System.in);
      int selection;
      
      while(!quit){
         try{
            System.out.println("What would you like to do?: ");
            System.out.println("1. Calculate Genetic Predictions");
            System.out.println("2. Calculate blah blah");
            selection = scan.nextInt();
            if ( selection==1 ){
               calculateGeneticPredictions();
            }
         }
         catch(Exception e){//error of not being a number inside menu)
            
         }
      }
   }
   /**
   *Method for menu of making genetic predictions
   *  needs more info
   *
   */
   public static void calculateGeneticPredictions(){
      System.out.println("Number of records?");
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      System.out.println("Constant of repeatability?");
      double r = input.nextDouble();
      System.out.println(" number to mult. by?");
      double weight = input.nextDouble();
      //N = records, R = repeatability
      double fraction = (n * r) / (1 + (n-1) * r);
      
      System.out.println("the fraction is: " + fraction + "\n");
      double endAnswer = fraction * weight;
      System.out.println("the end result is: " + endAnswer + "\n" + "\n"); // Need more descriptions
      
   }
}