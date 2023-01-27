package ie.atu.dip;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a parking lot.
 */
public class ParkingLot {

    /**
     * Parking spots
     */
    private int[] spots = new int[10];

    /**
     * Parking tickets
     */
    private final List<ParkingTicket> tickets = new ArrayList<>();

    /**
     * Gets the number of available parking spaces.
     *
     * @return Total number of available spaces for parking.
     */
    public int getAvailableSpaces() {
        int scaces = 0;
        for (int i = 0; i < 10; i++) {
            if (spots[i] == 0) {
                scaces++;
            }
        }
        return scaces;
    }

    public int getNextAvailableSpace() {
        int spot = 0;
        for (int i = 0; i < 10; i++) {
            if (spots[i] == 0) {
                spot = i + 1;
                spots[i] = i + 1;
                break;
            }
        }
        return spot;
    }

    /**
     * Checks whether the parking spot is available
     *
     * @param spot Spot number
     */
    public boolean isFree(int spot) {
        return spots[spot - 1] == 0;
    }

    public void sipe() {
        System.out.print("\nSpot status : ");
        for (int i = 0; i < 10; i++) {
            System.out.print(spots[i] + "  ");
        }
        System.out.println();
    }

    /**
     * Check that the car is already parked
     *
     * @param plate Car plate number
     * @return True if the car is parked already
     */
    public boolean isCarParked(String plate) {
        String plateNumber = plate.trim().toLowerCase();

        for (int i = 0; i < tickets.size(); i++) {
            if (plateNumber.equals(tickets.get(i).getPlate().toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public void openTicket(ParkingTicket ticket) {
        this.tickets.add(ticket);
    }

    public void closeTicket(ParkingTicket ticket) {

    }

    public void showTickets() {
        for (ParkingTicket ticket : tickets) {
            System.out.println("Car number: " + ticket.getPlate());
            System.out.println("Car color: " + ticket.getCar().getColor());
            System.out.println("Car type: " + ticket.getCar().getType());

            System.out.println("Parking spot: " + ticket.getSpot());
            System.out.println("Parking Time: " + ticket.getEnterTime());
        }
    }
}