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
      image: 'assets/img/portfolio/web-development.jpg',
      title: 'Web',
      description: 'Web Applications Development',
      kind: 'app',
      url: 'https://github.com/adrynov/adrynov.github.io/tree/main/Web%20Application%20Development'
    },
    {
      image: 'assets/img/portfolio/databases.png',
      title: 'Databases',
      description: 'Database Design and Implementation',
      kind: 'data',
      url: 'https://github.com/adrynov/adrynov.github.io/tree/main/Database%20Design%20and%20Development'
    },
    {
      image: 'assets/img/portfolio/convergence.jpg',
      title: 'Computers and Technology',
      description: 'Computer Architecture and Technology Convergence',
      kind: 'card',
      url: 'https://github.com/adrynov/adrynov.github.io/tree/main/Computer%20Architecture'
    },
    {
      image: 'assets/img/portfolio/oop.png',
      title: 'OOP',
      description: 'Object-Oriented Programming',
      kind: 'app',
      url: 'https://github.com/adrynov/adrynov.github.io/tree/main/Object%20Oriented%20Programming'
    },
  
    {
      image: 'assets/img/portfolio/cloud-computing.jpg',
      title: 'Cloud Computing',
      description: 'Operating Systems and Cloud Computing',
      kind: 'card',
      url: 'https://github.com/adrynov/adrynov.github.io/tree/main/Operating%20Systems%20and%20Cloud%20Computing'
    }, 
    {
      image: 'assets/img/portfolio/mobile2.png',
      title: 'Mobile',
      description: 'Mobile Application Development',
      kind: 'app',
      url: 'https://github.com/adrynov/adrynov.github.io/tree/main/Mobile%20Applications%20Development'
    },
    {
      image: 'assets/img/portfolio/networking.png',
      title: 'Networking',
      description: 'Network Technologies',
      kind: 'card',
      url: 'https://github.com/adrynov/adrynov.github.io/tree/main/Network%20Technologies'
    },
    {
      image: 'assets/img/portfolio/algorithms.png',
      title: 'Algorithms',
      description: 'Thinking with Algorithms',
      kind: 'web',
      url: 'https://github.com/adrynov/adrynov.github.io/tree/main/Thinking%20with%20Algorithms'
    },
  
    {
      image: 'assets/img/portfolio/scrum.jpg',
      title: 'Agile',
      description: 'Agile Software Development',
      kind: 'app',
      url: 'https://github.com/adrynov/adrynov.github.io/tree/main/Agile%20Software%20Development'
    },

  ];

  constructor() {}

  ngOnInit() {
    // console.log(this.items);
  }

  onItemDeleted(item: PortfolioItem) {
    if (this.items.includes(item)) {
      const index = this.items.indexOf(item);
      this.items.splice(index, 1);
    }
  }
}
