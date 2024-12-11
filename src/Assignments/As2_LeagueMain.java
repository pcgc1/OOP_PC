package Assignments;

import Examples.Ex3_Client;
import Examples.Library;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;

public class As2_LeagueMain {


    public static void run(){
        ArrayList<As2_Team> allTeams = new ArrayList<>();


        loadFile("data/premierLeagueData.csv", allTeams);

        //add players to player class
        //Arsenal
        allTeams.get(0).addPlayer("Bukayo Saka", 0, 16);
        allTeams.get(0).addPlayer("Kai Havertz", 1, 13);
        allTeams.get(0).addPlayer("Leandro Trossard", 2, 12);

        //Man City
        allTeams.get(1).addPlayer("Erling Haaland", 3, 27);
        allTeams.get(1).addPlayer("Phil Foden", 4, 19);

        //Liverpool
        allTeams.get(2).addPlayer("Mohamed Salah", 5, 18);
        allTeams.get(2).addPlayer("Darwin Nunez", 6, 11);

        //Aston Villa
        allTeams.get(3).addPlayer("Ollie Watkins", 7, 19);
        allTeams.get(3).addPlayer("Leon Bailey", 8, 10);

        //Spurs
        allTeams.get(4).addPlayer("Son Heung-Min", 9, 17);
        allTeams.get(4).addPlayer("Richarlison", 10, 11);

        //Chelsea
        allTeams.get(5).addPlayer("Cole Palmer", 11, 22);
        allTeams.get(5).addPlayer("Nicolas Jackson", 12, 14);
        allTeams.get(5).addPlayer("Noni Madueke", 13, 5);
        allTeams.get(5).addPlayer("Mykhailo Mudryk", 14, 5);
        allTeams.get(5).addPlayer("Enzo Fernandez", 15, 3);

        //Man United
        allTeams.get(6).addPlayer("Bruno Fernandes", 16, 10);
        allTeams.get(6).addPlayer("Rasmus Hojlund", 17, 10);

        //Newcastle
        allTeams.get(7).addPlayer("Alexander Isak", 18, 21);
        allTeams.get(7).addPlayer("Anthony Gordon", 19, 11);



        while(true){
            System.out.println("\nWhat do you want to do?\n1.Print list of teams\n2.Find highest stats\n3.View division\n4.Sort by wins\n5.Update stats\n6.Print players\n7.Save and Exit");

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
                System.out.println( allTeams.get(foundIndex).getRealName() + " has the most wins at " + allTeams.get(foundIndex).getTotalWins() + " wins");

                foundIndex = findHighestLosses(allTeams);
                System.out.println( allTeams.get(foundIndex).getRealName() + " has the most losses at " + allTeams.get(foundIndex).getTotalLosses() + " losses");

                foundIndex = findHighestIncome(allTeams);
                System.out.println( allTeams.get(foundIndex).getRealName() + " has the highest overall transfer income at " + allTeams.get(foundIndex).getNetMoney() + " million euros");


            }else if(choice == 3){
                //filter by division
                System.out.println("What division do you want to filter by?");
                String ans  = Library.input.nextLine();

                filterLeague(allTeams, ans);

            }else if(choice == 4){
                //sort by wins
                System.out.println("Sort by wins\n");
                selectionSortIntArrayList(allTeams);

                for(int i = 0 ; i < allTeams.size(); i++){
                    System.out.println(allTeams.get(i).getRealName() + " has " + allTeams.get(i).getTotalWins() + " wins");
                }

            }else if(choice == 5){
                //update stats
                System.out.println("What team's stats do you want to update?");
                String ans = Library.input.nextLine();

                for (int i = 0; i < allTeams.size(); i++) {
                    if(allTeams.get(i).getRealName().equalsIgnoreCase(ans) ){
                        System.out.println("Did the team win or lose?");
                        ans = Library.input.nextLine();

                        if(ans.equalsIgnoreCase("win")){
                            allTeams.get(i).updateWins();
                        }else{
                            allTeams.get(i).updateLosses();
                        }

                    }
                    //System.out.println("Team not found");
                }//for i


            }else if(choice == 6){
                //print players
                System.out.println("What team's players do you want to see?");
                String ans = Library.input.nextLine();

                for (int i = 0; i < allTeams.size(); i++) {
                    if(allTeams.get(i).getRealName().equalsIgnoreCase(ans) ){
                        allTeams.get(i).printMyPlayers();
                    }
                }

            } else{
                //exit and save
                saveFile("data/premierLeagueData.csv", allTeams);
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


    public static void saveFile(String filename, ArrayList <As2_Team> tempList ) {
        try {
            PrintWriter file = new PrintWriter(new FileWriter(filename));

            for (int i = 0; i < tempList.size(); i++) {
//the next lines are customized for whatever data you are getting.
                String toSave ="";
                toSave = tempList.get(i).getRealName();  //assumes getter method are used for private variables
                toSave +="," + tempList.get(i).getNickname();
                toSave += "," + tempList.get(i).getCity();
                toSave +="," + tempList.get(i).getLeague();
                toSave +="," + tempList.get(i).getNetMoney();
                toSave +="," + tempList.get(i).getTotalWins();
                toSave +="," + tempList.get(i).getTotalLosses();

//The above 6 lines could be replaced by a call to a carefully made toString() function

                file.println(toSave);

            }
            file.close();
        }
        catch (IOException ex) {
            System.out.println(ex.toString());
        }

    }//end saveFile




    public static int findHighestWins(ArrayList<As2_Team> list){
        int highestIndex = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(highestIndex).getTotalWins() < list.get(i).getTotalWins() ){
                highestIndex = i;
            }
        }

        return highestIndex;
    }//find highest wins


    public static int findHighestLosses(ArrayList<As2_Team> list){
        int highestIndex = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(highestIndex).getTotalLosses() < list.get(i).getTotalLosses() ){
                highestIndex = i;
            }
        }

        return highestIndex;
    }//find highest losses


    public static int findHighestIncome(ArrayList<As2_Team> list){
        int highestIndex = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(highestIndex).getNetMoney() < list.get(i).getNetMoney() ){
                highestIndex = i;
            }
        }

        return highestIndex;
    }//find highest losses


    public static void filterLeague(ArrayList<As2_Team> list, String filter){
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i).getLeague().toLowerCase().contains(filter) ){
                System.out.println( list.get(i).getNickname() + " " + list.get(i).getCity() + " " + list.get(i).getTotalWins() + " wins");
            }
        }
    }//filter by league/division



    public static void selectionSortIntArrayList(ArrayList<As2_Team> list){
        for(int i=0; i<list.size()-1; i++){
            int highestIndex = i;
            for(int j=i+1; j<list.size(); j++){
                if(list.get(j).getTotalWins() > list.get(highestIndex).getTotalWins() ){
                    highestIndex = j;
                }
            }

            As2_Team tempTeam = list.get(i);
            list.set(i, list.get(highestIndex));
            list.set(highestIndex, tempTeam);

        }//end for i

    }//selection sort int


}//class
