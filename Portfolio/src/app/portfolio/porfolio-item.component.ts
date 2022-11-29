import { Component, Input, OnInit } from '@angular/core';

import { PortfolioItem } from '../models';

@Component({
  selector: 'afd-portfolio-item',
  templateUrl: './portfolio-item.component.html',
})
export class PortfolioItemComponent implements OnInit {
  @Input('item')
  item?: PortfolioItem;

  constructor() {}

  ngOnInit() {
    console.log(this.item);
  }
}
