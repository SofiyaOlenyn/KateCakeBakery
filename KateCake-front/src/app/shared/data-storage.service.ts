import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {map, take} from 'rxjs/operators';
import {BehaviorSubject, Observable, Subject} from 'rxjs';

import {CategoriesEnum} from './constants/categories.constant';
import {Product} from './models/product.model';

@Injectable({providedIn: 'root'})
export class DataStorageService {
  isLoading = new BehaviorSubject<boolean>(true);
  isCatalogChanged = new BehaviorSubject<boolean>(null);
  cart = new BehaviorSubject<Product[]>([]);

  constructor(private http: HttpClient) {
  }

  // tslint:disable-next-line:typedef
  fetchLogin(formData) {
    console.log(JSON.stringify(formData));
    return fetch('http://localhost:3000/my-login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchReviewsData() {
    return fetch('http://localhost:3000/reviews', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchAllCategoriesData() {
    return fetch(`http://localhost:3000/catalog`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchCatalogData(productType) {
    return fetch(`http://localhost:3000/catalog/${productType.toLowerCase()}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchProductData(productId) {
    return fetch(`http://localhost:3000/product/${productId}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchAddProduct(token, data) {
    return fetch(`http://localhost:3000/product`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: token,
      },
      body: JSON.stringify(data),
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchUpdateProduct(token, data) {
    console.log(data);
    return fetch(`http://localhost:3000/product`, {
      method: 'PATCH',
      headers: {
        'Content-Type': 'application/json',
        Authorization: token,
      },
      body: JSON.stringify(data),
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchDeleteProduct(token, productId) {
    return fetch(`http://localhost:3000/product/${productId}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
        Authorization: token,
      },
    });
  }

  // tslint:disable-next-line:typedef
  fetchLogout(token) {
    return fetch('http://localhost:3000/logout', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: token,
      },
    });
  }

  // tslint:disable-next-line:typedef
  fetchPlaceOrder(formData) {
    return fetch('http://localhost:3000/order', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    }).then(async response => await response);
  }

  // tslint:disable-next-line:typedef
  fetchGetAllOrders(page, token) {
    console.log('page');
    console.log(page);
    return fetch(`http://localhost:3000/orders?page=${page}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
        Authorization: token,
      },
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchChangeOrderStatus(formData, token) {
    console.log(formData);
    return fetch('http://localhost:3000/order-status-changed', {
    method: 'PATCH',
      headers: {
      'Content-Type': 'application/json',
        Authorization: token,
    },
    body: JSON.stringify(formData),
  }).then(async response => await response);
}

}
