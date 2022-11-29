import { Component, OnInit } from '@angular/core';
import { PortfolioItem } from '../models';

@Component({
  selector: 'afd-portfolio',
  templateUrl: './portfolio.component.html',
  styleUrls: ['./portfolio.component.scss'],
})
export class PortfolioComponent implements OnInit {
  items: PortfolioItem[] = [
    {
      id: 1,
      image: 'assets/img/portfolio/portfolio-1.jpg',
      title: 'App 1',
      description: 'App',
      kind: 'app',
    },
    {
      id: 2,
      image: 'assets/img/portfolio/portfolio-2.jpg',
      title: 'Web 3',
      description: 'Web',
      kind: 'web',
    },
    {
      id: 5,
      image: 'assets/img/portfolio/portfolio-5.jpg',
      title: 'Web 2',
      description: 'Web',
      kind: 'web',
    },
    {
      id: 3,
      image: 'assets/img/portfolio/portfolio-3.jpg',
      title: 'App 2',
      description: 'App',
      kind: 'app',
    },
    {
      id: 4,
      image: 'assets/img/portfolio/portfolio-4.jpg',
      title: 'Card 2',
      description: 'Card',
      kind: 'card',
    },
    {
      id: 6,
      image: 'assets/img/portfolio/portfolio-6.jpg',
      title: 'App 3',
      description: 'App',
      kind: 'app',
    },
    {
      id: 7,
      image: 'assets/img/portfolio/portfolio-7.jpg',
      title: 'Card 1',
      description: 'card',
      kind: 'card',
    },
    {
      id: 8,
      image: 'assets/img/portfolio/portfolio-8.jpg',
      title: 'Card 3',
      description: 'Card',
      kind: 'card',
    },
    {
      id: 9,
      image: 'assets/img/portfolio/portfolio-9.jpg',
      title: 'Web 3',
      description: 'Web',
      kind: 'web',
    },
  ];

  constructor() {}

  ngOnInit() {
    console.log(this.items);
  }
}
