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
        int colaAmount = 2;
        int chipsAmount = 2;
        int candyAmount = 2;
        int change = 95;

        if(makeChange(change)) {
            System.out.println("INSERT COIN");
        }
        else{
            System.out.println("EXACT CHANGE ONLY");
        }

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
                case "cola" -> {
                    if (inStock("cola", colaAmount)) {
                        colaAmount = colaAmount - 1;

                        total = selectProduct(total, userInput);
                        if (total >= 0) {
                            returned = returned + total;
                            change = change - total;
                            total = 0;
                            coinReturn(returned);

                            if(makeChange(change)){
                                System.out.println("INSERT COIN");
                            }
                            else{
                                System.out.println("EXACT CHANGE ONLY");
                            }
                        }
                    }
                    else {
                        System.out.println("SOLD OUT");
                        if (total == 0 && makeChange(change)) {
                            System.out.println("INSERT COIN");
                        } else if (total == 0 && !makeChange(change)) {
                            System.out.println("EXACT CHANGE ONLY");
                        } else {
                            System.out.println(total);
                        }
                    }
                }

                case "chips" -> {

                    if ((inStock("chips", chipsAmount))) {
                        chipsAmount = chipsAmount - 1;

                        total = selectProduct(total, userInput);
                        if (total >= 0) {
                            returned = returned + total;
                            change = change - total;
                            total = 0;
                            coinReturn(returned);

                            if(makeChange(change)){
                                System.out.println("INSERT COIN");
                            }
                            else{
                                System.out.println("EXACT CHANGE ONLY");
                            }
                        }
                    }
                    else {
                        System.out.println("SOLD OUT");
                        if (total == 0 && makeChange(change)) {
                            System.out.println("INSERT COIN");
                        } else if (total == 0 && !makeChange(change)) {
                            System.out.println("EXACT CHANGE ONLY");
                        } else {
                            System.out.println(total);
                        }
                    }

                }

                case "candy" -> {
                    if ((inStock("candy", candyAmount))) {
                        candyAmount = candyAmount - 1;

                        total = selectProduct(total, userInput);
                        if (total >= 0) {
                            returned = returned + total;
                            change = change - total;
                            total = 0;
                            coinReturn(returned);

                            if(makeChange(change)){
                                System.out.println("INSERT COIN");
                            }
                            else{
                                System.out.println("EXACT CHANGE ONLY");
                            }
                        }
                    }
                    else {
                        System.out.println("SOLD OUT");
                        if (total == 0 && makeChange(change)) {
                            System.out.println("INSERT COIN");
                        } else if (total == 0 && !makeChange(change)) {
                            System.out.println("EXACT CHANGE ONLY");
                        } else {
                            System.out.println(total);
                        }
                    }
                }
                case "return", "Return", "RETURN" -> {
                    returned = total + returned;
                    total = 0;
                    coinReturn(returned);
                    System.out.println("INSERT COIN");
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
                    //System.out.println("INSERT COIN");
                }
                else{
                    System.out.println("PRICE");
                    System.out.println("1.00");
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
                    //System.out.println("INSERT COIN");
                }
                else{
                    System.out.println("PRICE");
                    System.out.println(".50");
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
                    //System.out.println("INSERT COIN");
                }
                else{
                    System.out.println("PRICE");
                    System.out.println(".65");
                }
            }

        }

        return total;
    }

    // Determines if a specific product is in stock in the machine
    public static boolean inStock(String product, int productAmount){

        switch (product){
            case "cola", "chips", "candy" ->{
                if(productAmount > 0){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean makeChange(int change){
        return change >= 95;
    }
}

