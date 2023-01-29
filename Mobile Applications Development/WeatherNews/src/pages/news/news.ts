import { Component } from "@angular/core";
import { NavController, NavParams } from "ionic-angular";

import { Article } from "../../models/news";

import { ApiService } from "../../services/api.service";

@Component({
  selector: "page-news",
  templateUrl: "news.html",
})
export class NewsPage {
  countryCode: string; // required by the News API

  articles: Article[];

  constructor(
    private navCtrl: NavController,
    private navParams: NavParams,
    private webapi: ApiService
  ) {
    this.countryCode = this.navParams.get("cca2");
  }

  ionViewWillEnter() {
    this.webapi.fetchTopHeadlines(this.countryCode).subscribe((data) => {
      if (data && data.articles && data.articles.length > 0)
        this.articles = data.articles;
    });
  }
}
