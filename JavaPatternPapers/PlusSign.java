import java.util.Scanner;

public class PlusSign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter an odd n: ");
        int n = scanner.nextInt();

        int middle = n / 2;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                if (i == middle || j == middle) {
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