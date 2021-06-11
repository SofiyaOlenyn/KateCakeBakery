import {Component} from '@angular/core'
  ;
import {HeaderComponent} from '../header.component';
import {CategoriesEnum} from '../../constants/categories.constant';

@Component({
  selector: 'app-header-shrunk',
  templateUrl: './header-shrunk.component.html',
  styleUrls: ['./header-shrunk.component.less']
})
export class HeaderShrunkComponent {

  constructor(public headerComponent: HeaderComponent) {
  }

  openNav(): void {
    (document.getElementById('header-shrunk') as HTMLElement).style.width = '100vw';
  }

  closeNav(): void {
    (document.getElementById('header-shrunk') as HTMLElement).style.width = '0';
  }

  changePath(category: CategoriesEnum): void {
    this.closeNav();
    this.headerComponent.changePath(category);
  }
}
