import { BrowserModule } from "@angular/platform-browser";
import { ErrorHandler, NgModule } from "@angular/core";
import { HttpClientModule } from "@angular/common/http";

import { IonicApp, IonicErrorHandler, IonicModule } from "ionic-angular";

import { IonicStorageModule } from "@ionic/storage";
import { SplashScreen } from "@ionic-native/splash-screen";
import { StatusBar } from "@ionic-native/status-bar";

import { MyApp } from "./app.component";

// Pages and modals
import { HomePage } from "../pages/home/home";
import { NewsPage } from "../pages/news/news";
import { SettingsPage } from "../pages/settings/settings";

import { AboutDialog } from "../components/about/about.dialog";

// providers and services
import { ApiService } from "../services/api.service";
import { StateProvider } from "../services/state.service";
import { PipesModule } from "../pipes/pipes.module";

@NgModule({
  declarations: [MyApp, HomePage, NewsPage, SettingsPage, AboutDialog],
  imports: [
    BrowserModule,
    IonicModule.forRoot(MyApp),
    IonicStorageModule.forRoot(),
    HttpClientModule,
    // customer modules
    PipesModule,
  ],
  bootstrap: [IonicApp],
  entryComponents: [MyApp, HomePage, NewsPage, SettingsPage, AboutDialog],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: ErrorHandler, useClass: IonicErrorHandler },
    // custom providers and services
    ApiService,
    StateProvider,
  ],
})
export class AppModule {}
