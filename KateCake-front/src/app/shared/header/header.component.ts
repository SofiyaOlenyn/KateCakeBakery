import {Component, HostListener, OnDestroy, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {Subscription} from 'rxjs';

import {CategoriesEnum} from '../constants/categories.constant';
import {DataStorageService} from '../data-storage.service';
import {HeaderService} from './header.service';
import {HeaderItemInterface} from '../models/header-item.interface';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.less']
})
export class HeaderComponent implements OnInit, OnDestroy {
  screenWidth: number;
  headerItemArray: HeaderItemInterface[] = [];
  subscription: Subscription;

  constructor(private router: Router,
              private dataStorage: DataStorageService,
              private headerService: HeaderService) {
  }

  ngOnInit(): void {
    this.screenWidth = window.innerWidth;
    this.subscription = this.headerService.headerItemsSubject.subscribe(
      header => {
        this.headerItemArray = header;
      });
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  @HostListener('window:resize', ['$event'])
  onResize(event): void {
    this.screenWidth = event.target.innerWidth;
  }

  changePath(categoryId: CategoriesEnum): void {
    this.headerService.changeActivatedItem(categoryId);
    this.dataStorage.isLoading.next(true);
    this.dataStorage.isCatalogChanged.next(true);
    this.router.navigate(['/catalog'], {
      queryParams: {type: categoryId.toString()}
    });
  }

  unactivateAllLinks(): void {
    this.headerService.unactivateAll();
    this.router.navigate(['/home']);
  }
}
