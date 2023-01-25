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
 * @version 1.1
 */
public class Runner {

    public static void main(String[] args) {
        showMachineInfo();

        // we need the public IP address for the city and weather lookup
        String ipAddress = determinePublicAddress();

        if (ipAddress == null || ipAddress.isBlank()) {
            System.out.println("Unable to get your public IP address. Verify your Internet connectivity.");
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
        System.out.println("Your country: " + location.getCountry());
        System.out.println("Your city: " + location.getCity());

        // create a city link to Google Maps
        String mapLink = "https://www.google.com/maps/?q=" + location.getCity();
        System.out.println("Approximate location on the map: " + mapLink);
    }

    /**
     * Determines the public IP address of the client machine.
     *
     * @return IP address
     */
    private static String determinePublicAddress() {
        String publicAddress = "";

        try {
            publicAddress = NetworkingUtils.getPublicAddress().trim();

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return publicAddress;
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
            info = GeoUtils.getLocationInfo(address);

            // request to IPInfo failed, try another way
            if (info == null) {
                // send the IP address to GeoLite in order to get the city and country
                info = GeoUtils.getInstance().queryLocationByAddress(address);
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

    private static void showMachineInfo() {
        try {
            // machine name
            InetAddress localAddress = InetAddress.getLocalHost();
            System.out.println("Hostname: " + localAddress.getHostName());

            // local IP address
            System.out.println("LAN IP: " + NetworkingUtils.getLocalIpAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}