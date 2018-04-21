package PL;
import DAL.CreateTables;
import PL.mainMenuHandlers.insertChoice;

import java.util.Scanner;

public class Main {
    static Scanner reader = new Scanner(System.in);

    //---enum with handlers names
    enum mainMenuFunctions {
        insertChoice,
        updateChoice,
        retrieveChoice
    }

    public static void main(String[] args) {
        CreateTables.initDB();
        programFlow();
    }

    private static void programFlow() {
        System.out.println("Welcome!");
        System.out.println("Enter:\n 1 for insert data\n 2 for update data\n 3 for retrieve data\n 4 for exit");
        int choice = reader.nextInt();
        boolean cont = true;
        Functor choiceFuncs[] = fillChoiceFunctions();
        while (cont) {
            choice = rangeCheck(1, 4, choice); //after this the choice is legal
            if (choice == 4) {
                System.out.println("Bye!");
                cont = false;
                break;
            }
            choiceFuncs[choice - 1].execute();
            if (cont) {
                System.out.println("Enter:\n 1 for insert data\n 2 for update data\n 3 for retrieve data\n 4 for exit");
                choice = reader.nextInt();
            }
        }
    }

    //returns array of main menu Handlers
    private static Functor[] fillChoiceFunctions() {
        Functor[] funcsArr = new Functor[mainMenuFunctions.values().length]; //number of items in the enum
        Class funcClass;
        try {
            for (int i = 0; i < funcsArr.length; i++) {
                funcClass = Class.forName("PL.mainMenuHandlers."+ mainMenuFunctions.values()[i].name()); //gets the name of the function
                funcsArr[i] = (Functor)funcClass.newInstance(); //creates instance
            }
        }
        catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return funcsArr;
    }

    public static int rangeCheck(int lowerBound, int upperBound, int input) {
        while (input < lowerBound || input > upperBound) {
            System.out.println("Enter a number in range " + lowerBound + "-" + upperBound +" please:");
            input = reader.nextInt();
        }
        return input;
    }

}
