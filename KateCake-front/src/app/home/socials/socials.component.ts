import {Component, HostListener, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {take} from 'rxjs/operators';

import {PHOTOS_EXPANDED, PHOTOS_SHRUNK} from '../../shared/constants/social-carousel-photos.constant';
import {CategoriesEnum} from '../../shared/constants/categories.constant';
import {HeaderItemInterface} from '../../shared/models/header-item.interface';
import {DataStorageService} from '../../shared/data-storage.service';
import {HeaderService} from '../../shared/header/header.service';

@Component({
  selector: 'app-home-socials',
  templateUrl: './socials.component.html',
  styleUrls: ['./socials.component.less']
})
export class SocialsComponent implements OnInit {
  screenWidth: number;
  photosRow = [];
  headerItemArray: HeaderItemInterface[] = [];
  headerItemArrayRight: HeaderItemInterface[] = [];
  headerItemArrayLeft: HeaderItemInterface[] = [];

  constructor(private router: Router,
              private dataStorage: DataStorageService,
              private headerService: HeaderService) {
  }

  ngOnInit(): void {
    this.initializePhotos();
    this.initializeHeaderItems();
  }

  initializePhotos(): void {
    this.screenWidth = window.innerWidth;
    this.screenWidth > 770
      ? this.photosRow = PHOTOS_EXPANDED
      : this.photosRow = PHOTOS_SHRUNK;
  }

  initializeHeaderItems(): void {
    this.headerService.headerItemsSubject
      .pipe(take(1))
      .subscribe(
        header => {
          this.headerItemArray = header;
        });

    this.headerItemArrayRight = this.headerItemArray.slice(0, 3);
    this.headerItemArrayLeft = this.headerItemArray.slice(3, 5);
  }

  @HostListener('window:resize', ['$event'])
  onResize(event): void {
    this.screenWidth = event.target.innerWidth;
  }

  changePath(categoryId: CategoriesEnum): void {
    this.headerService.changeActivatedItem(categoryId);
    this.dataStorage.isLoading.next(true);
    this.router.navigate(['/catalog'], {
      queryParams: {type: categoryId.toString()}
    });
  }
}
