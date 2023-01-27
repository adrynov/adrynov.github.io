package ie.atu.dip;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParkingTicketTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void sameCarHasSimilarTickets() {
        Car car = new Car();
        car.setPlateNumber("TEST1");

        ParkingTicket ticket1 = new ParkingTicket();
        ticket1.setCar(car);

        ParkingTicket ticket2 = new ParkingTicket();
        ticket2.setCar(car);

        assertEquals(ticket1, ticket2);
    }
}