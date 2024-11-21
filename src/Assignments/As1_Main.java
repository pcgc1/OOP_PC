package Assignments;

import java.util.ArrayList;

public class As1_Main {

    public static void run(){
        ArrayList<As1_Crop> allCrops = new ArrayList<>();

        //adding crops to arraylist
        allCrops.add( new As1_Crop("Sugar beets", 34.9, "tonnes per acre", 38.77) );
        allCrops.add( new As1_Crop("Canola", 38.1, "bushels per acre", 13.95) );
        allCrops.add( new As1_Crop("Barley", 75.9, "bushels per acre", 5.25) );
        allCrops.add( new As1_Crop("Lentils", 22.4, "bushels per acre", 0.28) );
        allCrops.add( new As1_Crop("Oats", 90.9, "bushels per acre", 3.68) );

    }//run

}//class