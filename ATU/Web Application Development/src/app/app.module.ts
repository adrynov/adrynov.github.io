import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';

import { MainComponent } from './main/main.component';
import { PortfolioItemComponent } from './portfolio/porfolio-item.component';
import { PortfolioComponent } from './portfolio/portfolio.component';

import { AboutComponent } from './about/about.component';
import { ClientsComponent } from './components/clients/clients.component';
import { ContactComponent } from './components/contact/contact.component';
import { HeroComponent } from './components/hero/hero.component';
import { FaqComponent } from './components/faq/faq.component';
import { FooterComponent } from './components/footer/footer.component';
import { PricingComponent } from './components/pricing/pricing.component';
import { WhyusComponent } from './whyus/whyus.component';
import { SkillsComponent } from './skills/skills.component';
import { TeamComponent } from './team/team.component';
import { ServicesComponent } from './services/services.component';
import { CtaComponent } from './cta/cta.component';


const APP_COMPONENTS = [
  ClientsComponent, ContactComponent, FaqComponent, FooterComponent, HeroComponent, PricingComponent, AboutComponent, WhyusComponent
];

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    PortfolioComponent,
    PortfolioItemComponent,
    ...APP_COMPONENTS,
    SkillsComponent,
    TeamComponent,
    ServicesComponent,
    CtaComponent,
  ],
  imports: [BrowserModule, AppRoutingModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule { }
