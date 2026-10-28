import java.util.Scanner;

public class HollowSquare {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = scanner.nextInt();

        //i->represents the row
        for (int i = 1; i <= n; i++) {
            //j->represents the column
            for (int j = 1; j <= n; j++) {
                //first row||last row||first column||last column
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }

        scanner.close();
    }
}