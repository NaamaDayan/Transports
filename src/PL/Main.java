package PL;
import DAL.CreateTables;

import java.util.Scanner;

public class Main {
    static Scanner reader = new Scanner(System.in);

    //---START enums with handlers names
    enum insertFunctions {
        insertTruck,
        insertDriver,
        insertLicense,
        insertDelivery,
        insertPlace,
        insertLicenseForDriver
    }

    enum updateFunctions {
        updateTruck,
        updateDriver,
        updateLicense,
        updateDelivery,
        updatePlace,
    }

    enum retrieveFunctions {
        retrieveTruck,
        retrieveDriver,
        retrieveLicense,
        retrieveDelivery,
        retrievePlace,
        retrieveLicenseForDriver
    }
    //---END enums with handlers names

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
                    System.out.println("Enter:\n 1 to insert Truck\n 2 to insert driver\n 3 to insert license\n 4 to insert delivery \n 5 to insert place\n 6 to insert license for driver\n 7 for main menu");
                    int insertChoice = reader.nextInt();
                    insertChoice = rangeCheck(1, 7, insertChoice);
                    if (insertChoice == 7)
                        break;
                    rangeCheck(1, 7, insertChoice);
                    insertFuncs[insertChoice-1].execute();
                    break;
                }
                case 2:
                    Functor updateFuncs[] = fillUpdateFunctions();
                    System.out.println("Enter:\n 1 to update Truck\n 2 to update driver\n 3 to update license\n 4 to update delivery \n 5 to update place\n 6 for main menu");
                    int updateChoice = reader.nextInt();
                    updateChoice = rangeCheck(1, 6, updateChoice);
                    if (updateChoice == 6)
                        break;
                    updateFuncs[updateChoice-1].execute();
                    break;
                case 3:
                    Functor retrieveFuncs[] = fillRetrieveFunctions();
                    System.out.println("Enter:\n 1 to retrieve Truck\n 2 to retrieve driver\n 3 to retrieve license\n 4 to retrieve delivery \n 5 to retrieve place\n 6 to retrieve license of driver\n 7 for main menu");
                    int retrieveChoice = reader.nextInt();
                    retrieveChoice = rangeCheck(1, 7, retrieveChoice);
                    if (retrieveChoice == 7)
                        break;
                    retrieveFuncs[retrieveChoice-1].execute();
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

    private static int rangeCheck(int lowerBound, int upperBound, int input) {
        while (input < lowerBound || input > upperBound) {
            System.out.println("Enter a number in range " + lowerBound + "-" + upperBound +" please:");
            input = reader.nextInt();
        }
        return input;
    }

    //---START functions that return arrays of Handlers
    private static Functor[] fillInsertFunctions() {
        Functor[] funcsArr = new Functor[insertFunctions.values().length]; //number of items in the enum
        Class funcClass;
        try {
            for (int i = 0; i < funcsArr.length; i++) {
                funcClass = Class.forName("PL.insertHandlers."+insertFunctions.values()[i].name()); //gets the name of the function
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

    private static Functor[] fillUpdateFunctions() {
        Functor[] funcsArr = new Functor[updateFunctions.values().length]; //number of items in the enum
        Class funcClass;
        try {
            for (int i = 0; i < funcsArr.length; i++) {
                funcClass = Class.forName("PL.updateHandlers."+updateFunctions.values()[i].name()); //gets the name of the function
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

    private static Functor[] fillRetrieveFunctions() {
        Functor[] funcsArr = new Functor[retrieveFunctions.values().length]; //number of items in the enum
        Class funcClass;
        try {
            for (int i = 0; i < funcsArr.length; i++) {
                funcClass = Class.forName("PL.retrieveHandlers."+retrieveFunctions.values()[i].name()); //gets the name of the function
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
    //---END functions that fill and return arrays of Functions
}
