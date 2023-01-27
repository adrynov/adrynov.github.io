package ie.atu.dip;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    private ParkingLot parkingLot;

    @BeforeEach
    void setUp() {
        parkingLot = new ParkingLot();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAvailableSpaces() {
        assertEquals(10, parkingLot.getAvailableSpaces());
    }

    @Test
    void getNextAvailableSpace() {
    }

    @Test
    void isFree() {
    }

    @Test
    void freeSpot() {
    }

    @Test
    void isCarParked() {
    }

    @Test
    void openTicket() {
    }

    @Test
    void closeTicket() {
    }
}