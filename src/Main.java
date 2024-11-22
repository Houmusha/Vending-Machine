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

        System.out.println("INSERT COIN");

        Scanner input = new Scanner(System.in);

        while(true) {

            String userInput = input.next();

            switch (userInput) {
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
                case "cola", "chips", "candy" -> {
                    total = selectProduct(total, userInput);
                    if(total > 0){
                        returned = returned + total;
                        total = 0;
                        coinReturn(returned);
                    }
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

    // this selectProduct will allow the user to buy a product from the machine
    // it will check the selection and determine if the user has the correct amount
    //inserted if so it gives the product and returns correct change
    public static int selectProduct(int total, String product){
        switch (product) {
            case "cola" -> {
                if(total >= 100){
                    System.out.println("THANK YOU");
                    if(total != 100) {
                        total = total - 100;
                    }
                    else{
                        total = 0;
                    }
                    System.out.println("INSERT COIN");
                }
                else{
                    System.out.println("PRICE");
                    System.out.println("1.00");
                    if(total == 0){
                        System.out.println("INSERT COIN");
                    }
                    else {
                        System.out.println(total);
                    }
                }
            }
            case "chips" -> {
                if(total >= 50){
                    System.out.println("THANK YOU");
                    if(total != 50) {
                        total = total - 50;
                    }
                    else{
                        total = 0;
                    }
                    System.out.println("INSERT COIN");
                }
                else{
                    System.out.println("PRICE");
                    System.out.println(".50");
                    if(total == 0){
                        System.out.println("INSERT COIN");
                    }
                    else {
                        System.out.println(total);
                    }
                }
            }
            case "candy" ->{
                if(total >= 65){
                    System.out.println("THANK YOU");
                    if(total != 65) {
                        total = total - 65;
                    }
                    else{
                        total = 0;
                    }
                    System.out.println("INSERT COIN");
                }
                else{
                    System.out.println("PRICE");
                    System.out.println(".65");
                    if(total == 0){
                        System.out.println("INSERT COIN");
                    }
                    else {
                        System.out.println(total);
                    }
                }
            }

        }

        return total;
    }
}

