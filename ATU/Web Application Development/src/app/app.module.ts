import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

import { MainComponent } from './main/main.component';
import { PortfolioItemComponent } from './portfolio/porfolio-item.component';
import { PortfolioComponent } from './portfolio/portfolio.component';

import { HeroComponent } from './components/hero/hero.component';
import { ContactComponent } from './components/contact/contact.component';
import { FooterComponent } from './components/footer/footer.component';

const APP_COMPONENTS = [
  HeroComponent, ContactComponent, FooterComponent
];

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    PortfolioComponent,
    PortfolioItemComponent,
    ...APP_COMPONENTS
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
