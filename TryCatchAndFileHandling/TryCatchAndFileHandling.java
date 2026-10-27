import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TryCatchAndFileHandling {

    public static void main(String[] args) throws IOException{

        try {
            Read();
        } catch (Exception e) {
            System.out.println("Error "+e);
        }
        WriterFile();

        try (BufferedReader br = new BufferedReader(new FileReader("text.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("copy.txt"))) {
        String line;
        while ((line = br.readLine()) != null) {
            bw.write(line);
            bw.newLine();
            }
            System.out.println("the file is copied successfully");
        }catch(Exception e){
            System.out.println("error "+e);
        }
        
    }

    //Write to a file
    private static void WriterFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("text.txt"));
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text to write to the file: ");
        String text = input.nextLine();
        writer.write("\n"+text);
        writer.close();
    }

    // Read from a file
    private static void Read() throws IOException {
        //opening the file
        BufferedReader br = new BufferedReader(new FileReader("text.txt"));
        System.out.println(br.readLine());
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
        br.close();
    }

    
}