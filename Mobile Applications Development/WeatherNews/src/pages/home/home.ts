import { Component } from "@angular/core";
import { ModalController, NavController } from "ionic-angular";

import { StateProvider } from "../../services/state.service";
import { SettingsPage } from "../settings/settings";
import { ApiService } from "../../services/api.service";

import { RestCountry } from "../../models/country";
import {
  ForecastDetail,
  TemperatureUnit,
  WeatherForecast,
} from "../../models/weather";
import { NewsPage } from "../news/news";

@Component({
  selector: "page-home",
  templateUrl: "home.html",
})
export class HomePage {
  // currently selected city
  city: string | null;
  country: string;

  units: string;
  degreeSymbol = "&deg;";

  // by restcountries.com
  countryInfo?: RestCountry;

  // by weatherbit.io
  forecastInfo?: ForecastDetail;

  // error message if the city is not valid etc.
  errorMessage = "";

  // show day of the week, i.e. "SUN"
  weekDay = new Date().toLocaleDateString("en-IE", {
    weekday: "short",
  });

  constructor(
    private navCtrl: NavController,
    private state: StateProvider,
    private webapi: ApiService
  ) {}

  ionViewWillEnter() {
    // load user preferences
    this.state.loadSettings().then((data) => {
      this.city = data.city;
      this.units = data.units;

      // attempt to fetch weather and news
      this.fetchCountryInfo();
    });
  }

  async fetchCountryInfo() {
    if (!this.city) {
      console.log("City is not known");
      return;
    }

    // clean up before fetching information
    this.countryInfo = null;
    this.errorMessage = "";

    // city is selected, fetch country information
    this.webapi.fetchCountryInfo(this.city).subscribe(
      (data) => {
        this.countryInfo = data && data[0]; // can return multiple countries
        this.country = this.countryInfo && this.countryInfo.name.common;

        // now fetch the weather
        this.fetchWeatherForecast();
      },
      (error) => {
        this.errorMessage =
          this.city + " not found. Try another city in Settings.";
      }
    );
  }

  private fetchWeatherForecast() {
    // now fetch the weather using latlng returned from restcountries.com
    const [lat, lng] = this.countryInfo.latlng;

    console.log("Fetching weather forecast for " + this.city);

    this.webapi.fetchCurrentForecast(lat, lng, this.units).subscribe(
      (data) => this.onWeatherForecastSuccess(data),
      (error) => {
        this.errorMessage = "Unable to fetch weather information";
        console.error(error);
      }
    );
  }

  onWeatherForecastSuccess(data: WeatherForecast): void {
    this.forecastInfo = data && data.data[0];
    console.log(this.forecastInfo);

    // update degree symbol
    // switch (this.units.toString()) {
    //   case "I":
    //     this.degreeSymbol = "&#8457;";
    //     break;
    //   case "S":
    //     this.degreeSymbol = "&#8490;";
    //     break;
    //   default:
    //     this.degreeSymbol = "&deg;";
    //     break;
    // }

    console.log(this.degreeSymbol);
  }

  /**
   * Navigate to the News page
   */
  openNews() {
    const countryCode = this.countryInfo.cca2 || "";
    this.navCtrl.push(NewsPage, { cca2: countryCode });
  }

  /**
   * Opens Settings screen for city selection.
   */
  selectCity() {
    this.showSettings();
  }

  /**
   * Opens Settings page.
   */
  showSettings() {
    this.navCtrl.push(SettingsPage);
  }
}
