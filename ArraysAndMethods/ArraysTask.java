import java.util.Scanner;

public class ArraysTask {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int[] numbers = {12, 7, 25, 3, 18, 9, 30, 14};

        // 1
        System.out.println("Sum: " + sumArray(numbers));
        System.out.println("Average: " + averageArray(numbers));

        // 2
        int max = findMax(numbers);
        int min = findMin(numbers);
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Difference: " + (max - min));

        // 3
        System.out.println("Even numbers: " + countEven(numbers));
        System.out.println("Enter a number to search for: ");
        int target = scanner.nextInt();
        int index = indexOf(numbers, target);
        if (index != -1) {
            System.out.println(target + " found at index " + index);
        } else {
            System.out.println(target + " not found");
        }

        // 4
        System.out.print("Original: ");
        printArray(numbers);
        System.out.print("Reversed: ");
        printArray(reverseArray(numbers));

        // 5
        int[] grades = readGrades(5);
        int passed = countPassed(grades);
        int failed = grades.length - passed;
        System.out.println("Passed: " + passed);
        System.out.println("Failed: " + failed);

        
        System.out.println("Second Largest: " + secondLargest(numbers));
    }


    // Sum and Average
    static int sumArray(int[] arr) {
        int sum = 0;
        for (int num : arr) {
            sum = sum + num;
        }
        return sum;
    }

    static double averageArray(int[] arr) {
        return (double) sumArray(arr) / arr.length;
    }

    // Largest and Smallest
    static int findMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max){
                max = num;
            } 
        }
        return max;
    }

    static int findMin(int[] arr) {
        int min = arr[0];
        for (int num : arr) {
            if (num < min){
                min = num;
            }
        }
        return min;
    }

    // Count and Search
    static int countEven(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0){
                count++;
            } 
        }
        return count;
    }

    static int indexOf(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target){
                return i;
            } 
        }
        return -1;
    }

    // Reverse the Array
    static int[] reverseArray(int[] arr) {
        int[] reversed = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversed[i] = arr[arr.length - 1 - i];
        }
        return reversed;
    }

    static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // Student Grades
    static int[] readGrades(int size) {
        int[] grades = new int[size];
        for (int i = 0; i < size; i++) {
            int grade;
            while (true) {
                System.out.println("Enter grade "+ (i + 1));
                grade = scanner.nextInt();
                if (grade >= 0 && grade <= 100){
                    break;
                } 
                System.out.println("Invalid grade, please enter between 0 and 100.");
            }
            grades[i] = grade;
        }
        return grades;
    }

    static int countPassed(int[] grades) {
        int count = 0;
        for (int g : grades) {
            if (g >= 50) count++;
        }
        return count;
    }

    
    static int secondLargest(int[] arr) {
        int max = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > max) {
                second = max;
                max = num;
            } else if (num > second && num < max) {
                second = num;
            }
        }
        return second;
    }

    
}
