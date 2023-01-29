import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { MainComponent } from './layout/main.component';
import { HeroComponent } from './layout/hero/hero.component';

import { PortfolioItemComponent } from './portfolio/porfolio-item.component';
import { PortfolioComponent } from './portfolio/portfolio.component';
import { FooterComponent } from './layout/footer/footer.component';

import { AboutComponent } from './components/about/about.component';
import { ClientsComponent } from './components/clients/clients.component';
import { ContactComponent } from './components/contact/contact.component';
import { CtaComponent } from './components/cta/cta.component';
import { FaqComponent } from './components/faq/faq.component';
import { PricingComponent } from './components/pricing/pricing.component';
import { SkillsComponent } from './components/skills/skills.component';
import { ServicesComponent } from './components/services/services.component';
import { TeamComponent } from './components/team/team.component';
import { WhyusComponent } from './components/whyus/whyus.component';


const APP_LAYOUT = [
  FooterComponent, HeroComponent, 
];

const APP_COMPONENTS = [
  ClientsComponent, ContactComponent, FaqComponent,  PricingComponent, AboutComponent, WhyusComponent
];

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    PortfolioComponent,
    PortfolioItemComponent,
    ...APP_LAYOUT,
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
