package PL.updateHandlers;

import java.util.Scanner;

public class updateUtils {
    static Scanner reader = new Scanner(System.in);

    //returns true if the user input is y
    public static boolean boolQuery(String input){
        System.out.println(input);
        String isLegal = reader.next();
        while (!isLegal.equals("y") && !isLegal.equals("n")){
            System.out.println("insert y or n only");
            isLegal = reader.next();
        }
        return isLegal.equals("y");
    }
}
