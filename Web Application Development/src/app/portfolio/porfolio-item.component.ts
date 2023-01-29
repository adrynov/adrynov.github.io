import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';

import { PortfolioItem } from '../models';

@Component({
  selector: 'afd-portfolio-item',
  templateUrl: './portfolio-item.component.html',
})
export class PortfolioItemComponent implements OnInit {
  @Input('item')
  item?: PortfolioItem;

  @Output()
  deleted = new EventEmitter();

  constructor() {}

  ngOnInit() {
    // console.log(this.item);
  }

  handleClick(url: string | undefined) {
    if (!url) return;
    window.open(url, '_blank');
  }

  deleteItem() {
    this.deleted.emit(this.item);
  }
}
