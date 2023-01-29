export interface WeatherForecast {
  /**
   * Count of returned observations.
   */
  count: number;

  data: ForecastDetail[];
}

export interface ForecastDetail {
  //   app_temp: number;
  //   aqi: number;
  //   city_name: string;
  //   clouds: number;
  //   country_code: string;
  //   datetime: string;
  //   dewpt: number;
  //   dhi: number;
  //   dni: number;
  //   elev_angle: number;
  //   ghi: number;
  //   gust: number;
  //   h_angle: number;
  //   lat: number;
  //   lon: number;
  //   ob_time: string;
  //   pod: string;
  //   precip: number;
  //   pres: number;
  //   rh: number;
  //   slp: number;
  //   snow: number;
  //   solar_rad: number;
  //   sources: string[];
  //   state_code: string;
  //   station: string;
  //   sunrise: string;
  //   sunset: string;

  /**
   * Temperature (default Celsius).
   */
  temp: number;

  //   timezone: string;
  //   ts: number;
  //   uv: number;
  //   vis: number;

  weather: {
    /**
     * Weather icon code.
     */
    code: number;

    /**
     * Weather code.
     */
    icon: string;

    /**
     * Text weather description.
     */
    description: string;
  };

  //   wind_cdir: string;

  /**
   * Verbal wind direction.
   */
  wind_cdir_full: string;

  //   wind_dir: number;
  //   wind_spd: number;
}

export enum TemperatureUnit {
  /**
   * Metric (Celsius, m/s, mm)
   */
  M,

  /**
   *  Scientific (Kelvin, m/s, mm)
   */
  S,

  /**
   * Fahrenheit (F, mph, in)
   */
  I,
}
