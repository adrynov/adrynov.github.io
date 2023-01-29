import { Component } from '@angular/core';

/**
 * Generated class for the ComponentsWeatherComponent component.
 *
 * See https://angular.io/api/core/Component for more info on Angular
 * Components.
 */
@Component({
  selector: 'weather-card',
  templateUrl: 'weather.component.html',
  styles: [`
    .weather-card {
      position: relative;
      text-align: center !important;
    }
  `]
})
export class WeatherCardComponent {

  text: string;

  constructor() {
    console.log('Hello ComponentsWeatherComponent Component');
    this.text = 'Hello World';
  }

}

