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

    public void freeSpot(int spot) {
        spots[spot - 1] = 0;
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

    /**
     * The car has exited the parking lot.
     *
     * @param plateNumber Car registration
     * @return Removed ticket
     */
    public ParkingTicket closeTicket(String plateNumber) {
        for (int i = 0; i < tickets.size(); i++) {
            if (plateNumber.equals(tickets.get(i).getPlate())) {
                ParkingTicket ticket = tickets.get(i);
                ticket.setExitTime();

                // free the spot
                this.freeSpot(i + 1);

                // remove the ticket
                this.tickets.remove(ticket);
                return ticket;
            }
        }

        return null;
    }

}