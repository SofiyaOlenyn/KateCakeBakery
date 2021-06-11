import {Injectable} from '@angular/core';
import {BehaviorSubject} from 'rxjs';
import {HeaderItemInterface} from '../models/header-item.interface';
import {CategoriesEnum} from '../constants/categories.constant';
import {HEADER_ITEMS} from '../constants/header-items.constant';

@Injectable()
export class HeaderService {
  headerItems = HEADER_ITEMS;
  headerItemsSubject = new BehaviorSubject<HeaderItemInterface[]>(this.headerItems);

  changeActivatedItem(type: CategoriesEnum): void {
    this.headerItems.forEach(item => {
      +item.enumParam === +type
        ? item.activated = true
        : item.activated = false;
    });
    this.headerItemsSubject.next(this.headerItems);
  }

  unactivateAll(): void {
    this.headerItems.forEach(item => {
      item.activated = false;
    });
    this.headerItemsSubject.next(this.headerItems);
  }
}
