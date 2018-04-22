package PL.removeHandlers;
import BL.EntitiyFunctions.DriverLicenseFunctions;
import PL.Functor;

import java.util.Scanner;

/**
 * Created by Shahar on 22/04/2018.
 */
public class RemoveLicenseOfDriver extends Functor {

    static Scanner reader = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("enter driver id");
        String driverId = reader.next();
        System.out.println("enter license id");
        String licenseId = reader.next();
        DriverLicenseFunctions.removeLicenseOfDriver(driverId, licenseId);
    }
}
