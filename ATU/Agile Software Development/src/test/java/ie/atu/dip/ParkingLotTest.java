package ie.atu.dip;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingLotTest {

    private ParkingLot parking;

    private Car car1, car2, car3;

    @BeforeEach
    void setUp() {
        parking = new ParkingLot();

        car1 = new Car();
        car2 = new Car();
        car3 = new Car();

        car1.setPlateNumber("ABC");
        car2.setPlateNumber("DEF");
        car3.setPlateNumber("XYZ");
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getAvailableSpaces() {
        assertEquals(10, parking.getAvailableSpaces());
    }

    @Test
    void getNextAvailableSpace() {
        assertEquals(1, parking.getNextAvailableSpace());
        assertEquals(2, parking.getNextAvailableSpace());
        assertEquals(3, parking.getNextAvailableSpace());
    }


    @Test
    void getCarEntryDetail() {
        Car car = new Car();
        car.setPlateNumber("TEST1");

        ParkingTicket ticket = new ParkingTicket();
        ticket.setCar(car);

        parking.openTicket(ticket);
        assertFalse(ticket.getEntry().isBlank());
    }


    @Test
    void isSpotFree() {
        assertTrue(parking.isFree(5));
    }

    @Test
    void freeSpot() {
        ParkingTicket ticket = new ParkingTicket();
        ticket.setCar(car2);

        int spot = parking.getNextAvailableSpace();
        ticket.setSpace(spot);

        // open ticket on Spot 1
        parking.openTicket(ticket);
        assertFalse(parking.isFree(1));

        // free the spot
        parking.freeSpot(spot);
        assertTrue(parking.isFree(1));
    }

    @Test
    void isCarParked() {
        ParkingTicket ticket = new ParkingTicket();
        ticket.setCar(car2);

        // car 2 is parked
        parking.openTicket(ticket);
        assertTrue(parking.isCarParked(car2.getPlateNumber()));

        // car 1 is not parked
        assertFalse(parking.isCarParked(car1.getPlateNumber()));
    }

    @Test
    void openTicket() {
    }

    @Test
    void closeTicket() {
        // car 1 is not parked -> no ticket to close
        assertNull(parking.closeTicket(car1.getPlateNumber()));

        // close ticket for car 2
        ParkingTicket ticket = new ParkingTicket();
        ticket.setCar(car2);
        parking.openTicket(ticket);

        ParkingTicket closedTicket = parking.closeTicket(car2.getPlateNumber());
        assertNotNull(closedTicket);

        assertFalse(closedTicket.getExit().isBlank());
    }
}