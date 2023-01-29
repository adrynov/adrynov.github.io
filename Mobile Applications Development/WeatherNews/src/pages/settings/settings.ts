import { Component } from "@angular/core";
import { AlertController, ModalController, NavController } from "ionic-angular";

import { AboutDialog } from "../../components/about/about.dialog";
import { TemperatureUnit } from "../../models/weather";
import { StateProvider } from "../../services/state.service";

@Component({
  selector: "page-settings",
  templateUrl: "settings.html",
})
export class SettingsPage {
  constructor(
    private alertCtrl: AlertController,
    private modalCtrl: ModalController,
    public navCtrl: NavController,
    private state: StateProvider
  ) {}

  city: string = "";
  units: string;

  cityRegex = new RegExp(
    /^([a-zA-Z\u0080-\u024F]+(?:. |-| |'))*[a-zA-Z\u0080-\u024F]*$/,
    "i"
  );

  async ionViewWillEnter() {
    const { city, units } = await this.state.loadSettings();

    this.city = city;
    this.units = units || "M";
  }

  saveSettings() {
    // save selected units
    this.state.saveSelectedUnits(this.units);

    // user pressed Save but did not enter a city, show an alert
    if (!this.city) {
      let alert = this.alertCtrl.create({
        title: "City Required",
        subTitle: "Please enter a city name, or press back to exit",
        buttons: ["Dismiss"],
      });
      alert.present();
      return;
    }

    // try to validate the city name
    if (!this.cityRegex.test(this.city)) {
      let alert = this.alertCtrl.create({
        title: "Invalid City",
        subTitle: "Please enter a valid city name",
        buttons: ["Dismiss"],
      });
      alert.present();
      return;
    }

    // save the selected city
    this.state.saveSelectedCity(this.city.trim());

    // and go back
    if (this.navCtrl.canGoBack()) {
      this.navCtrl.popToRoot();
    }
  }

  /**
   * Displays About dialog.
   */
  showAbout() {
    let aboutModal = this.modalCtrl.create(AboutDialog);
    aboutModal.present();
  }
}
