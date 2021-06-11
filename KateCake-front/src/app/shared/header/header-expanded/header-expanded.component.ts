import {Component, OnInit} from '@angular/core';

import {HeaderComponent} from '../header.component';
import {HeaderItemInterface} from '../../models/header-item.interface';

@Component({
  selector: 'app-header-expanded',
  templateUrl: './header-expanded.component.html',
  styleUrls: ['./header-expanded.component.less']
})
export class HeaderExpandedComponent implements OnInit {
  headerItemArrayRight: HeaderItemInterface[] = [];
  headerItemArrayLeft: HeaderItemInterface[] = [];

  constructor(public headerComponent: HeaderComponent) {
  }

  ngOnInit(): void {
    this.initializeHeaderItems();
  }

  initializeHeaderItems(): void {
    this.headerItemArrayRight = this.headerComponent.headerItemArray.slice(0, 3);
    this.headerItemArrayLeft = this.headerComponent.headerItemArray.slice(3, 5);
  }
}
