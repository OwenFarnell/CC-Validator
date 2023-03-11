import java.util.Scanner;

public class Main
 {
    static int firstArray = 0;
    static int secondArray = 0;
    static int total = 0;

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Credit Card Number to Validate: ");
        String stringInput = input.nextLine();
        long userInput = Long.parseLong(stringInput);
        
        if(validateCCNumber(userInput))
            System.out.println("This Creditcard is Valid!");
        else
            System.out.println("This Creditcard is NOT Valid.");

        boolean cardVal = validate(total);
    }

    public static boolean validateCCNumber(long cardLong)
    {
        String creditCard = String.valueOf(cardLong);
        firstArray = oddNum(creditCard);
        secondArray = evenNum(creditCard);
        total = secondArray + firstArray;

        if(validate(total))
            return true;
        else
            return false;
    }

    public static int oddNum(String creditCard)
    {
        int sum = 0;
        String[] numbers = creditCard.split("");
        for(int i = 1; i < numbers.length; i = i + 2)
        {
            sum = sum + Integer.parseInt(numbers[i]);
        }
        return sum;
    }

    public static int evenNum(String creditCard)
    {
        int sum = 0;
        String[] numbersTwo = creditCard.split("");
        int[] intArray = new int[numbersTwo.length + 1];
        int x = 0;
        for(int i = 0; i < numbersTwo.length; i = i + 2)
        {
            x++;
            intArray[x] = Integer.parseInt(numbersTwo[i]) * 2;

            if(intArray[x] >= 10)
            {
                int change = 1 + intArray[x] % 10;
                intArray[x] = change;
            }
        }
        for(int z = 0; z < intArray.length; z++)
            {
                sum = sum + intArray[z];
            }
            return sum;

    }

    public static boolean validate(int total)
    {
        if(total % 10 == 0)
            return true;
        else 
            return false;
    }
 }
