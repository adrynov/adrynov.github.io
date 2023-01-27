package ie.atu.dip;

/**
 * Represents a parking lot.
 */
public class ParkingLot {

    /**
     * Parking spots
     */
    int[] spots = new int[10];

    public int SpotNum() {
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
     * Gets the number of available parking spaces.
     *
     * @return Total number of available spaces for parking.
     */
    public int getAvailableSpaces() {
        int scaces = 0;
        for (int i = 0; i < 10; i++) {
            if (spots[i] != 0) {
                return 1;
            } else if (spots[i] == 0) {
                scaces++;
            }
        }
        return scaces;
    }

    public void sipe() {
        System.out.print("\nSpot status : ");
        for (int i = 0; i < 10; i++) {
            System.out.print(spots[i] + "  ");
        }
        System.out.println();
    }

    public void FreeSpot(int num) {
        spots[num - 1] = 0;
    }
}