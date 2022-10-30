/*
Dice Jack game:

1. User picks 3 numbers and the sum of these 3 numbers is calculated
2. After that user rolls the dice 3 times and the sum of these 3 dice rolls is also calculated

User wins if:
1. The total sum of dice rolls is less than the sum of numbers you chose
    AND
2. The difference between the sum of chosen numbers and the sum of dice rolls is less than 3
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int roll1 = rollDice();
        int roll2 = rollDice();
        int roll3 = rollDice();

        System.out.println("Enter three numbers between 1 and 6:");

        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();

        if (num1<1 || num2 <1 || num3<1){
            System.out.println("Numbers can't be less than 1. Shutting game down.");
            System.exit(0);
        }

        if (num1>6 || num2 >6 || num3>6){
            System.out.println("Numbers can't be greater than 6. Shutting game down.");
            System.exit(0);
        }

        int sumOfNumbers = num1 + num2 + num3;
        int sumDiceRolls = roll1 + roll2 + roll3;
        System.out.println("Dice sum: " + sumDiceRolls + ". Number sum: " + sumOfNumbers + ".");

       if(checkWin(sumDiceRolls, sumOfNumbers)){
           System.out.println("Congrats, you win!");
       }else{
           System.out.println("Sorry, you lose! \nExplanation: Dice sum should be less than number sum and the difference should be less than 3.");
       }


        scanner.close();
    }

    public static int rollDice() {
        double randomNumber = Math.random() * 6;            // 0 - 5.9999999999999
        randomNumber += 1;                                  // 1 - 6.9999999999999
        return (int) randomNumber;                          //  1 - 6
    }

    public static boolean checkWin (int sumDiceRolls, int sumOfNumbers){
        return (sumOfNumbers>sumDiceRolls && (sumOfNumbers-sumDiceRolls) < 3);
        }

    }

