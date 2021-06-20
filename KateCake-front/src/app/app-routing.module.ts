import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';
import {AuthComponent} from './auth/auth.component';
import {AddProductComponent} from './catalog-list/add-product/add-product.component';
import {OrderComponent} from './order/order.component';
import {OrderListComponent} from './order-list/order-list.component';

const appRoutes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    loadChildren: () => import('./home/home.module').then(m => m.HomeModule)
  },
  {
    path: 'catalog',
    loadChildren: () => import('./catalog-list/catalog.module').then(m => m.CatalogModule)
  },
  {
    path: 'auth',
    component: AuthComponent
  },
  {
    path: 'order',
    component: OrderComponent
  },
  {
    path: 'all-orders',
    component: OrderListComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
