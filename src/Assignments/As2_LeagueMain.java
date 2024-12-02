package Assignments;

import Examples.Ex3_Client;
import Examples.Library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class As2_LeagueMain {


    public static void run(){
        ArrayList<As2_Team> allTeams = new ArrayList<>();

        loadFile("data/premierLeagueData.csv", allTeams);


        while(true){
            System.out.println("\nWhat do you want to do?\n1.Print list of teams\n2.Find average or high/low\n3.View division\n4.Sort by ?\n5.Update stats\n6.Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if(choice == 1){

            }else if(choice == 2){

            }else if(choice == 3){

            }else if(choice == 4){

            }else if(choice == 5){

            }else{

            }

        }//while loop

    }//run




    public static void loadFile(String filename, ArrayList<As2_Team> list ) {

        try {
            BufferedReader file = new BufferedReader(new FileReader(filename));

            String dataToRead;
            while( file.ready()){
                dataToRead = file.readLine();

                String tempArray[] = dataToRead.split(",");
                //the next line is customized for whatever class you are creating.
                //Here we create a new STUDENT so there are 5 variables
                //Unfortunately, you need to Parse any variable that is not a String.  Integers, doubles and booleans are all demonstrated below.
                list.add( new As2_Team(  tempArray[0], tempArray[1], tempArray[2],Double.parseDouble(tempArray[3]), Integer.parseInt(tempArray[4]), Integer.parseInt(tempArray[5])   ));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile


}//class
