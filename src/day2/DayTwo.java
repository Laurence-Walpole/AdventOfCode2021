package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static general.Utils.out;

public class DayTwo {

    static int aim, depth, distance = 0;

    public static void main(String[] args) {
        readFile();
        out("Distance: " + distance);
        out("Depth: " + depth);
        out("Aim: " + aim);

        int horizontalPos = distance * depth;
        out("Horizontal Pos: " + horizontalPos);
    }

    public static void readFile(){
        try {
            File myObj = new File("day2.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                char firstChar = data.toCharArray()[0];
                int value = Integer.parseInt(data.split(" ")[1]);
                switch (firstChar) {
                    case 'f' -> {
                        distance += value;
                        depth += (aim * value);
                    }
                    case 'd' -> {
                        aim += value;
                    }
                    case 'u' -> {
                        aim -= value;
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            out("An error occurred.");
            e.printStackTrace();
        }
    }

}
