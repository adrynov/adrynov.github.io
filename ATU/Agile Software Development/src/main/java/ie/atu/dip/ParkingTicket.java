package ie.atu.dip;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Parking ticket.
 */
public class ParkingTicket implements Comparable<ParkingTicket> {

    /**
     * Date and time of vehicle entry
     */
    private LocalDateTime enterTime;

    /**
     * Date and time of vehicle exit
     */
    private LocalDateTime exitTime;

    /**
     * The spot number on the parking.
     */
    private int spot;

    /**
     * Car details
     */
    private Car car;

    public ParkingTicket() {
        this.enterTime = LocalDateTime.now();
    }

    public Car getCar() {
        return car;
    }

    public String getPlate() {
        return car.getPlate();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getSpot() {
        return spot;
    }

    public void setSpot(int spot) {
        this.spot = spot;
    }

    public String getEnterTime() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        return enterTime.format(df);
    }

    /**
     * Two parking tickets are equal for the same car plate number.
     */
    @Override
    public int compareTo(ParkingTicket other) {
        return this.getCar().getPlate().compareTo(other.car.getPlate());
    }
}