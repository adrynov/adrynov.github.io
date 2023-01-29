package ie.atu.dip;

import java.util.Random;

/**
 * A car.
 */
public class Car {
    private String plate;
    private String color; //red, yellow, green, etc..
    private String type;

    public String getPlateNumber() {
        return plate;
    }

    public void setPlateNumber(String NumberPlate) {
        this.plate = NumberPlate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String CarColor) {
        this.color = CarColor;
    }

    public String getType() {
        return type;
    }

    public void setType(String CarType) {
        this.type = CarType;
    }

    /**
     * Generates a random car.
     */
    public static Car randomCar(String plate) {
        Car car = new Car();
        String color = CAR_COLOUR[random.nextInt(CAR_COLOUR.length)];
        String type = CAR_TYPE[random.nextInt(CAR_TYPE.length)];

        car.setColor(color);
        car.setPlateNumber(plate);
        car.setType(type);

        return car;
    }

    private static final Random random = new Random();

    private static final String[] CAR_COLOUR = {"Red", "Yellow", "Green", "white", "Brown", "Violet", "Pink"};
    private static final String[] CAR_TYPE = {"Sedan", "van", "Minivan", "Bus", "Pickup-truck", "Hatchback"};
}