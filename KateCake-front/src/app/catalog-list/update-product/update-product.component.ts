import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {DataStorageService} from '../../shared/data-storage.service';
import {CategoriesEnum} from '../../shared/constants/categories.constant';
import {Product} from '../../shared/models/product.model';

@Component({
  selector: 'app-add-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.less']
})
export class UpdateProductComponent implements OnInit {
  updateProduct: FormGroup;
  token = localStorage.getItem('token');
  product: Product = null;

  constructor(private router: Router,
              private route: ActivatedRoute,
              private dataStorage: DataStorageService) {
  }

  async ngOnInit(): Promise<void> {

    if (!this.token) {
      this.router.navigate(['/home']);
    }

    this.updateProduct = new FormGroup({
        name: new FormControl(null, [Validators.required]),
        mainPhoto: new FormControl(null, [Validators.required]),
        ingredients: new FormControl(null, [Validators.required]),
        supplements: new FormControl(null, [Validators.required]),
        price: new FormControl(null, [Validators.required]),
        weight: new FormControl(null, [Validators.required]),
      }
    );

    this.initForm();
  }

  initForm(): void {
    this.route.queryParams.subscribe(async params => {
      const productId = params.id;
      this.product = await this.dataStorage.fetchProductData(productId);

      console.log(this.product);

      this.updateProduct.setValue(
        {
          name: this.product.name,
          mainPhoto: this.product.mainPhoto,
          ingredients: this.product.ingredients,
          supplements: this.product.supplements,
          price: this.product.price,
          weight: this.product.weight,
        });
    });
  }

  // tslint:disable-next-line:typedef
  async update() {
    const name = this.updateProduct.get('name').value;
    const mainPhoto = this.updateProduct.get('mainPhoto').value;
    const ingredients = this.updateProduct.get('ingredients').value;
    const supplements = this.updateProduct.get('supplements').value;
    const price = this.updateProduct.get('price').value;
    const weight = this.updateProduct.get('weight').value;

    this.route.queryParams.subscribe(async params => {
      const productType = params.type as CategoriesEnum;

      const response = await this.dataStorage.fetchUpdateProduct(
        localStorage.getItem('token'),
        {
          id: this.product.id,
          name,
          mainPhoto,
          productType: CategoriesEnum[productType].toLowerCase(),
          ingredients,
          supplements,
          price,
          weight
        });

      (response.id)
        ? this.router.navigate(['/catalog'], {
          queryParams: {
            type: productType
          }
        })
        : alert('Data is incorrect, try again!');
    });
  }

}
