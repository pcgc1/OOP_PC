package Assignments;

public class As2_Team {

    private String realName;
    private String nickname;
    private String city;
    private String league;
    private double netMoney;
    private int totalWins;
    private int totalLosses;


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

    public void updateWins(){
        totalWins++;
    }

    public void updateLosses(){
        totalLosses++;
    }


}//class
