import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IntroInJava {

    public static void main(String args[]){

        /** 1. Calculate the sum of the first 100 numbers higher than 0 **/

        int sum = 0;
        for(int i=0;i<=100;i++){
            sum += i;
        }
        System.out.println("sum of the first 100 numbers higher than 0  : "+ sum );


        /** 2. Display the smallest number from an array of number **/

        List<Integer> numberList = new ArrayList<>();
        numberList.add(123);
        numberList.add(10);
        numberList.add(16723);
        numberList.add(7);
        numberList.add(1293);
        numberList.add(16724);

        Integer smallestNumber = numberList.get(0);

        for(Integer temp:numberList){
            if(smallestNumber>temp)
                smallestNumber = temp;
        }

        System.out.println("smallest number from this array: "+smallestNumber);

        /** 3. Display the max digit from a number. **/

        Integer number = 147807;
        System.out.println("max digit from "+number+" : "+ maxDigitFromANumber(number));


        /** 4. Check if a number is palindrom( e.g palindrom 1221, 34143) **/

        Integer numberPalindrom = 1221;
        if(isPalindrom(numberPalindrom))
            System.out.println("number "+ numberPalindrom +" is palindrom");
        else
            System.out.println("number "+ numberPalindrom +" is not palindrom");

        /** 5. Display all the prime numbers lower than a given number **/

        Scanner scanner = new Scanner( System.in );
        System.out.print( "Type some number: " );

        int input = scanner.nextInt();

        primeNumbersLowerThanGivenNumber(input);
        scanner.close();


    }

    public static int maxDigitFromANumber(int number){
        int maxDigit = 0;

        while(number!= 0){
            int digit = number % 10;
            maxDigit = Math.max(digit,maxDigit);

            number = number/10;
        }

        return maxDigit;
    }

    public static Boolean isPalindrom(int number){
        int reverse = 0;
        int palindrom = number;

        while (palindrom != 0){

            int digit = palindrom % 10;
            reverse = reverse * 10 + digit;
            palindrom = palindrom / 10;
        }

        if(number == reverse)
            return true;
        else
            return false;
    }

    public static void primeNumbersLowerThanGivenNumber(int number){

        int i =0;
        int num =0;

        String  primeNumbers = "";

        for (i = 1; i <= number; i++)
        {
            int counter=0;
            for(num =i; num>=num/2+1; num--)
            {
                if(i%num==0)
                {
                    counter = counter + 1;
                }
            }
            if (counter ==2)
            {
                primeNumbers = primeNumbers + i + " ";
            }
        }
        System.out.println("Prime numbers from 1 to n are :");
        System.out.println(primeNumbers);

    }
}
