package ie.atu.dip;

import net.aksingh.owmjapis.api.APIException;
import net.aksingh.owmjapis.core.OWM;
import net.aksingh.owmjapis.model.CurrentWeather;
import net.aksingh.owmjapis.model.HourlyWeatherForecast;
import net.aksingh.owmjapis.model.param.Main;
import net.aksingh.owmjapis.model.param.Wind;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

/**
 * Get weather forecast using OpenWeatherMap Java API.
 */
public class WeatherForecast {

    // OpenWeatherMap API key created for the ATU review.
    private final OWM owm = new OWM("b19bf3ef38b71369bee12511f5816570");

    WeatherForecast() {
    }

    /**
     * Checks current weather conditions in the given city.
     *
     * @param location Location info
     */
    public void getCurrentWeather(LocationInfo location) {
        String city = location.getCity();

        try {
            // there are several Dublin cities in the world, better provide the country
            OWM.Country country = switch (location.getCountry()) {
                case "GB" -> OWM.Country.UNITED_KINGDOM;
                case "NO" -> OWM.Country.NORWAY;
                case "SE" -> OWM.Country.SWEDEN;
                case "BE" -> OWM.Country.BELGIUM;
                case "DE" -> OWM.Country.GERMANY;
                case "FR" -> OWM.Country.FRANCE;
                case "IT" -> OWM.Country.ITALY;
                default -> OWM.Country.IRELAND; // OWM.Country.valueOf(location.getCountry());
            };

            // fetch current weather for the city and country
            CurrentWeather weather = owm.currentWeatherByCityName(city, country);

            // checks if the retrieved data has a response code or not
            if (!weather.hasRespCode() || weather.getRespCode() != 200) {
                System.out.println("No current weather info from OpenWeather API");
                return;
            }

            if (!weather.hasMainData() || weather.getMainData() == null) {
                System.out.println("No current weather provided by OpenWeatherMap");
                return;
            }

            printMainData(weather.getMainData());

        } catch (Exception e) {
            System.out.println("Unable to get current weather. " + e.getMessage());
            e.printStackTrace();
        }
    }


    /**
     * Checks hourly weather forecast in the city.
     *
     * @param city  City
     * @param total How many forecasts to show
     */
    public void getHourlyForecast(String city, int total) {

        try {
            HourlyWeatherForecast forecast = owm.hourlyWeatherForecastByCityName(city);

            // checks if the retrieved data has a response code or not
            if (!forecast.hasRespCode() || !forecast.getRespCode().equals("200")) {
                System.out.println("No hourly weather forecast from OpenWeather API");
                return;
            }

            if (!forecast.hasDataList() || forecast.getDataList() == null) {
                System.out.println("No hourly weather forecast provided by OpenWeatherMap");
                return;
            }

            var hourlyData = forecast.getDataList().stream().limit(total).toList();

            for (var data : hourlyData) {
                System.out.println(data.getDateTimeText());
                printMainData(data.getMainData());
                printWindInfo(data.getWindData());

                System.out.println();
            }

        } catch (APIException e) {
            System.out.println("Unable to get hourly weather. " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Prints the temperature, pressure and humidity data.
     */
    private void printMainData(Main mainData) {
        if (mainData == null) return;

        double temp = kelvinToCelcius.apply(mainData.getTempMax());
        double tempMin = kelvinToCelcius.apply(mainData.getTempMin());
        double tempMax = kelvinToCelcius.apply(mainData.getTempMax());

        System.out.println("Current temperature: " + round(temp, 2) + "°C");
        System.out.println("Min/Max temperature: " + round(tempMin, 2) + "/" + round(tempMax, 2) + "°C");

        if (mainData.hasPressure()) {
            var pressure = mainData.getPressure();
            System.out.println("Pressure: " + pressure + " hPa");
        }

        if (mainData.hasHumidity()) {
            var humidity = mainData.getHumidity();
            System.out.println("Humidity: " + humidity + " %");
        }
    }

    private void printWindInfo(Wind wind) {
        if (wind == null) return;

        if (wind.hasSpeed()) {
            System.out.println("Wind speed: " + wind.getSpeed() + " meter/sec");
        }

        if (wind.hasDegree()) {
            System.out.println("Wind degree: " + wind.getDegree() + "  (meteorological)");
        }

        if (wind.hasGust()) {
            System.out.println("Wind gust: " + wind.getGust() + " meter/sec");
        }
    }

    //<editor-fold desc="Helpers">

    /**
     * Converts Kelvin to Celsius
     */
    private final Function<Double, Double> kelvinToCelcius = (degree) -> degree - 273.15;

    /**
     * Round double value to n decimal places
     *
     * @param value  Double value, e.g. 7.8700000000000045
     * @param places Number of decimal places to keep
     * @return Rounded double, e.g. 7.87
     */
    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    //</editor-fold>
}

