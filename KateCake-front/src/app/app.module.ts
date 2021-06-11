import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';
import {AuthComponent} from "./auth/auth.component";
import {ReactiveFormsModule} from "@angular/forms";

import {HomeModule} from './home/home.module';
import {CatalogModule} from './catalog-list/catalog.module';

import { OrderComponent } from './order/order.component';
import {UpdateProductComponent} from "./catalog-list/update-product/update-product.component";
import {AddProductComponent} from "./catalog-list/add-product/add-product.component";
import {ProductDetailedComponent} from "./catalog-list/product-detailed/product-detailed.component";

>>>>>>>>> Temporary merge branch 2
@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    OrderComponent,
    UpdateProductComponent,
    ProductDetailedComponent,
    AddProductComponent,
  ],
  imports: [
    BrowserModule,
    HomeModule,
    CatalogModule,
    BrowserAnimationsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
