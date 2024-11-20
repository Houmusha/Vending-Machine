/*
    Ethan Ison
    This is a vending machine kata
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // total is the amount the user has put in the machine
        // returned is the amount the machine has placed in the coin return
        int total = 0;
        int returned = 0;

        System.out.println("Insert Coin");

        Scanner input = new Scanner(System.in);

        while(true) {

            String userMoney = input.next();

            switch (userMoney) {
                case "25", "quarter", "Quarter", "QUARTER" -> {
                    total = total + Coin.QUARTER.value;
                    System.out.println(total);
                }
                case "10", "dime", "Dime", "DIME" -> {
                    total = total + Coin.DIME.value;
                    System.out.println(total);
                }
                case "5", "nickle", "Nickle", "NICKLE" -> {
                    total = total + Coin.NICKLE.value;
                    System.out.println(total);
                }
                case "1", "penny", "Penny", "PENNY" -> {
                    returned = returned + Coin.PENNY.value;
                    System.out.println(total);
                    coinReturn(returned);
                }
                case "exit" -> {
                    System.exit(0);
                }
            }

        }

    }

    // this coinReturn will return any penny placed into the machine
    // and keep a running tally of the amount of money in the return
    public static void coinReturn(int returned){
        if(returned == 1){
            System.out.println("Returned " + returned + " cent");
        }
        else{
            System.out.println("Returned " + returned + " cents");
        }

    }
}

