package ie.atu.dip;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Parking ticket.
 */
public class ParkingTicket {

    /**
     * Date and time of vehicle entry
     */
    private LocalDateTime entry;

    /**
     * Date and time of vehicle exit
     */
    private LocalDateTime exit;

    /**
     * Parking space number.
     */
    private int space;

    /**
     * Car details
     */
    private Car car;

    public ParkingTicket() {
        this.entry = LocalDateTime.now();
    }

    public Car getCar() {
        return car;
    }

    public String getPlate() {
        return car.getPlateNumber();
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public int getSpace() {
        return space;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public String getEntry() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        return entry.format(df);
    }

    public String getExit() {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("HH:mm:ss");
        return exit.format(df);
    }

    public void setExitTime() {
        this.exit = LocalDateTime.now();
    }

    /**
     * Two parking tickets are equal for the same car plate number.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ParkingTicket ticket = (ParkingTicket) o;
        return car.equals(ticket.car);
    }

    @Override
    public int hashCode() {
        return Objects.hash(car);
    }

    /**
     * Prints ticket detail
     */
    public void print() {
        System.out.println("Car number: " + this.getPlate());
        System.out.println("Car color: " + this.getCar().getColor());
        System.out.println("Car type: " + this.getCar().getType());

        System.out.println("Parking spot: " + this.getSpace());
        System.out.println("Parking time: " + this.getEntry());

        if (this.exit != null) {
            System.out.println("Exit time: " + this.getExit());
        }

        int diff[] = Payment.calculateTimeDifference(this.entry, this.exit);
        float amount = Payment.calculateAmount(diff[0], diff[1]);

//        System.out.println("\n\t\t=== Your  ===\n" +
//                "Car Number : " + tickets.get(spot1).getAssignedCar().getNumberPlate() +
//                "    Car Color : " + tickets.get(spot1).getAssignedCar().getCarColor() +
//                "    Car Type : " + tickets.get(spot1).getAssignedCar().getCarType() +
//                "\nParking Time : " + tickets.get(spot1).getTime() +
//                "    Exit Time : " + exittime +
//                "\nParking Date : " + tickets.get(spot1).getDate() +
//                "    Exit Date :" + exitdate +
//                "    Spot Number : " + tickets.get(spot1).getSpotNumber() +
//                "\nTotal Time : " + time[0] + " Hour " + time[1] + " Minute " +
//                "\nTotal Amount : " + amount + " rupees\n"
//        );
    }
}