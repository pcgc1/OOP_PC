package Assignments;

public class As3_Player {
    private String name;
    private int playerID;
    private int goalScored;


    public As3_Player(String n, int p, int g){
        name = n;
        playerID = p;
        goalScored = g;


    }//constructor

    public String toString(){
        return name + " has scored " + goalScored + " goals. " + playerID;
    }//to string



//    public updateStat(){
//
//    }//update stats



}//class
