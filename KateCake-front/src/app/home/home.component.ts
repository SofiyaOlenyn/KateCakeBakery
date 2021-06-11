import {Component, OnDestroy, OnInit} from '@angular/core';
import {Subscription} from 'rxjs';

import {Review} from '../shared/models/review.model';
import {Category} from '../shared/models/category.model';
import {DataStorageService} from '../shared/data-storage.service';
import {ActivatedRoute, Router} from '@angular/router';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.less']
})
export class HomeComponent implements OnInit, OnDestroy {
  reviews: Review[] = null;
  assortmentCategories: Category[] = null;
  subscription: Subscription;
  isLoading = true;
  token = localStorage.getItem('token');

  constructor(private router: Router,
              private route: ActivatedRoute,
              private dataStorage: DataStorageService) {
  }

  ngOnInit(): void {
    this.subscribeToLoading();
    this.subscribeToAssortmentData();
    this.subscribeToReviewsData();
  }

  ngOnDestroy(): void {
    this.subscription.unsubscribe();
  }

  subscribeToLoading(): void {
    this.subscription = this.dataStorage.isLoading.subscribe(value => {
      this.isLoading = value;
    });
    this.isLoading = false;
  }

  async subscribeToAssortmentData(): Promise<void> {
    this.assortmentCategories = await this.dataStorage.fetchAllCategoriesData();
    this.isLoading = false;
  }

  async subscribeToReviewsData(): Promise<void> {
    this.reviews = await this.dataStorage.fetchReviewsData();
    this.isLoading = false;
  }

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
