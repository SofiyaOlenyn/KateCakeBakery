import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.less']
})
export class OrderComponent implements OnInit {
  orderForm: FormGroup;

  constructor() {}

  // tslint:disable-next-line:typedef
  ngOnInit() {
    this.orderForm = new FormGroup({
        name: new FormControl(null, [Validators.required]),
        email: new FormControl(null, [Validators.required, Validators.email]),
        phone: new FormControl(null, [Validators.required]),
      }
    );
  }

  // tslint:disable-next-line:typedef
  submitOrder() {
    console.log('Order was sent!')
  }
}
