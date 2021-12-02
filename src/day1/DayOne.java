package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static general.Utils.out;

public class DayOne {

    public static int[] input = new int[2001];

    public static void main(String[] args) {
        readFile();
        int increases = 0;
        int prev = input[0] + input[1] + input[2];
        for (int i = 3; i < input.length; i++) {
            if (input[i] == 0) break;
            int newTotal = input[i] + input[i-1] + input[i-2];

            if (newTotal > prev){
                increases++;
            }
            prev = newTotal;
            out("Total: " + newTotal);
        }
        out("Increases: " + increases);
    }

    public static void readFile(){
        try {
            File myObj = new File("day1.txt");
            Scanner myReader = new Scanner(myObj);
            int i = 0;
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                input[i++] = Integer.parseInt(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            out("An error occurred.");
            e.printStackTrace();
        }
    }

}
