package ie.atu.dip;

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
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showBanner();

        var parking = new ParkingLot();

        System.out.println("Let's park a car");
        System.out.println();

        boolean done = false;

        while (!done) {
            try {
                // check available spaces
                int availableSpaces = parking.getAvailableSpaces();
                System.out.println("Total number of available spaces: " + availableSpaces);
                System.out.println();

                // no spaces left
                if (availableSpaces <= 0) {
                    System.out.println("There is no parking space left.");
                    done = true;
                    continue;
                }

                // request the user to enter any car plate number
                System.out.print("What is the car plate? ");
                String plateNumber = scanner.nextLine();

                // assume the car has exited when the same plate number entered by the user
                if (parking.isCarParked(plateNumber)) {
                    ParkingTicket removed = parking.closeTicket(plateNumber);
                    showRemovedTicket(removed);
                    continue;
                }

                // get the next parking spot
                int spotNumber = parking.getNextAvailableSpace();
                if (spotNumber == 0) {
                    System.out.println("Sorry, no parking space left");
                    done = true;
                    continue;
                }

                // create a random car
                var car = Car.randomCar(plateNumber);

                // create a parking ticket
                var ticket = new ParkingTicket();
                ticket.setCar(car);
                ticket.setSpace(spotNumber);

                parking.openTicket(ticket);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Shows details of the ticket
     *
     * @param ticket Removed ticket.
     */
    private static void showRemovedTicket(ParkingTicket ticket) {
        if (ticket == null) return;

        System.out.println("Car " + ticket.getPlate() + " has left");
        ticket.print();
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