package PL.mainMenuHandlers;

import PL.Functor;
import PL.Main;

<<<<<<< HEAD
import java.text.ParseException;
=======
>>>>>>> master
import java.util.Scanner;

public class insertChoice extends Functor {
    static Scanner reader = new Scanner(System.in);

    enum insertFunctions {
        insertTruck,
        insertDriver,
        insertLicense,
        insertDelivery,
        insertPlace,
        insertLicenseForDriver
    }

    @Override
<<<<<<< HEAD
    public void execute() throws ParseException {
=======
    public void execute() {
>>>>>>> master
        Functor insertFuncs[] = fillInsertFunctions();
        System.out.println("Enter:\n 1 to insert Truck\n 2 to insert driver\n 3 to insert license\n 4 to insert delivery \n 5 to insert place\n 6 to insert license for driver\n 7 for main menu");
        int insertChoice = reader.nextInt();
        insertChoice = Main.rangeCheck(1, 7, insertChoice);
        if (insertChoice == 7)
            return;
        insertFuncs[insertChoice-1].execute();
    }

    private static Functor[] fillInsertFunctions() {
        Functor[] funcsArr = new Functor[insertFunctions.values().length]; //number of items in the enum
        Class funcClass;
        try {
            for (int i = 0; i < funcsArr.length; i++) {
                funcClass = Class.forName("PL.insertHandlers."+ insertFunctions.values()[i].name()); //gets the name of the function
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
