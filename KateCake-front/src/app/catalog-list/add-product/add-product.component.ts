import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {ActivatedRoute, Router} from '@angular/router';
import {DataStorageService} from '../../shared/data-storage.service';
import {CategoriesEnum} from '../../shared/constants/categories.constant';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.less']
})
export class AddProductComponent implements OnInit {
  addProduct: FormGroup;
  token = localStorage.getItem('token');

  constructor(private router: Router,
              private route: ActivatedRoute,
              private dataStorage: DataStorageService) {
  }

  ngOnInit(): void {

    if (!this.token) {
      this.router.navigate(['/home']);
    }

    this.addProduct = new FormGroup({
        name: new FormControl(null, [Validators.required]),
        mainPhoto: new FormControl(null, [Validators.required]),
        ingredients: new FormControl(null, [Validators.required]),
        supplements: new FormControl(null, [Validators.required]),
        price: new FormControl(null, [Validators.required]),
        weight: new FormControl(null, [Validators.required]),
      }
    );
  }

  async add(): Promise<void> {
    const name = this.addProduct.get('name').value;
    const mainPhoto = this.addProduct.get('mainPhoto').value;
    const ingredients = this.addProduct.get('ingredients').value;
    const supplements = this.addProduct.get('supplements').value;
    const price = this.addProduct.get('price').value;
    const weight = this.addProduct.get('weight').value;

    this.route.queryParams.subscribe(async params => {
      const productType = params.type as CategoriesEnum;

      const response = await this.dataStorage.fetchAddProduct(
        localStorage.getItem('token'),
        {
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
