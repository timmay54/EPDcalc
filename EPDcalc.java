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

      //Average values for Cattle 
      int calvingInterval  = 380;   //days
      int calvingIntervalDEV = 20;  //days
      double calvingIntervalHeritability = 0.05; //percentage

      int gestationPeriod  = 283;   //days
      int gestationPeriodDEV = 14;  //days
      //double gestationPeriodHeritability = ???????? //percentage

      int birthWeight      = 80;    //pounds
      int birthWeightDEV     = 10;    //pounds
      double birthWeightHeritability = 0.4; // percentage

      int weaningWeight    = 475;   //pounds
      int weaningWeightDEV   = 50;    //pounds
      double weaningWeightHeritability = 0.3; //percentage

      float feedConversion = 7.00;  //pounds (feed per gain)
      float feedConversionDEV= 0.5;  //pounds (feed per gain)
      double feedConversionHeritability = 0.4; //percentage

      double backFat       = 0.4;    //inches
      double backFatDEV      = 0.1;  //inches
      double backFatHeritability = 0.4; //percentage


      
      while(!quit){
         try{
            System.out.println("What would you like to do?: ");
            System.out.println("1. Calculate Genetic Predictions");
            System.out.println("2. Calculate Adjusted Weaning Weight");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");





            selection = scan.nextInt();
            if ( selection==1 ){
               geneticPredictions();
            }
            else if ( selection == 2){
               adjustedWeaning();
            }
            
            if (selection != 1 || selection!=2){
               throw new Exception();
            }
         }
         catch(Exception e){//error of not being a number inside menu)
            System.out.println("That was not an option, please enter an integer.\n");
         }
      }
   }
   /**
   *Method for menu of making genetic predictions
   *based on repeatability coefficients
   *
   *needs better variable name
   */
   public static void geneticPredictions(){
      //Reapeatability Constants
      //Probably could print a table of these values
      double calvingDateR = 0.35;
      double birthWeightR = 0.2;
      double weaningWeightR = 0.4;
      double bodyMeasurements = 0.8; //What is this???




      System.out.println("Number of records?");
      Scanner input = new Scanner(System.in);
      int n = input.nextInt();
      System.out.println("Constant of repeatability?");
      double r = input.nextDouble();
      System.out.println("Number to multiply by?");
      double weight = input.nextDouble();
      //N = records, R = repeatability
      double fraction = (n * r) / (1 + (n-1) * r);
      
      System.out.println("the fraction is: " + fraction + "\n");
      double endAnswer = fraction * weight;
      System.out.println("the end result is: " + endAnswer + "\n" + "\n"); // Need more descriptions
      
   }
   
   /**
   *Takes a weaning weight of a calf and adjusts it
   *to "205 day" or "365 day" esitmates
   *
   *Selection will be made to choose between the two
   */
   public static void adjustedWeaning(){
      System.out.println("(1) 205 day   or   (2) 365 day?");
      Scanner input = new Scanner(System.in);
      int selection = input.nextInt();
      
      if (selection == 1){
         // code for calculating 205 day adjusted weight
         System.out.println("what was the actual birth weight?");
         double actBW = input.nextDouble();
         System.out.println("Actual Weaning Weight?");
         double actWW = input.nextDouble();
         System.out.println("How many days until it was weaned?");
         int weaningAge = input.nextInt();
         System.out.println("Dam's age of adjustment");
         int damADJ = input.nextInt();
         double outcome = (actWW - actBW)/weaningAge; //pg 183
         outcome = (outcome*205) + (actBW + damADJ);
         System.out.println(outcome);
      }
      else if (selection == 2){
         // code for 365 day calculation
         System.out.println("what was the actual birth weight?");
         double actBW = input.nextDouble();
         System.out.println("Actual Weaning Weight?");
         double actWW = input.nextDouble();
         System.out.println("How many days until it was weaned?");
         int weaningAge = input.nextInt();
         System.out.println("Dam's age of adjustment");
         int damADJ = input.nextInt();
         double outcome = (actWW - actBW)/weaningAge; //pg 183
         outcome = (outcome*365) + (actBW + damADJ);
         System.out.println(outcome);
      }
   }

   /**
   *uses a single source of information to 
   *make predictions. pg 231
   *regression coefficient
   *accuracy
   */
   public static void predictionsSignleSource(){

   }
}


/**
*pg. 280
*
*
*
*
*/