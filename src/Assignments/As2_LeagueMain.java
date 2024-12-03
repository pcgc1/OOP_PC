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
            System.out.println("\nWhat do you want to do?\n1.Print list of teams\n2.Find highest\n3.View division\n4.Sort by ?\n5.Update stats\n6.Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();

            if(choice == 1){
                //print data
                for(int i = 0; i < allTeams.size();i++){
                    System.out.println(allTeams.get(i).toString());
                }
            }else if(choice == 2){
                //find highest
                int foundIndex = findHighestWins(allTeams);
                System.out.println( allTeams.get(foundIndex).getRealName() + " has the most wins ");

            }else if(choice == 3){

            }else if(choice == 4){

            }else if(choice == 5){

            }else{
                break;
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
                list.add( new As2_Team(  tempArray[0], tempArray[1], tempArray[2], tempArray[3],Double.parseDouble(tempArray[4]), Integer.parseInt(tempArray[5]), Integer.parseInt(tempArray[6])   ));

            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
    }//end loadFile



    public static int findHighestWins(ArrayList<As2_Team> list){
        int highestIndex = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(highestIndex).getTotalWins() < list.get(i).getTotalWins() ){
                highestIndex = i;
            }
        }

        return highestIndex;
    }//find highest wins


}//class
