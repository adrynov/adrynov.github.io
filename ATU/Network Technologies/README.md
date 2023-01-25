# Network Technologies

This project showcases my academic qualifications in Network Application Development in Java.

The application fetches a weather forecast using IP geolocation services.

First we acquire the user's IPv4 address by querying public servers.
In an ideal situation, the IP address will pinpoint to the city where the user is located.

The IP lookup is not always exact since the user might be behind a proxy server, their ISP
does not provide the real address, or they connected via VPN.

Next we find the user location such as country/city/coordinates using the public IP address
and [GeoLite2 databases](https://dev.maxmind.com/geoip/geolite2-free-geolocation-data).

GeoIP2 is a free offering by MaxMind and as such the IP Geolocation is imprecise.
It is still good enough for our requirements.

## Requirements

Get geographic location data from an IP address using the .

Geolocation is vital in this application.

Use the Accuracy Radius as an indication of geolocation accuracy for the latitude and longitude coordinates we return
for an IP address. The actual location of the IP address is likely within the area defined by this radius and the
latitude and longitude coordinates.