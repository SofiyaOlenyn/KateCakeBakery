import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {DataStorageService} from "../shared/data-storage.service";
import {Product} from "../shared/models/product.model";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.less']
})
export class OrderComponent implements OnInit {
  orderForm: FormGroup;
  allItems: Product[];

  constructor(private router: Router,
              private route: ActivatedRoute,
              private dataStorage: DataStorageService,) {}

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.orderForm = new FormGroup({
        name: new FormControl(null, [Validators.required]),
        email: new FormControl(null, [Validators.required, Validators.email]),
        phone: new FormControl(null, [Validators.required]),
      }
    );

    this.allItems = this.dataStorage.cart.getValue();
  }

  // tslint:disable-next-line:typedef
  submitOrder() {
    alert('Замовлення було відправлено.');
    this.dataStorage.cart.next([])
    this.router.navigate(['/home']);
  }
}
