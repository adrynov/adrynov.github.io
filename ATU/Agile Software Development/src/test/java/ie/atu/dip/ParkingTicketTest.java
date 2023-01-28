package ie.atu.dip;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingTicketTest {

    private ParkingLot parking;
    private ParkingTicket ticket;

    @BeforeEach
    void setUp() {
        parking = new ParkingLot();
        ticket = new ParkingTicket();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void printTicketDetails() {
        // throws an exception as the ticket must be assigned to a car
        assertThrows(NullPointerException.class, ticket::print);

        Car car = new Car();
        car.setPlateNumber("ABC");

        ticket.setCar(car);

        assertEquals("ABC", ticket.getPlate());
    }

    @Test
    void setCarSpace() {
        Car car = new Car();
        car.setPlateNumber("TEST1");

        ticket.setCar(car);
        assertNotNull(ticket.getCar());

        int space = parking.getNextAvailableSpace();
        ticket.setSpace(space);

        assertEquals(1, ticket.getSpace());
        assertEquals(9, parking.getAvailableSpaces());
    }

    @Test
    void ticketsMatchByCarPlate() {
        Car car = new Car();
        car.setPlateNumber("TEST1");

        ticket.setCar(car);

        ParkingTicket ticket2 = new ParkingTicket();
        ticket2.setCar(car);

        assertEquals(ticket, ticket2);
    }
}