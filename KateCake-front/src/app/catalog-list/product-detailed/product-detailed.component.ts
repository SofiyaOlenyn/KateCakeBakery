import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Subscription} from 'rxjs';
import {animate, state, style, transition, trigger} from '@angular/animations';

import {DataStorageService} from '../../shared/data-storage.service';
import {Product} from '../../shared/models/product.model';
import {CategoriesEnum} from '../../shared/constants/categories.constant';
import {TELEGRAM} from '../../shared/constants/socials.constant';

@Component({
  selector: 'app-product-detailed',
  templateUrl: './product-detailed.component.html',
  styleUrls: ['./product-detailed.component.less'],
  animations: [
    trigger('mainPhoto', [
      state('in', style({
        opacity: 1
      })),
      state('out', style({
        opacity: 0
      })),
      transition('* <=> *', [
        animate(300)
      ])
    ]),
  ]
})
export class ProductDetailedComponent implements OnInit, OnDestroy {
  productId: number;
  product: Product;
  productDetailedInfo: { title: string, value: any }[] = [];

  categoryName: CategoriesEnum;
  isLoading = true;
  subscription: Subscription[] = [];
  telegramLink = TELEGRAM.link;

  mainPhoto: string;
  mainPhotoState = 'in';

  token = localStorage.getItem('token');

  defaultImg = 'https://i.stack.imgur.com/y9DpT.jpg';

  constructor(private router: Router,
              private route: ActivatedRoute,
              private dataStorage: DataStorageService) {
  }

  ngOnInit(): void {
    this.subscribeToLoading();
    this.subscribeToProduct();
  }

  ngOnDestroy(): void {
    this.subscription.forEach(subscription => {
      subscription.unsubscribe();
    });
  }

  subscribeToLoading(): void {
    this.subscription.push(this.dataStorage.isLoading.subscribe(value => {
      this.isLoading = value;
    }));
  }

  subscribeToProduct(): void {
    this.subscription.push(this.route.queryParams.subscribe(async params => {
      this.categoryName = params.type as CategoriesEnum;
      this.productId = params.id;

      this.product = await this.dataStorage.fetchProductData(this.productId);
      this.changeProductInfo(this.product);
      this.mainPhoto = this.product.mainPhoto;
      this.isLoading = false;
    }));
  }

  changeMainPhoto(imagePath: string): void {
    this.mainPhotoState = 'out';
    setTimeout(() => {
      this.mainPhoto = imagePath;
    }, 300);
  }

  changeProductInfo(product: Product): void {
    this.productDetailedInfo = [
      {
        title: 'Ингридиенты',
        value: product.ingredients
      },
      {
        title: 'Возможные добавки',
        value: product.supplements
      },
      {
        title: 'Вес',
        value: product.weight
      },
      {
        title: 'Цена',
        value: product.price
      },
    ];
  }

  onDone($event): void {
    this.mainPhotoState = 'in';
  }

  onUpdate(): void {
    this.router.navigate(['/update-product'], {
      queryParams: {
        type: this.categoryName.toString(), id: this.productId
      }
    });
  }

  onAddToCartClicked(): void {
    this.dataStorage.cart.next(this.product)
    alert('Продукт був успішно додан!')
  }

  async onDelete(): Promise<void> {
    if (confirm('Вы уверены, что хотите удалить данный товар?')) {

      const response = await this.dataStorage.fetchDeleteProduct(localStorage.getItem('token'), this.productId);

      if (response.ok) {
        this.router.navigate(['/catalog'], {
          queryParams: {
            type: this.categoryName.toString()
          }
        });
      } else {
        alert('Упс.. что-то пошло не так..');
      }
    }
  }

  handleError = e => {
    e.target.onerror = null;
    e.target.src = this.defaultImg;
  };

  async logOut(): Promise<void> {
    const response = await this.dataStorage.fetchLogout(this.token);

    if (response.ok) {
      localStorage.setItem('token', null);
      this.router.navigate(['/home']);
    } else {
      alert('Упс.. что-то пошло не так..');
    }
  }
}
