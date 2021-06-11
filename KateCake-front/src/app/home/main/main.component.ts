import {Component} from '@angular/core';
import {Router} from '@angular/router';

import {CategoriesEnum} from '../../shared/constants/categories.constant';
import {DataStorageService} from '../../shared/data-storage.service';
import {HeaderService} from '../../shared/header/header.service';

@Component({
  selector: 'app-home-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.less']
})
export class MainComponent {

  constructor(private router: Router,
              private dataStorage: DataStorageService,
              private headerService: HeaderService) {
  }

  toCakeCatalog(): void {
    this.headerService.changeActivatedItem(CategoriesEnum.Cakes);
    this.dataStorage.isLoading.next(true);
    this.router.navigate(['/catalog'], {
      queryParams: {type: CategoriesEnum.Cakes.toString()}
    });
  }
}
