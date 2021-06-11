import {RouterModule, Routes} from '@angular/router';
import {NgModule} from '@angular/core';

import {CatalogListComponent} from './catalog-list.component';
import {ProductDetailedComponent} from './product-detailed/product-detailed.component';
import {AddProductComponent} from './add-product/add-product.component';
import {UpdateProductComponent} from './update-product/update-product.component';

const appRoutes: Routes = [
  {
    path: '',
    component: CatalogListComponent
  },
  {
    path: 'products',
    component: ProductDetailedComponent
  },
  {
    path: 'add-product',
    component: AddProductComponent
  },
  {
    path: 'update-product',
    component: UpdateProductComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(appRoutes)
  ],
  exports: [RouterModule]
})
export class CatalogRoutingModule {
}
