package ie.atu.dip;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Location information
 *
 * <p>
 * Example:
 *
 * <pre>{
 * "ip": "109.255.36.155",
 * "city": "Cork",
 * "region": "Munster",
 * "country": "IE",
 * "loc": "51.8980,-8.4706",
 * "org": "AS6830 Liberty Global B.V.",
 * "postal": "T23",
 * "timezone": "Europe/Dublin",
 * "readme": "https://ipinfo.io/missingauth"
 * }</pre>
 */
public class LocationInfo {

    private String ip;
    private String city;
    private String region;
    private String country;

    private String org;
    private String postal;
    private String timezone;
    private String readme;

    private String loc;

    public LocationInfo(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public void setIpAddress(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLoc() {
        return loc;
    }

    public void setCoords(String loc) {
        this.loc = loc;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getReadme() {
        return readme;
    }

    public void setReadme(String readme) {
        this.readme = readme;
    }

    public static LocationInfo fromString(String input) {
        if (input == null) return null;

        try {
            var json = new JSONObject(input);

            String ipAddress = json.getString("ip");
            String city = json.getString("city");
            String country = json.getString("country");
            String timezone = json.getString("timezone");
            String coordinates = json.getString("loc");

            LocationInfo info = new LocationInfo(ipAddress);
            info.setCity(city);
            info.setCountry(country);
            info.setCoords(coordinates);
            info.setTimezone(timezone);

            return info;

        } catch (JSONException e) {
            System.out.println("Failed to transform response" + e.getMessage());
            return null;
        }
    }
}
