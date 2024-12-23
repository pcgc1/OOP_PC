package Assignments;

import java.util.ArrayList;

public class As2_Team {

    private String realName;
    private String nickname;
    private String city;
    private String league;
    private double netMoney;
    private int totalWins;
    private int totalLosses;
    private ArrayList<As3_Player> allPlayers = new ArrayList<>();


    public As2_Team(String r, String c, String n, String l, double m, int win, int loss){
        realName = r;
        nickname = n;
        city = c;
        league = l;
        netMoney = m;
        totalWins = win;
        totalLosses = loss;

    }//constructor


    public String toString(){
        return realName + " is based in " + city + ". Their nickname is " + nickname + ". They play in the " + league + " and had a net profit during the transfer window of " + netMoney + " million euros. In the 23/24 season they won " + totalWins + " games and lost " + totalLosses;
    }//to string


    public int getTotalWins() {
        return totalWins;
    }//get wins


    public String getRealName() {
        return realName;
    }//get name

    public int getTotalLosses() {
        return totalLosses;
    }//get losses

    public double getNetMoney() {
        return netMoney;
    }//get transfer income

    public String getLeague() {
        return league;
    }//get league

    public String getNickname() {
        return nickname;
    }//get nickname

    public String getCity() {
        return city;
    }//get city

    public void printMyPlayers(){
        for (int i = 0; i < allPlayers.size(); i++) {
            System.out.println( allPlayers.get(i).toString() );
        }
    }//print players

    public void updateWins(){
        totalWins++;
    }

    public void updateLosses(){
        totalLosses++;
    }


    //Assignment 3 stuff

    public void addPlayer(String n, int p, int g){
        allPlayers.add( new As3_Player(n, p, g) );
    }//add player

    public int totalStats(){
        int total = 0;
            for (int i = 0; i < allPlayers.size(); i++) {
                 total += allPlayers.get(i).getGoalScored();
            }
        return total;
    }//total player stats


    public void updateStat(String ans, int g){
        for (int i = 0; i < allPlayers.size(); i++) {
            if( ans.equalsIgnoreCase( allPlayers.get(i).getName() ) ){
                allPlayers.get(i).addGoals(g);
            }
        }//end for i
    }//update player stats

}//class
