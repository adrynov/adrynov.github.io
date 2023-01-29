import { Injectable } from "@angular/core";
import { Storage } from "@ionic/storage";
import { TemperatureUnit } from "../models/weather";

/**
 * Store app state in Ionic Storage (https://ionicframework.com/docs/v3/storage).
 *
 * There are better-scaling solutions, but they are more complex.
 */
@Injectable()
export class StateProvider {
  constructor(private storage: Storage) {}

  public async getSelectedCity(): Promise<string> {
    return await this.get("city");
  }

  public async saveSelectedCity(city: string): Promise<any> {
    await this.set("city", city);
  }

  public async getSelectedUnits(): Promise<string> {
    return await this.get("units");
  }

  public async saveSelectedUnits(units: string): Promise<any> {
    await this.set("units", units);
  }

  async loadSettings() {
    const city = await this.getSelectedCity();
    const units = await this.getSelectedUnits();

    return { city, units };
  }

  saveSettings(city: string, units: string) {
    // save selected city
    if (city) {
      this.saveSelectedCity(city);
    }

    // save selected units
    this.saveSelectedUnits(units);
  }

  private async set(key: string, value: any): Promise<any> {
    try {
      await this.storage.set(key, value);
    } catch (error) {
      console.error("Failed to save item", error);
    }
  }

  private async get(key: string): Promise<any> {
    try {
      return await this.storage.get(key);
    } catch (error) {
      console.error("Failed to load item", error);
    }
  }

  async setObject(key: string, value: any): Promise<any> {
    try {
      await this.storage.set(key, JSON.stringify(value));
    } catch (error) {
      console.error("Failed to save item", error);
    }
  }

  async getObject(key: string): Promise<any> {
    try {
      const data = await this.storage.get(key);
      return JSON.parse(data);
    } catch (error) {
      console.error("Failed to load item", error);
    }
  }

  private clear() {
    this.storage.clear();
  }
}
