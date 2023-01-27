# Network Technologies

This project demonstrates my academic skills in developing network applications with Java.

The application retrieves the weather forecast for the user using IP geolocation services.

First, we obtain the user's IPv4 address by querying public servers.

In an ideal situation, the IP address will pinpoint to the city where the user is located.
The IP lookup is not 100% accurate because the user may be behind a proxy server, their ISP
may not be providing the real address, or is connected via VPN.
However, it is good enough for the demo.

Next we use the IP address to find the location information such as country/city/coordinates using either

- [IPInfo](https://ipinfo.io/)
- [GeoLite2 databases](https://dev.maxmind.com/geoip/geolite2-free-geolocation-data), a free offering by MaxMind.

Here is a sample output:

<pre>
*******************************************************
*   ATU - Dept. Computer Science & Applied Physics    *
*                                                     *
*            Network Programming Project              *
*                                                     *
*             Andrei Drynov (G00411287)               *
*******************************************************

Checking your local IP address
Local IP: 10.5.0.2
Hostname: HP

Finding your public IP address...
Public IP:194.156.227.75
Country code: IE
Found city: Dublin
Map location: https://www.google.com/maps/?q=Dublin
-------------------------------------------------------
Checking current weather conditions...

Current temperature: 6.67°C
Min/Max temperature: 3.53/6.67°C
Pressure: 1035.0 hPa
Humidity: 85.0 %
-------------------------------------------------------

Checking hourly weather forecast...

2023-01-26 00:00:00
Current temperature: 16.08°C
Min/Max temperature: 14.35/16.08°C
Pressure: 1027.0 hPa
Humidity: 50.0 %
Wind speed: 1.94 meter/sec
Wind degree: 38.0  (meteorological)
Wind gust: 4.37 meter/sec

</pre>

## Requirements

- JDK 11 or above
- Maven

This project was created using [IntelliJ IDEA](https://www.jetbrains.com/idea/) and the project can be
easily opened using the included **pom.xml**

Execute the main() method in th **Runner.java** class

## Credits

- [JSON Processing](https://www.oracle.com/technical-resources/articles/java/json.html)
- [Free Weather Data](https://openweathermap.org/)
- [Java APIs for OpenWeatherMap](https://github.com/iamashks/OWM-JAPIs) - develop weather-aware applications much easier

## Licensing

This project is licensed under Unlicense license. This license does not require you to take the license with you to your
project.