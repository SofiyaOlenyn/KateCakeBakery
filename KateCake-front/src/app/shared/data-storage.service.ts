import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {BehaviorSubject} from 'rxjs';


@Injectable({providedIn: 'root'})
export class DataStorageService {
  isLoading = new BehaviorSubject<boolean>(true);
  isCatalogChanged = new BehaviorSubject<boolean>(null);

  constructor(private http: HttpClient) {
  }

  // tslint:disable-next-line:typedef
  fetchLogin(formData) {
    return fetch('https://pure-crag-61716.herokuapp.com/my-login', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchReviewsData() {
    return fetch('https://pure-crag-61716.herokuapp.com/reviews', {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchAllCategoriesData() {
    return fetch(`https://pure-crag-61716.herokuapp.com/catalog`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchCatalogData(productType) {
    return fetch(`https://pure-crag-61716.herokuapp.com/catalog/${productType.toLowerCase()}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchProductData(productId) {
    return fetch(`https://pure-crag-61716.herokuapp.com/product/${productId}`, {
      method: 'GET',
      headers: {
        'Content-Type': 'application/json',
      },
    }).then(async response => await response.json());
  }

  // tslint:disable-next-line:typedef
  fetchAddProduct(token, data) {
    return fetch(`https://pure-crag-61716.herokuapp.com/product`, {
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
    return fetch(`https://pure-crag-61716.herokuapp.com/product`, {
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
    return fetch(`https://pure-crag-61716.herokuapp.com/product/${productId}`, {
      method: 'DELETE',
      headers: {
        'Content-Type': 'application/json',
        Authorization: token,
      },
    });
  }

  // tslint:disable-next-line:typedef
  fetchLogout(token) {
    return fetch('https://pure-crag-61716.herokuapp.com/logout', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        Authorization: token,
      },
    });
  }

}
