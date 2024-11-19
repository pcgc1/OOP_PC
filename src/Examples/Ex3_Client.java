package Examples;

public class Ex3_Client {

    //instance variables
    private String name;
    private String address;
    private int lawnSize;
    private boolean hasDoge;
    private double outstandingFees;


    //constructor method
    public Ex3_Client(String n, String a, int s, boolean d){
        name = n;
        address = a;
        lawnSize = s;
        hasDoge = d;
        outstandingFees = 0;

    }//constructor


    //instance methods
    public String toString(){
        return name + "  " + address + "  " + lawnSize + "  " + hasDoge + "  " + outstandingFees;
    }


    public void mowLawn(){

        double baseFee = 20;
        if(lawnSize < 300){
            baseFee += 0.10 * lawnSize;
        }else{
            baseFee += 0.15 * lawnSize;
        }

        if(hasDoge){
            baseFee += 40;
        }

        outstandingFees += baseFee;

        System.out.println(name + " our lawn was mowed today for a charge of $" + baseFee);
        System.out.println("You currently owe : $" + outstandingFees);

    }//mowLawn

}
//class