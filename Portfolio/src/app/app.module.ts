import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { FooterComponent } from './components/footer.component';
import { HeaderComponent } from './components/header.component';
import { HeroComponent } from './components/hero.component';
import { MainComponent } from './components/main.component';

@NgModule({
  declarations: [AppComponent, MainComponent, FooterComponent, HeaderComponent, HeroComponent],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
