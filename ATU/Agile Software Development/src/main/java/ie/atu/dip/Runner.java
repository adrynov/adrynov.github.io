package ie.atu.dip;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This application represents a car park
 * <p>
 * It uses Unit Testing, JUnit and white-box testing strategies, mock objects
 * Code coverage should be at least 80%.
 *
 * @author Andrei Drynov
 * @version 1.1
 */
public class Runner {
    private static final List<ParkingTicket> tickets = new ArrayList<>();

    private static final Scanner scanner = new Scanner(System.in);
    //        ParkingSpot parkingspot = new ParkingSpot();
//        RandomInfo randominfo = new RandomInfo();


    public static void main(String[] args) {
        showBanner();

        var parking = new ParkingLot();

        System.out.println("Let's park your car");
        System.out.println();

        boolean done = false;

        while (!done) {
            var ticket = new ParkingTicket();

            try {
                int availableSpaces = parking.getAvailableSpaces();
                System.out.println("Total number of car spaces: " + availableSpaces);

                if (availableSpaces <= 0) {
                    System.out.println("There is no parking space left.");
                    done = true;
                    continue;
                }

                System.out.print("What is the car plate: ");
                String plateNumber = scanner.nextLine();

                var car = Car.randomCar(plateNumber);
                ticket.setCar(car);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    //<editor-fold desc="Helpers">

    private static void showBanner() {
        printSeparator('*');
        System.out.println("*   ATU - Dept. Computer Science & Applied Physics    *");
        System.out.println("*                                                     *");
        System.out.println("*            Agile Software Development               *");
        System.out.println("*                                                     *");
        System.out.println("*             Andrei Drynov (G00411287)               *");
        printSeparator('*');

        System.out.println();
    }

    /**
     * The length of the separator line in informational blocks.
     */
    private static final int SEPARATOR_LEN = 55;

    private static void printSeparator(char separator) {
        String line = String.valueOf(separator).repeat(SEPARATOR_LEN);
        System.out.println(line);
    }

    //</editor-fold>
}