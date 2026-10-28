import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class FeedbackPortal {

    static Scanner scanner = new Scanner(System.in);

    static String[] names =new String[100];
    static int[] ratings = new int[100];
    static String [] comments =new String[100];

    static int count=0;
    public static void main(String[] args){
        
        boolean running = true;
        while (running) {
            showMenu();
            
            try {
                System.out.print("Choose:");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        addFeedback();
                        break;
                    case 2:
                        showAll();
                        break;
                    case 3:
                        showAverage();
                        break;
                    case 4:
                        searchByRating();
                        break;
                    case 5:
                        deleteFeedback();
                        break;
                    case 6:
                        saveFeedback();
                        break;
                    case 7:
                        loadFeedback();
                        System.out.println("Feedback saved. Goodbye!");
                        running = false;
                        break;
                
                    default:
                        System.out.println("Invalid choice");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: Please enter a number"+e);
                //scanner.nextLine();
            }
        }scanner.close();

        
    }
    //close main

     public static void showMenu() {

        System.out.println("===== CUSTOMER FEEDBACK PORTAL =====");
        System.out.println("1. Add feedback");
        System.out.println("2. Show all feedback");
        System.out.println("3. Show average rating");
        System.out.println("4. Search by rating");
        System.out.println("5. Delete feedback");
        System.out.println("6. Save to file");
        System.out.println("7. Save and exit");
        //System.out.print("Choose: ");
    }

    //add
    public static void addFeedback() {
        //check if array full = 100 , number of adding (count) = length in array
        if (count == names.length) {
            System.out.println("Feedback list is Full");
            return;
        }
        //ask to enter name
        System.out.print("Enter name: ");
        String name = scanner.nextLine().trim();
        
        //name cant be empty
        if (name.isEmpty()) {
            System.out.println("Name can't be empty.");
            return;
        }

        int rating;

        while (true) {
            try {
                System.out.print("Enter rating between 1 and 5: ");
                rating = Integer.parseInt(scanner.nextLine());

                if (rating >= 1 && rating <= 5) {
                    break;
                } else {
                    System.out.println("Rating must be between 1 and 5.");
                }

            } catch (Exception e) {
                System.out.println("Invalid rating, enter only number ");
            }
        }

        //trim --> remove spice
        System.out.print("Enter comment: ");
        String comment = scanner.nextLine().trim();

        if (comment.isEmpty()) {
            System.out.println("Comment cannot be empty.");
            return;
        }

        names[count] = name;
        ratings[count] = rating;
        comments[count] = comment;

        
        count++;

        System.out.println("Feedback added successfully.");
    }
    //show
    public static void showAll(){
        
        if(count==0){
            System.out.println("There is no Feedback");
        }else{
            for(int i=0;i<count;i++){
                System.out.print((i+1)+": "+names[i] + "|");
                System.out.print(ratings[i]+ "|");
                System.out.println(comments[i]);
            }
            
        }
        
        
    }

    //Average
    public static void showAverage(){
        if(count ==0){
            System.out.println("There is no feedback to calculate rating");
        }
        double totalAverage = 0;
        for(int i=0; i<count; i++){
            totalAverage =totalAverage +ratings[i];
        }System.out.println("Average Rating: "+ totalAverage/count);
    }
    //search
    public static void searchByRating(){
        System.out.print("Enter Rating you want to search for feedback: ");
        //int search =scanner.nextInt();
        int search = Integer.parseInt(scanner.nextLine());
        boolean avilableRating = false;

        for(int i=0; i<count; i++){
            if(search == ratings[i]){
                System.out.print(names[i]+ "|");
                System.out.print(ratings[i]+ "|");
                System.out.println(comments[i]+ "|");

                avilableRating = true;
            }
        }
        if(!avilableRating){
            System.out.println("No feedback found with rating " + search);
        }
    }

    //Delete
    public static void deleteFeedback(){
        //if empty
        if (count == 0) {
            System.out.println("There is no feedback to delete.");
            return;
        }

        System.out.println("Enter number of feedback you want to delete it: ");
        //showAll();
        int numDel =scanner.nextInt();
        scanner.nextLine();

        if (numDel < 1 || numDel > count) {
            System.out.println("Invalid feedback number");
            return;
        }

        //to find the index --> int i = numDel - 1;  
        // Convert feedback number to array index

        for (int i = numDel - 1; i < count - 1; i++) {
            names[i] = names[i + 1];
            ratings[i] = ratings[i + 1];
            comments[i] = comments[i + 1];
        }

        // Clear the last position
        count--;
        names[count] = null;
        ratings[count] = 0;
        comments[count] = null;

        System.out.println("Feedback deleted successfully.");
    }
    
    //save
    public static void saveFeedback(){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("feedback.txt"))) {
            for (int i = 0; i < count; i++) {
                writer.write(names[i] + "|" + ratings[i] + "|" + comments[i]);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static void loadFeedback(){
        try (BufferedReader reader = new BufferedReader(new FileReader("feedback.txt"))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\|");
            names[count] = parts[0];
            ratings[count] = Integer.parseInt(parts[1]);
            comments[count] = parts[2];
            count++;
        }
        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    
    }
    
}