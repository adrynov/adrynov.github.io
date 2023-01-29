/**
 * Response models of restcountries.com
 */

export interface Translation {
  official: string;
  common: string;
}

export interface NativeName {
  eng: Translation;
  gle: Translation;
}

export interface CountryName {
  common: string;
  official: string;
  nativeName?: NativeName;
}

export interface RestCountry {
  /**
   * Country name (with variants)
   */
  name: CountryName;

  // tld:          string[];

  /**
   * The 2-letter ISO 3166-1 code of the country
   */
  cca2: string;

  // ccn3:         string;
  // cca3:         string;
  // cioc:         string;
  // independent:  boolean;
  // status:       string;
  // unMember:     boolean;
  // currencies:   Currencies;
  // idd:          Idd;
  // capital:      string[];
  // altSpellings: string[];
  // region:       string;
  // subregion:    string;
  // languages:    Languages;
  // translations: { [key: string]: Translation };

  /**
   * Latitude and Longitude
   */
  latlng: number[];

  // landlocked:   boolean;
  // borders:      string[];
  // area:         number;
  // demonyms:     Demonyms;
  // flag: string;
  flags: {
    png: string;
    svg: string;
  };
  // maps:         Maps;
  // population:   number;
  // gini:         Gini;
  // fifa:         string;
  // car:          Car;
  // timezones:    string[];
  // continents:   string[];

  // coatOfArms:   CoatOfArms;
  // startOfWeek:  string;
  // capitalInfo:  CapitalInfo;
}

// export interface REwSTCountry {}

// export interface CapitalInfo {
//   latlng: number[];
// }

// export interface Car {
//   signs: string[];
//   side: string;
// }

// export interface CoatOfArms {
//   png: string;
//   svg: string;
// }

// export interface Currencies {
//   EUR: Eur;
// }

// export interface Eur {
//   name: string;
//   symbol: string;
// }

// export interface Demonyms {
//   eng: Eng;
//   fra: Eng;
// }

// export interface Eng {
//   f: string;
//   m: string;
// }

// export interface Gini {
//   "2017": number;
// }

// export interface Idd {
//   root: string;
//   suffixes: string[];
// }

// export interface Languages {
//   eng: string;
//   gle: string;
// }

// export interface Maps {
//   googleMaps: string;
//   openStreetMaps: string;
// }
