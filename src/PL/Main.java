package PL;
import DAL.CreateTables;

import java.util.Scanner;

public class Main {
    static Scanner reader = new Scanner(System.in);

    //enums for functions
    enum insertFunctions {
        insertTruck
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
        while (cont) {
            switch(choice) {
                case 1: {
                    Functor insertFuncs[] = fillInsertFunctions();
                    System.out.println("Enter:\n 1 to insert Truck\n 2 to driver data\n 3 to insert license\n 4 to insert delivery \n 5 to insert destination\n 6 to insert license for driver\n 7 for main menu");
                    int insertChoice = reader.nextInt();
                    while (insertChoice < 1 || insertChoice > 7) {
                        System.out.println("Enter a number in range 1-7 please:");
                        insertChoice = reader.nextInt();
                    }
                    if (insertChoice == 7)
                        break;
                    insertFuncs[insertChoice-1].execute();
                    break;
                }
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Bye!");
                    cont = false;
                    break;
                default:
                    System.out.println("illegal command");
                    break;
            }
            if (cont) {
                System.out.println("Enter:\n 1 for insert data\n 2 for update data\n 3 for retrieve data\n 4 for exit");
                choice = reader.nextInt();
            }
        }
    }

    private static Functor[] fillInsertFunctions() {
        Functor[] funcsArr = new Functor[insertFunctions.values().length]; //number of items in the enum
        Class funcClass;
        try {
            for (int i = 0; i < funcsArr.length; i++) {
                funcClass = Class.forName("PL.insertFunctions."+insertFunctions.values()[i].name()); //gets the name of the function
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
}
