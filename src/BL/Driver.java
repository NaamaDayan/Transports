package BL;


import DAL.Drivers;

public class Driver{
        public static void insertDriver(String id, String first, String last, String phone) {
            Drivers.insertDriver(id, first, last, phone);
        }
}
