package ie.atu.dip;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * This application fetches a weather forecast using user's current location.
 * <p>
 * The location is determined using the computer public IP address.
 * User's city and country are determined using the GeoLite service.
 * Weather forecast is provided by OpenWeather API using the city.
 *
 * @author Andrei Drynov
 * @version 1.2
 */
public class Runner {

    public static void main(String[] args) {
        showBanner();

        try {
            showMachineInfo();
        } catch (Exception e) {
            System.out.println("Please check your Internet connection. Unable to ping remote servers");
            System.exit(1);
            return;
        }

        // we need the public IP address for the city and weather lookup
        String ipAddress = AddressFinder.getPublicAddress();

        if (ipAddress == null || ipAddress.isBlank()) {
            System.out.println("Please check your Internet connection. Unable to get your public IP address.");
            System.exit(1);
            return;
        }

        // fetch location information using the IP address
        LocationInfo location = fetchAddressData(ipAddress);

        // we need the city name to lookup weather
        if (location == null) {
            System.exit(1);
            return;
        }

        System.out.println("Public IP:" + ipAddress);

        // show city and country detail
        System.out.println("Country code: " + location.getCountry());
        System.out.println("Found city: " + location.getCity());

        // create a city link to Google Maps
        String mapLink = "https://www.google.com/maps/?q=" + location.getCity();
        System.out.println("Map location: " + mapLink);

        printSeparator('-');
        System.out.println("Checking current weather conditions...");
        System.out.println();

        // check current weather in the city
        var forecast = new WeatherForecast();
        forecast.getCurrentWeather(location);

        printSeparator('-');
        System.out.println("Checking hourly weather forecast...");
        System.out.println();

        // get hourly weather forecasts (only 4 for brevity)
        forecast.getHourlyForecast(location.getCity(), 4);
    }

    /**
     * Fetches the location data such as city and country by calling IPs.
     *
     * @param address IP address
     * @return IP address data (city, country, lat/lng)
     */
    private static LocationInfo fetchAddressData(String address) {
        LocationInfo info = null;

        try {
            // fetch location detail by querying https://ipinfo.io
            info = LocationParser.getLocationInfo(address);

            // request to IPInfo failed, try another way
            if (info == null) {
                // send the IP address to GeoLite in order to get the city and country
                info = LocationParser.getInstance().queryLocationByAddress(address);
            }

            // we still could not look up IP address data
            if (info == null) {
                return null;
            }


        } catch (IOException e) {
            System.out.println("Unable to get location information. " + e.getMessage());
        }

        // we have the city and country!
        return info;
    }

    /**
     * Prints some statistics.
     */
    private static void showMachineInfo() {
        try {
            // local IP address
            System.out.println("Local IP: " + AddressFinder.getLocalIpAddress());

            // machine name
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Hostname: " + localAddress.getHostName());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    //<editor-fold desc="Helpers">

    private static void showBanner() {
        printSeparator('*');
        System.out.println("*   ATU - Dept. Computer Science & Applied Physics    *");
        System.out.println("*                                                     *");
        System.out.println("*            Network Programming Project              *");
        System.out.println("*                                                     *");
        System.out.println("*             Andrei Drynov (G00411287)               *");
        printSeparator('*');

        System.out.println();
    }

    /**
     * The length of the separator line in informational blocks.
     */
    private static final int SEPARATOR_LEN = 55;

    private static void printSeparator(char separator) {
        String line = String.valueOf(separator).repeat(SEPARATOR_LEN);
        System.out.println(line);
    }

    //</editor-fold>
}