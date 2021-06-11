import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {CatalogListComponent} from './catalog-list.component';
import {CatalogRoutingModule} from './catalog-routing.module';
import {SharedModule} from '../shared/shared.module';
import {ProductDetailedComponent} from './product-detailed/product-detailed.component';
import {AddProductComponent} from './add-product/add-product.component';
import {ReactiveFormsModule} from '@angular/forms';
import {UpdateProductComponent} from './update-product/update-product.component';

@NgModule({
  declarations: [
    CatalogListComponent,
    ProductDetailedComponent,
    AddProductComponent,
    UpdateProductComponent
  ],
  imports: [
    CommonModule,
    CatalogRoutingModule,
    SharedModule,
    ReactiveFormsModule,
  ],
  exports: [
    CatalogListComponent,
    ProductDetailedComponent
  ],
  providers: [],
})
export class CatalogModule {
}
