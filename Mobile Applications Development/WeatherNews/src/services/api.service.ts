import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs/Observable";

import { RestCountry } from "../models/country";
import { Headlines } from "../models/news";
import { TemperatureUnit, WeatherForecast } from "../models/weather";

/**
 * Provider for accessing remote APIs.
 *
 * Country info: https://restcountries.com/#api-endpoints-v3
 */
@Injectable()
export class ApiService {
  countriesApi = "https://restcountries.com/v3.1";
  weatherApi = "https://api.weatherbit.io/v2.0";

  NEWS_APIKEY = "59eb50818bdc455db0903aae655a9d13";
  WEATHER_APIKEY = "11e6f680bff6402fac54147b1960a325";

  constructor(public http: HttpClient) {}

  /**
   * Fetch information about a country (by its capital city)
   */
  public fetchCountryInfo(city: string): Observable<RestCountry> {
    const url = `${this.countriesApi}/capital/${city}`;
    return this.http.get<RestCountry>(url);
  }

  /**
   * Read weather information for the country the city is in.
   *
   * https://www.weatherbit.io/api/weather-current
   *
   * @param lat City latitude
   * @param lng City longitude
   * @param units Units
   */
  public fetchCurrentForecast(
    lat: number,
    lng: number,
    units: string
  ): Observable<WeatherForecast> {
    const url = `${this.weatherApi}/current?units=${units}&lat=${lat}&lon=${lng}&key=${this.WEATHER_APIKEY}`;
    console.log("Weather API: " + url);

    return this.http.get<WeatherForecast>(url);
  }

  /**
   * This endpoint provides live top and breaking headlines for a country, specific category in a country,
   * single source, or multiple sources.
   *
   * @param countryCode The 2-letter ISO 3166-1 code of the country you want to get headlines for
   */
  public fetchTopHeadlines(countryCode: string): Observable<Headlines> {
    const url = `https://newsapi.org/v2/top-headlines?country=${countryCode}&apiKey=${this.NEWS_APIKEY}&pageSize=5`;
    console.log("Headlines API: " + url);

    return this.http.get<Headlines>(url);
  }

  // private get(endpoint: string, params?: any, reqOpts?: any) {
  //   if (!reqOpts) {
  //     reqOpts = {
  //       params: new HttpParams(),
  //     };
  //   }

  //   // Support easy query params for GET requests
  //   if (params) {
  //     reqOpts.params = new HttpParams();
  //     for (let k in params) {
  //       reqOpts.params = reqOpts.params.set(k, params[k]);
  //     }
  //   }

  //   return this.http.get(this.url + "/" + endpoint, reqOpts);
  // }

  // private post(endpoint: string, body: any, reqOpts?: any) {
  //   return this.http.post(this.url + "/" + endpoint, body, reqOpts);
  // }
}
