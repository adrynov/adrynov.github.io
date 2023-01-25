package ie.atu.dip;

import com.maxmind.geoip2.record.City;
import com.maxmind.geoip2.record.Country;

/**
 * The current location (not exact) of the user.
 *
 * @param ipAddress Public IP address
 * @param city      City where the user might be located
 * @param country   Country where the user might be located
 */
public record UserLocation(String ipAddress, City city, Country country) {
}
