import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int total = 0;

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
                    System.out.println(total);
                }
                case "exit" -> {
                    System.exit(0);
                }
            }

        }

    }
}