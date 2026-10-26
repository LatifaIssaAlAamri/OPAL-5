import java.util.Scanner;

public class ToolboxApp {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int num;
        do {
            menu();
            System.out.println("Please enter a number between 1 and 10:");
            
            if (scanner.hasNextInt()) {
                num = scanner.nextInt();
            
                switch (num) {
                    case 1:
                        celsiusToFahrenheit();
                        break;
                    case 2:
                        evenOrOdd();
                        break;
                    case 3:
                        maxOfThree();
                        break;
                    case 4:
                        factorial();
                        break;
                    case 5:
                        multiplicationTable();
                        break;
                    case 6:
                        starTriangle();
                        break;
                    case 7:
                        isPrime();
                        break;
                    case 8:
                        reverseNumber();
                        break;
                    case 9:
                        numberPyramid();
                        break;
                    case 0:
                        System.out.println("Goodbye!");
                        break;
                    case 10:
                        diamond();
                        break;

                    default:
                        System.out.println("invalid choice, Please try again.");
                        break;
                }
            }else{
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Remove invalid input
                num = -1;
            }//close else
        }while (num != 0);
        scanner.close();
    }
    
    //menu
    static void menu(){
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Even or odd");
        System.out.println("3. Maximum of three numbers");
        System.out.println("4. Factorial");
        System.out.println("5. Multiplication table");
        System.out.println("6. Triangle of stars");
        System.out.println("7. Prime check");
        System.out.println("8. Reverse a number");
        System.out.println("9. Number pyramid");
        System.out.println("10. Diamond of stars");
        System.out.println("0. Exit");

    }
    //Case 1
    public static void celsiusToFahrenheit(){
        System.out.println("Enter a temperature in Celsius: ");
        double c =scanner.nextDouble();
        double  F = c * 9 / 5 + 32;
        System.out.println("Fahrenheit: " + F);
    }
    //Case 2
    public static void evenOrOdd(){
        System.out.println("Enter an integer: ");
        int evenOdd =scanner.nextInt();
        if(evenOdd % 2 == 0){
            System.out.println(evenOdd + " is even number");
        }else{
            System.out.println(evenOdd + " is odd number");
        }
    }
    //Case 3
    public static void maxOfThree(){

        System.out.println("Enter 1st integer: ");
        int num1 = scanner.nextInt();

        System.out.println("Enter 2nd integer: ");
        int num2 = scanner.nextInt();

        System.out.println("Enter 3rd integer: ");
        int num3 = scanner.nextInt();

        if (num1 >= num2 && num1 >= num3) {
            System.out.println(num1 + " is largest one.");
        } else if (num2 >= num1 && num2 >= num3) {
            System.out.println(num2 + " is largest one.");
        } else {
            System.out.println(num3 + " is largest one.");
        }

    }
    //Case 4
    public static void factorial(){
        System.out.println("Enter a non-negative number (0 to 15): ");
        int n = scanner.nextInt();
        //validation should be non-negative and above 15
        if (n < 0 || n > 15) {
            System.out.println("Number must be between 0 and 15.");
            return;
        }
        long xFactorial = 1;
        for (int i = 1; i <= n; i++) {
            xFactorial = xFactorial * i;
        }
        System.out.println(n + "! = " + xFactorial);
        }
    //Case 5
    public static void multiplicationTable(){
        System.out.print("Enter a number for Multiplication Table: ");
        int numMultiTable = scanner.nextInt();
        for (int i = 1; i <= 10; i++) {
            System.out.println(numMultiTable + " x " + i + " = " + (numMultiTable * i));
        }
    }
    //Case 6
    public static void starTriangle(){

        System.out.println("Enter number of rows: ");
        int rows = scanner.nextInt();

        for (int i = 1; i <= rows; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print("* ");
            }

        System.out.println();
    }


    }
    //Case 7
    public static void isPrime(){
        System.out.print("Enter an integer greater than 1 : ");
        int primeInteger = scanner.nextInt();

        if(primeInteger <=1 ){
            System.out.println("prime number must be greater than 1");
            return ; //leaves the method.
        }
        //assume the number is prime until proof that
        boolean prime = true;

        //check if given num has divisor (divisor will check if < given number)
        for (int i = 2; i < primeInteger; i++) {
            if (primeInteger % i == 0) {
                prime = false;
                break;
            }
        }

        if (prime) {
            System.out.println(primeInteger + " is prime.");
        } else {
            System.out.println(primeInteger + " is not prime.");
        }
        }
    //Case 8
    public static void reverseNumber(){
        System.out.print("Enter a positive integer: ");
        int numRev = scanner.nextInt();

        int reversed = 0;

        while (numRev > 0) {
            int digit = numRev % 10;
            reversed = reversed * 10 + digit;
            numRev = numRev / 10;
        }

        System.out.println("Reversed number: " + reversed);
    
    }

    //Case 9
    public static void numberPyramid(){
        System.out.print("Enter number of rows: ");
    int rows = scanner.nextInt();

    for (int i = 1; i <= rows; i++) {

        for (int j = 1; j <= i; j++) {
            System.out.print(j + " ");
        }

        System.out.println();
    }
    }

    //Case 10
    
    public static void diamond() {
        
        System.out.print("Enter the number of rows for the half-diamond (size): ");
        int n = scanner.nextInt();
       
        for (int i = 1; i <= n; i++) {

            for (int spaceDiamond = n; spaceDiamond > i; spaceDiamond--) {
                    System.out.print(" ");
            }

            for (int starDiamond = 1; starDiamond <= (2 * i - 1); starDiamond++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = n; i >= 1; i--) {

            for (int spaceDiamond = n; spaceDiamond > i; spaceDiamond--) {
                System.out.print(" ");
            }

            for (int starDiamond = 1; starDiamond <= (2 * i - 1); starDiamond++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

}