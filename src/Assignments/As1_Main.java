package Assignments;

import Examples.Ex2_Actor;
import Examples.Library;

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

        //Setting acres
        allCrops.get(0).setAcres(485);
        allCrops.get(1).setAcres(75);
        allCrops.get(2).setAcres(150);
        allCrops.get(3).setAcres(250);
        allCrops.get(4).setAcres(40);




        //looping menu
        System.out.println("Welcome to Philip's Farm!");

        while(true){
            System.out.println("\nWhat do you want to do?\n1.Print farm summary\n2.Search & harvest a crop\n3.Total Revenue\n4.Plant crops\n5.Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if(choice == 1){

                //print crops
                for (int i = 0; i < allCrops.size(); i++) {
                    System.out.println(allCrops.get(i).printMe());
                }

            }else if(choice == 2){

                //search for crop
                System.out.println("What crop do you want to search for?");
                String crop = Library.input.nextLine();

                int foundIndex = searchByName(allCrops, crop);

            }else if(choice == 3){
                System.out.println("Not yet implemented");
            }else if(choice == 4){
                System.out.println("Not yet implemented");
            }else{
                break;
            }

        }//while true



    }//run


    public static int searchByName (ArrayList<As1_Crop> list, String searchTerm){
        for (int i = 0; i < list.size(); i++) {
            if(searchTerm.equalsIgnoreCase( list.get(i).name )){
                return i;

            }
        }


        return -1;
    }

}//class