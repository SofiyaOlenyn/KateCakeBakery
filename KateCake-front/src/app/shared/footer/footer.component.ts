import {Component, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {take} from 'rxjs/operators';

import {CategoriesEnum} from '../constants/categories.constant';
import {DataStorageService} from '../data-storage.service';
import {HeaderItemInterface} from '../models/header-item.interface';
import {HeaderService} from '../header/header.service';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.less']
})
export class FooterComponent implements OnInit {
  headerItemArray: HeaderItemInterface[] = [];

  constructor(private router: Router,
              private dataStorage: DataStorageService,
              private headerService: HeaderService) {
  }

  ngOnInit(): void {
    this.headerService.headerItemsSubject
      .pipe(take(1))
      .subscribe(
        header => {
          this.headerItemArray = header;
        });
  }

  changePath(categoryId: CategoriesEnum): void {
    this.headerService.changeActivatedItem(categoryId);
    this.dataStorage.isLoading.next(true);
    this.router.navigate(['/catalog'], {
      queryParams: {type: categoryId.toString()}
    });
  }
}
