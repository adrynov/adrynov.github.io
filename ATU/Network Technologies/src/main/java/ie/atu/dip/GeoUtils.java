package ie.atu.dip;

import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URL;
import java.net.URLConnection;

/**
 * Determines the user location by parsing their IP address.
 * <p>
 * Using GeoLite API (free tier) and the GeoIP2 client library:
 * https://dev.maxmind.com/geoip/geolite2-free-geolocation-data
 *
 * @author Andrei Drynov
 */
public class GeoUtils {

    /**
     * GeoLite account ID.
     */
    private final static int GEOIP_ACCOUNT = 817943;

    /**
     * License key for MaxMind's GeoLite services.
     * <p>
     * Normally I would hide secrets such keys, credentials etc. in environment variables,
     * but I left it exposed in this project for the easier portfolio review by ATU.
     */
    private final static String GEOIP_API_KEY = "qaQLGDGUYZeJ5yyd";

    // https://www.maxmind.com/en/accounts/817943/people/ced80fb3-3b13-491d-8768-291fbb152953
//    Account ID:

    /**
     * Accessing GeoLite2 service to get the City and Country by IP address.
     *
     * @param address IP address
     */
    public LocationInfo queryLocationByAddress(String address) {
        System.out.println("Looking up city and country by IPv4 address");

        // configure a GeoIP2 client object
        try (var client = new WebServiceClient.Builder(GEOIP_ACCOUNT, GEOIP_API_KEY).host("geolite.info").build()) {

            // resolve the location by IP
            InetAddress ipAddress = InetAddress.getByName(address);
            CountryResponse country = client.country(ipAddress);
            CityResponse city = client.city(ipAddress);

            LocationInfo info = new LocationInfo(address);
            info.setCountry(country.getCountry().getName());
            info.setCity(city.getCity().getName());

            return info;

        } catch (IOException | GeoIp2Exception e) {
            e.printStackTrace();
            System.out.println("Unable to query the desired geolocation service. " + e.getMessage());
            return null;
        }
    }


    /**
     * Gets location information by querying <a href="https://ipinfo.io">IP Info</a>
     *
     * @param address IP address
     * @return {@link UserLocation} User's location
     */
    public static LocationInfo getLocationInfo(String address) throws IOException {
        StringBuilder response = new StringBuilder();

        URL url = new URL("https://ipinfo.io/" + address + "/json");
        URLConnection connection = url.openConnection();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
            String line;

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }

        // convert JSON to location object
        return LocationInfo.fromString(response.toString());
    }

    //<editor-fold desc="Singleton">

    // Lazy initialization
    private static final GeoUtils INSTANCE = new GeoUtils();

    /**
     * Returns the instance using Singleton pattern.
     *
     * @return Singleton of this class
     */
    public static GeoUtils getInstance() {
        return INSTANCE;
    }

    private GeoUtils() {

    }

    //</editor-fold>

}
